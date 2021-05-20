 package Model;

import java.util.List;
/**
 *
 * @author Nadia
 */
 
/**
 *  Clasa Saptamana creeaza un obiect cu informatii despre toate evenimentele dintr-o saptamana
 * 
 */
public class Saptamana implements ListEventsInterface {
    /**
     * Lista de obiecte Zi dintr-o saptamana
     */
    private List <Zi> saptamana;

    /**
     * Constructorul clasei Saptamana
     * @param zile 
     */
    public Saptamana(List <Zi> zile) {
        this.saptamana = zile;
    }

    /**
     * Returneaza lista cu obiectele Zi dintr-o saptamana
     * @return 
     */
    public List <Zi> getEventList () {
        return this.saptamana;
    }
}
