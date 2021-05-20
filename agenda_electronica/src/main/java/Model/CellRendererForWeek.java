 package Model;

import java.awt.Component;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Elena
 */
 /**
 *Functia care adauga un stil pentru saptamana
 */
public class CellRendererForWeek extends DefaultTableCellRenderer 
{    
    private List<String> colors;
    Calendar calendar = Calendar.getInstance();
    
    public CellRendererForWeek(){
    }
 /**
 *Functia care adauga o culoare evenimentelor din saptamana
 * @param evenimente
 */
    public CellRendererForWeek(Zi evenimente){
        this.colors = new ArrayList<String>();
        for(Eveniment evt: evenimente.getEventList()){
            colors.add(evt.getCuloare());
        }
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        Eveniment evt = null;
        
        if (value instanceof Eveniment) {
            evt = (Eveniment)value;
             
            if(evt != null){
                
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
 *Functia care converteste un string in culoarea specifica
 * @param hex
 */
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
