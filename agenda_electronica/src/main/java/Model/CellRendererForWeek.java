/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Component;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elena
 */
public class CellRendererForWeek extends DefaultTableCellRenderer 
{    
    private List<String> colors;
    Calendar calendar = Calendar.getInstance();
    
    public CellRendererForWeek(){
    }
    
    public CellRendererForWeek(Zi evenimente){
        this.colors = new ArrayList<String>();
        for(Eveniment evt: evenimente.getEventList()){
            colors.add(evt.getCuloare());
        }
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //System.out.println((Eveniment)value);
        Eveniment evt = null;
        
        if (value instanceof Eveniment) {
            evt = (Eveniment)value;
            //System.out.println(evt.getTitlu());
            //System.out.println(evt.getInceput());
            if(evt != null){
                //System.out.println(evt);
                calendar.setTime(evt.getInceput());
                String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + String.format("%02d", calendar.get(Calendar.MINUTE));   
                String labelText = "<html>" + time + "<br/>" + evt.getTitlu();
                this.setText(labelText);
                this.setBackground(HexToColor(evt.getCuloare()));
                /*if (row < this.colors.size()) {
                    this.setBackground(HexToColor(this.colors.get(row)));
                } else {
                    this.setBackground(null); 
                }*/
            } else {
                this.setBackground(null);
            }
        } else {
            this.setBackground(null); 
        }
        return this;
    }
    
    public static Color HexToColor(String hex) 
    {
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
