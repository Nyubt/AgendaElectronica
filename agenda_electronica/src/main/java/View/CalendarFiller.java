/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Agenda;
import Model.CellRendererForMonth;
import Model.CellRendererForWeek;
import Model.ElementRendererForList;
import Model.Eveniment;
import Model.Saptamana;
import Model.Zi;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Elena
 */
public class CalendarFiller {
    public static int date;
    public static int month;
    public static int year;    
    public static void addModel(JTable... table){
        for(int i=0; i<table.length; i++){
            DefaultTableModel mod=new DefaultTableModel();
            table[i].setModel(mod);
            table[i].setShowGrid(true);
            ((DefaultTableCellRenderer)table[i].getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            if(table.length > 1){
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
            //mod.setRowCount(6);
        }
    }
    
    public static void fillInTable(int panelSelected, JTable... table){
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.RIGHT);
        int currentMonth = month - 1;
        int day = 1;
        //System.out.println(panelSelected);
        for(int i = 0; i < table.length; i++){
            if(table.length > 1){
                currentMonth = i;
            }
            int a;
            DefaultTableModel mod = (DefaultTableModel)table[i].getModel();
            table[i].setBackground(Color.WHITE);
            int rowCount = mod.getRowCount();
            if(rowCount > 0){
                for(a = 1; a <= rowCount; a++){
                    mod.removeRow(rowCount - a);
                }
            }
            for(a = 0; a < 7; a++){
                table[i].getColumnModel().getColumn(a).setCellRenderer(renderer);
            }
            if(panelSelected == 2){
                mod.setRowCount(1);
                try {
                    addWeekToTable(table[i], mod);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarFiller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {    
                mod.setRowCount(6);        
                try {
                    /*Calendar cal = Calendar.getInstance();
                    cal.set(year, currentMonth, day);
                    int start = cal.get(cal.DAY_OF_WEEK);
                    int maxdays = cal.getActualMaximum(cal.DAY_OF_MONTH);
                    start--;
                    int j = 0;
                    for(a = 1; a <= maxdays; a++){
                    mod.setValueAt(a, j, start);
                    start++;
                    if(start==7){
                    start=0;
                    j++;
                    }
                    }*/
                    addMonthToTable(table[i], mod, currentMonth, day);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarFiller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void fillInList(int panelSelected, JList eventList) throws ParseException{
        List<Eveniment> evenimente;
        Calendar calendar = Calendar.getInstance();
        int currentMonth = month - 1;
        calendar.set(year, currentMonth, date);
        Date data = calendar.getTime();
        DefaultListModel dList = new DefaultListModel();
        eventList.setCellRenderer(new ElementRendererForList());
        if(panelSelected == 4){
            evenimente = Agenda.SelectareEvente(data, "ALL").getEventList();
            sortListByDate(evenimente);
            for(Eveniment evt : evenimente){
                dList.addElement(evt);
                /*dList.addElement(evt.getInceput() + " Name: " + evt.getTitlu() + "Id: " + evt.getEvenimentId() + " Duration: " + 
                        getDateDiff(evt.getInceput(),evt.getSfarsit(),TimeUnit.MINUTES));*/
            }
        } else if(panelSelected == 3) {
            evenimente = Agenda.SelectareEvente(data, "DAY").getEventList();
            sortListByDate(evenimente);
            for(Eveniment evt : evenimente){
                dList.addElement(evt);
                /*dList.addElement(evt.getInceput() + " Name: " + evt.getTitlu()  + " Id: " + evt.getEvenimentId() + " Duration: " + 
                        getDateDiff(evt.getInceput(),evt.getSfarsit(),TimeUnit.MINUTES)/60 + " hours");*/
            }
        }
        eventList.setModel(dList);   
    }
    
    public static void sortListByDate(List<Eveniment> originalList){
        Comparator<Eveniment> compareByDate = (Eveniment o1, Eveniment o2) -> o1.getInceput().compareTo(o2.getInceput()); 
        Collections.sort(originalList, compareByDate);
    }
    
    private static void addMonthToTable(JTable table, DefaultTableModel model, int currentMonth, int day) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.set(year, currentMonth, day);
        int start = cal.get(cal.DAY_OF_WEEK);
        int maxdays = cal.getActualMaximum(cal.DAY_OF_MONTH);
        start--;
        int j = 0;
        Date data = cal.getTime();
        List <Zi> evenimente = Agenda.SelectareEvente(data, "MONTH").getEventList();
        Iterator<Zi> iter = evenimente.iterator();
        //table.setDefaultRenderer(String.class, new CellRendererForMonth(evenimente));
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new CellRendererForMonth(evenimente));
        }
        //System.out.println("Month! " + currentMonth);
        for(int a = 1; a <= maxdays; a++){
            Zi evt = iter.next();
            //System.out.println(evt.getDate());
            //System.out.println(evt.getEventList());
            //System.out.println(evt.getEventList().size());
            //model.setValueAt(a, j, start);
            model.setValueAt(evt, j, start);
            start++;
            if(start==7){
                start=0;
                j++;
            }
        }
    }
    
    private static void addWeekToTable(JTable table, DefaultTableModel model) throws ParseException{ 
        //System.out.println("1");
        Calendar calendar = Calendar.getInstance();
        int currentMonth = month - 1;
        calendar.set(year, currentMonth, date);
        //System.out.println("2");
        Date data = calendar.getTime();
        //System.out.println("3");
        List <Zi> evenimente = Agenda.SelectareEvente(data, "WEEK").getEventList();
        //System.out.println(evenimente);
        //System.out.println("4");
        //int current = calendar.get(calendar.DAY_OF_WEEK);
        int i = 0, counter, size = 0;
        for(Zi evtZi : evenimente){
            counter = 0;
            /*int n = (i - current + 1);
            Date dateBefore = new Date(data.getTime() + n * 24 * 3600 * 1000l);
            evenimente = Agenda.SelectareEvente(dateBefore, "DAY").getEventList(); */
            table.getColumnModel().getColumn(i).setCellRenderer(new CellRendererForWeek(evtZi));
            List <Eveniment> evts = evtZi.getEventList();
            if(!evts.isEmpty()){
                for (Eveniment evt : evtZi.getEventList()) {
                    if (evt.getInactiveState() == false){
                        //Calendar cal = Calendar.getInstance();
                        calendar.setTime(evt.getInceput());
                        String time = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE);  
                        model.setValueAt(time + " " + evt.getTitlu(), counter, i);
                        counter++;
                        if(counter > size){
                            size++;
                            model.addRow(new Object[] {});
                        }
                    }
                }
            }
            i++;
        }
    }
}
