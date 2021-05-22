package View;

import Controller.Agenda;
import Model.CellRendererForMonth;
import Model.CellRendererForWeek;
import Model.ElementRendererForList;
import Model.Eveniment;
import Model.Zi;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * Clasa CalendarFiller populeaza tabelele si listele din agenda cu infomatii despre evenimente
 * 
 * @author Elena
 */
public class CalendarFiller {

    /**
     * Ziua selectata in agenda
     */
    public static int date;
    /**
     * Luna selectata in agenda
     */
    public static int month;
    /**
     * Anul selectat in agenda
     */
    public static int year;

    /**
     * Populeaza modele de JTable cu valori default
     * 
     * @param table tabelul sau tabelele care urmeaza sa fie populate
     */
    public static void addModel(JTable... table) {
        for (int i = 0; i < table.length; i++) {
            DefaultTableModel mod = new DefaultTableModel();
            table[i].setModel(mod);
            table[i].setShowGrid(true);
            ((DefaultTableCellRenderer) table[i].getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            if (table.length > 1) {
                mod.addColumn("S");
                mod.addColumn("M");
                mod.addColumn("T");
                mod.addColumn("W");
                mod.addColumn("T");
                mod.addColumn("F");
                mod.addColumn("S");
            } else {
                mod.addColumn("Sunday");
                mod.addColumn("Monday");
                mod.addColumn("Tuesday");
                mod.addColumn("Wednesday");
                mod.addColumn("Thursday");
                mod.addColumn("Friday");
                mod.addColumn("Saturday");
            }
        }
    }

    /**
     * Populeaza tabelele cu informatii despre evenimente
     *
     * @param panelSelected modul de afisare selectat
     * @param table tabelul sau tabelele care urmeaza sa fie populate cu date
     */
    public static void fillInTable(int panelSelected, JTable... table) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.RIGHT);
        int currentMonth = month - 1;
        int day = 1;
        for (int i = 0; i < table.length; i++) {
            if (table.length > 1) {
                currentMonth = i;
            }
            int a;
            DefaultTableModel mod = (DefaultTableModel) table[i].getModel();
            table[i].setBackground(Color.WHITE);
            int rowCount = mod.getRowCount();
            if (rowCount > 0) {
                for (a = 1; a <= rowCount; a++) {
                    mod.removeRow(rowCount - a);
                }
            }
            for (a = 0; a < 7; a++) {
                table[i].getColumnModel().getColumn(a).setCellRenderer(renderer);
            }
            if (panelSelected == 2) {
                mod.setRowCount(1);
                try {
                    addWeekToTable(table[i], mod);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarFiller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                mod.setRowCount(6);
                try {
                    addMonthToTable(table[i], mod, currentMonth, day);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarFiller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Populeaza lista cu informatii despre evenimente
     *
     * @param panelSelected modul de afisare selectat
     * @param eventList lista care urmeaza sa fie populata cu date
     * @throws java.text.ParseException
     */
    public static void fillInList(int panelSelected, JList eventList) throws ParseException {
        List<Eveniment> evenimente;
        Calendar calendar = Calendar.getInstance();
        int currentMonth = month - 1;
        calendar.set(year, currentMonth, date);
        Date data = calendar.getTime();
        DefaultListModel dList = new DefaultListModel();
        eventList.setCellRenderer(new ElementRendererForList());
        if (panelSelected == 4) {
            evenimente = Agenda.SelectareEvente(data, "ALL").getEventList();
            sortListByDate(evenimente);
            for (Eveniment evt : evenimente) {
                dList.addElement(evt);
            }
        } else if (panelSelected == 3) {
            evenimente = Agenda.SelectareEvente(data, "DAY").getEventList();
            sortListByDate(evenimente);
            for (Eveniment evt : evenimente) {
                dList.addElement(evt);
            }
        }
        eventList.setModel(dList);
    }

    /**
     * Sortează lista după dată
     *
     * @param originalList lista care urmeaza sa fie sortata
     */
    public static void sortListByDate(List<Eveniment> originalList) {
        Comparator<Eveniment> compareByDate = (Eveniment o1, Eveniment o2) -> o1.getInceput().compareTo(o2.getInceput());
        Collections.sort(originalList, compareByDate);
    }

    /**
     * Adauga evenimentele dintr-o luna in tabel
     *
     * @param table tabelul care urmeaza sa fie populat cu evenimente
     * @param model obiectul DefaultTableModel cu care lucram
     * @param currentMonth luna evenimentului
     * @param day ziua evenimentului
     * @throws java.text.ParseException
     */
    private static void addMonthToTable(JTable table, DefaultTableModel model, int currentMonth, int day) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.set(year, currentMonth, day);
        int start = cal.get(cal.DAY_OF_WEEK);
        int maxdays = cal.getActualMaximum(cal.DAY_OF_MONTH);
        start--;
        int j = 0;
        Date data = cal.getTime();
        List<Zi> evenimente = Agenda.SelectareEvente(data, "MONTH").getEventList();
        Iterator<Zi> iter = evenimente.iterator();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new CellRendererForMonth(evenimente));
        }
        for (int a = 1; a <= maxdays; a++) {
            Zi evt = iter.next();
            model.setValueAt(evt, j, start);
            start++;
            if (start == 7) {
                start = 0;
                j++;
            }
        }
    }

    /**
     * Adauga evenimentele dintr-o saptamana in tabel
     *
     * @param table tabelul care urmeaza sa fie populat cu evenimente
     * @param model obiectul DefaultTableModel cu care lucram
     * @throws java.text.ParseException
     */
    private static void addWeekToTable(JTable table, DefaultTableModel model) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = month - 1;
        calendar.set(year, currentMonth, date);
        Date data = calendar.getTime();
        List<Zi> evenimente = Agenda.SelectareEvente(data, "WEEK").getEventList();
        int i = 0, counter, size = 0;
        for (Zi evtZi : evenimente) {
            counter = 0;
            table.getColumnModel().getColumn(i).setCellRenderer(new CellRendererForWeek(evtZi));
            List<Eveniment> evts = evtZi.getEventList();
            if (!evts.isEmpty()) {
                for (Eveniment evt : evtZi.getEventList()) {
                    if (evt.getInactiveState() == false) {
                        model.setValueAt(evt, counter, i);
                        counter++;
                        if (counter > size) {
                            size++;
                            model.addRow(new Object[]{});
                        }
                    }
                }
            }
            i++;
        }
    }
}
