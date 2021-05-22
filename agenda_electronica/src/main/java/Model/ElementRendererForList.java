package Model;

import java.awt.Component;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Clasa ElementRendererForList specifica stilul cu elemente html pentru o lista de Evenimente
 * 
 * @author Elena
 */
public class ElementRendererForList extends JLabel implements ListCellRenderer<Eveniment> {

    /**
     * Defineste un renderer pentru itemii unui JList
     * 
     * @param list JList pe care o desenam cu obiecte tip Eveniment
     * @param value valoarea intoarsa de list.getModel().getElementAt(index)
     * @param index indexul celulei
     * @param isSelected true daca celula specificata a fost selectata
     * @param cellHasFocus true daca celula specificata are focus
     * @return componenta configurata
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Eveniment> list, Eveniment value, int index, boolean isSelected, boolean cellHasFocus) {
        String labelText = "<html><div style=\"display: block;text-align:center;background: " + value.getCuloare() + ";\">Id: " + value.getEvenimentId() + "<br/>Date: " + value.getInceput() + "<br/>Titlu: " + value.getTitlu()
                + "<br/>Duration: " + getDateDiff(value.getInceput(), value.getSfarsit(), TimeUnit.MINUTES) + "</div><br/>";
        setText(labelText);

        return this;
    }

    /**
     * Calculeaza diferenta intre datele unui evenimente
     * 
     * @param date1 data de incepere a evenimentului
     * @param date2 date de sfarsire a evenimentului
     * @param timeUnit obiect TimeUnit
     * @return diferenta in minute sau ore dintre date
     */
    private String getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        long duration = timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (duration < 60) {
            return duration + " minute";
        }
        return (duration / 60) + " ore";
    }

}
