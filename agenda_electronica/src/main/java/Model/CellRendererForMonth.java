package Model;

import java.awt.Component;
import java.awt.Font;
;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clasa CellRendererForMonth adauga un stil pentru tabelul de evenimente dintr-o luna
 * 
 * @author Elena
 */
public class CellRendererForMonth extends DefaultTableCellRenderer {

    /**
     * Obiect Map cu indicile zilei ca cheie si lista de culori a evenimentelor din acea zi ca valoare
     */
    Map<Integer, List<String>> map;

    /**
     * Constructor CellRendererForMonth
     * 
     * @param evenimente lista de obiecte Zi cu evenimente
     */
    public CellRendererForMonth(List<Zi> evenimente) {
        map = new HashMap<Integer, List<String>>();
        int i = 0;
        for (Zi evtZi : evenimente) {
            List<String> colors = new ArrayList<String>();
            if (!evtZi.getEventList().isEmpty()) {
                for (Eveniment evt : evtZi.getEventList()) {
                    colors.add(evt.getCuloare());
                }
            }
            map.put(i++, colors);
        }
    }

    /**
     * Defineste un renderer pentru celulele dintr-un JTable
     * 
     * @param table tabelul JTable care cere rendererul; poate fi null
     * @param value valoarea celulei asupra carei se aplica renderer
     * @param isSelected true daca celulei i se va aplica rendererul; altfel false
     * @param hasFocus data true, aplica rendererul in mod corespunzator
     * @param row indexul liniei celulei
     * @param column indexul coloanei celulei
     * @return componenta folosita pentru a desena celula
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Zi) {
            Zi evt = (Zi) value;
            if (evt != null) {
                Integer date = dateToDay(evt.getDate());
                this.setText(date.toString());
                if (date != null && (date.intValue() - 1) < map.size()) {
                    int pos = date.intValue() - 1;

                    if (map.get(pos).size() > 1) {
                        this.setFont(this.getFont().deriveFont(Font.BOLD));
                    } else if (map.get(pos).size() == 1) {
                        this.setBackground(CellRendererForWeek.HexToColor(map.get(pos).get(0)));
                    } else {
                        this.setBackground(null);
                    }
                } else {
                    this.setBackground(null);
                }
            } else {
                this.setBackground(null);
            }
        } else {
            this.setBackground(null);
        }
        return this;
    }

    /**
     * Transforma data in zi a lunii
     * 
     * @param date date data de declansare a evenimentului
     * @return ziua din luna corespunzatoare
     */
    private Integer dateToDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
