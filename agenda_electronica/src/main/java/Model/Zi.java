package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nadia
 */

/**
 * Clasa Zi creeaza un obiect cu informatii despre evenimentele dintr-o zi
 * 
 */
public class Zi implements ListEventsInterface {
    /**
     * Lista de obiecte Eveniment dintr-o zi
     */
    private List <Eveniment> eveniment;
    /**
     * Data zilei evenimentului
     */
    private Date data;
    /**
     * Constructorul clasei Zi
     * @param eveniment 
     */
    public Zi(List <Eveniment> eveniment) {
        this.eveniment = eveniment;
        this.data = null;
    }
    
    /**
     * Constructorul clasei Zi
     * @param eveniment 
     * @param date 
     */
    public Zi(List <Eveniment> eveniment, Date date) {
        this.eveniment = eveniment;
        this.data = date;
    }

    /**
     * Returneaza lista de obiecte Eveniment
     * @return 
     */
    public List <Eveniment> getEventList() {
        return this.eveniment;
    }
    
    public Date getDate(){
        return this.data;
    }
}
