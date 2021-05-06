/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Component;
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
                "<br/>Duration: " + value.getDescriere() + "</div><br/>";
        setText(labelText);
        
        return this;
    }
    
}
