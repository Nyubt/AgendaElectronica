package Model;

import java.awt.Component;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clasa CellRendererForWeek specifica un stil pentru tabelul de evenimente dintr-o saptamana
 * 
 * @author Elena
 */
public class CellRendererForWeek extends DefaultTableCellRenderer {

    /**
     * Lista de culori
     */
    private List<String> colors;
    /**
     * Instanta a obiectului Calendar
     */
    Calendar calendar = Calendar.getInstance();

    /**
     * Constructor CellRendererForWeek
     */
    public CellRendererForWeek() {
    }

    /**
     * Constructor CellRendererForWeek
     * 
     * @param evenimente obiect Zi cu evenimentele din ziua respectiva
     */
    public CellRendererForWeek(Zi evenimente) {
        this.colors = new ArrayList<String>();
        for (Eveniment evt : evenimente.getEventList()) {
            colors.add(evt.getCuloare());
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

        Eveniment evt = null;
        if (value instanceof Eveniment) {
            evt = (Eveniment) value;
            if (evt != null) {
                calendar.setTime(evt.getInceput());
                String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + String.format("%02d", calendar.get(Calendar.MINUTE));
                String labelText = "<html>" + time + "<br/>" + evt.getTitlu();
                this.setText(labelText);
                this.setBackground(HexToColor(evt.getCuloare()));
            } else {
                this.setBackground(null);
            }
        } else {
            this.setBackground(null);
        }
        return this;
    }

    /**
     * Converteste o culoare in hexa in obiect Color corespunzator
     *
     * @param hex culoarea in hexa
     * @return obiect corespunzator valorii hexa
     */
    public static Color HexToColor(String hex) {
        hex = hex.replace("#", "");
        switch (hex.length()) {
            case 3:
                return new Color(
                        Integer.valueOf(hex.substring(0, 1), 16) & 0xff,
                        Integer.valueOf(hex.substring(1, 2), 16) & 0xff,
                        Integer.valueOf(hex.substring(2, 3), 16) & 0xff);
            case 6:
                return new Color(
                        Integer.valueOf(hex.substring(0, 2), 16) & 0xff,
                        Integer.valueOf(hex.substring(2, 4), 16) & 0xff,
                        Integer.valueOf(hex.substring(4, 6), 16) & 0xff);
            case 8:
                return new Color(
                        Integer.valueOf(hex.substring(0, 2), 16) & 0xff,
                        Integer.valueOf(hex.substring(2, 4), 16) & 0xff,
                        Integer.valueOf(hex.substring(4, 6), 16) & 0xff,
                        Integer.valueOf(hex.substring(6, 8), 16) & 0xff);
        }
        return null;
    }
}
