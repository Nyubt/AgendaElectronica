package Model;

import java.awt.Component;
import java.awt.Font;;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Elena
 */
/**
 *Functia care adauga un stil pentru luna
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
            if(!evtZi.getEventList().isEmpty()){
                for(Eveniment evt: evtZi.getEventList()){
                    colors.add(evt.getCuloare());
                }
            }
            map.put(i++, colors);
        }
    }
    
 /**
 *Functia care adauga un stil pentru tabel
 */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      
        if(value instanceof Zi) {
            Zi evt = (Zi)value;
            if(evt != null){  
                Integer date = dateToDay(evt.getDate());       
                this.setText(date.toString());
                if(date != null && (date.intValue() - 1) < map.size()){
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
     *Functia care ia un parametru de tip Date și se referă la data dată care urmează să fie setată.
     * @return date
    */
    private Integer dateToDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
