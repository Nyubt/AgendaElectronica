package Model;

import java.util.List;

/**
 * Clasa An creeaza un obiect cu informatii despre toate evenimentele dintr-un an
 * 
 * @author Ale-PC, Nadia
 */
public class An implements ListEventsInterface {
    /**
     * Lista de obiecte Luna dintr-un an
     */
    private List<Luna> luni;

    /**
     * Constructorul clasei An
     * 
     * @param luni lista cu obiecte Luna
     */
    public An(List<Luna> luni) {
        this.luni = luni;
    }

    /**
     * Extrage informatia privind evenimentele din an
     *
     * @return lista cu obiectele Luna dintr-un an
     */
    public List<Luna> getEventList() {
        return this.luni;
    }
}
