/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;

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
            mod.setRowCount(6);
        }
    }
    
    public static void fillInTable(JTable... table){
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.RIGHT);
        int currentMonth = month - 1;
        int day = 1;
        for(int i = 0; i < table.length; i++){
            if(table.length > 1){
                currentMonth = i;
            }
            int a;
            DefaultTableModel mod = (DefaultTableModel)table[i].getModel();
            for(a = 1; a <= 6; a++){
                mod.removeRow(6 - a);
            }
            for(a = 0; a < 7; a++){
                table[i].getColumnModel().getColumn(a).setCellRenderer(renderer);
            }
            mod.setRowCount(6);            
            Calendar cal = Calendar.getInstance();
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
            }
        }
    }
}
