package Model;

import View.EventDetails;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * Clasa ComboHtmlRenderer specifica stilul pentru un ComboBox
 * 
 * @author Elena
 */
public class ComboHtmlRenderer extends DefaultListCellRenderer {

    /**
     * Defineste un renderer pentru itemii unui JList
     * 
     * @param list JList pe care o desenam
     * @param value valoarea intoarsa de list.getModel().getElementAt(index)
     * @param index indexul celulei
     * @param isSelected true daca celula specificata a fost selectata
     * @param hasFocus true daca celula specificata are focus
     * @return componenta configurata
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
        String colorName = (String) value;
        Color actualColor = CellRendererForWeek.HexToColor(colorName);
        this.setBackground(actualColor);
        this.setText(EventDetails.getColorNameFromHex(colorName));

        return this;
    }
}
