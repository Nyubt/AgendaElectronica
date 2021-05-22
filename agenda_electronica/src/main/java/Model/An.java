package Model;

import java.util.List;

/**
 *
 * @author Nadia
 */
/**
 * Clasa An creeaza un obiect cu informatii despre toate evenimentele dintr-un
 * an
 *
 */
public class An implements ListEventsInterface {

    /**
     * Lista de obiecte Luna dintr-un an
     */
    private List<Luna> luni;

    /**
     * Constructorul clasei An
     */
    public An(List<Luna> luni) {
        this.luni = luni;
    }

    /**
     * Functia get pentru evenimentele din luna
     *
     * @return lista cu obiectele Luna dintr-un an
     */
    public List<Luna> getEventList() {
        return this.luni;
    }
}
