/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.EventDetails;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Elena
 */
public class ComboHtmlRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
        String colorName = (String)value;
        Color actualColor = CellRendererForWeek.HexToColor(colorName);
        this.setBackground(actualColor);
        this.setText(EventDetails.getColorNameFromHex(colorName));
        
        return this;
    }
}
