package Model;

import java.util.Date;
import java.util.List;

/**
 * Clasa Zi creeaza un obiect cu informatii despre evenimentele dintr-o zi
 * 
 * @author Ale-PC, Nadia
 */
public class Zi implements ListEventsInterface {

    /**
     * Lista de obiecte Eveniment dintr-o zi
     */
    private List<Eveniment> eveniment;
    /**
     * Data de declansare a evenimentului
     */
    private Date data;

    /**
     * Constructorul clasei Zi
     *
     * @param eveniment lista de Evenimente
     */
    public Zi(List<Eveniment> eveniment) {
        this.eveniment = eveniment;
        this.data = null;
    }

    /**
     * Constructorul clasei Zi
     *
     * @param eveniment lista de Evenimente
     * @param date data declansarii evenimentului
     */
    public Zi(List<Eveniment> eveniment, Date date) {
        this.eveniment = eveniment;
        this.data = date;
    }

    /**
     * Extrage informatia privind lista de obiecte Eveniment
     *
     * @return lista de obiecte Eveniment
     */
    public List<Eveniment> getEventList() {
        return this.eveniment;
    }

    /**
     * Extrage informatia privind data evenimentului
     * 
     * @return data de declansare a evenimentului
     */
    public Date getDate() {
        return this.data;
    }
}
