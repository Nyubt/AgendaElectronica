/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Elena
 */
public class CellRendererForMonth extends DefaultTableCellRenderer
{
    Map<Integer, List<String>> map;
    
    public CellRendererForMonth(List<Zi> evenimente)
    {
        map = new HashMap<Integer, List<String>>();
        int i = 0;
        for(Zi evtZi: evenimente){
            List<String> colors = new ArrayList<String>();
            for(Eveniment evt: evtZi.getEventList()){
                colors.add(evt.getCuloare());
            }
            map.put(i++, colors);
        }
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //System.out.println("!");
        Integer date = (Integer)value;
        //System.out.println(date);
        //System.out.println(pos == date);
        if(date != null && (date.intValue() - 1) < map.size()){
            int pos = date.intValue() - 1;
            //System.out.println(map.size() + " " + row + " " + column + "=" + (row * 7 + column));
            if (map.get(pos).size() > 1) {
                System.out.println("1 " + pos);
                this.setFont(this.getFont().deriveFont(Font.BOLD));
            } else if (map.get(pos).size() == 1) {
                System.out.println("2 " + pos);
                //System.out.println("2");
                this.setBackground(CellRendererForWeek.HexToColor(map.get(pos).get(0)));
            } 
        } else {
            //System.out.println("3");
            this.setBackground(null); 
        }
         
        return this;
    }
     
}
