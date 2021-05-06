/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Component;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Elena
 */
public class ElementRendererForList extends JLabel implements ListCellRenderer<Eveniment> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Eveniment> list, Eveniment value, int index, boolean isSelected, boolean cellHasFocus) {
        String labelText = "<html><div style=\"display: block;text-align:center;background: " + value.getCuloare() + ";\">Id: " + value.getEvenimentId() + "<br/>Date: " + value.getInceput() + "<br/>Titlu: " + value.getTitlu() + 
                "<br/>Duration: " + getDateDiff(value.getInceput(), value.getSfarsit(), TimeUnit.MINUTES) + "</div><br/>";
        setText(labelText);        
        
        return this;
    }
    
    private String getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        long duration = timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (duration < 60) {
            return duration + " minute";
        }
        return (duration / 60) + " ore";
    }
    
}
