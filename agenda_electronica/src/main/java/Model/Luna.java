package Model;

import java.util.List;

/**
 * Clasa Luna creeaza un obiect cu informatii despre evenimentele dintr-o luna
 * 
 * @author Ale-PC, Nadia
 */
public class Luna implements ListEventsInterface {

    /**
     * Lista de obiecte Zi dintr-o luna
     */
    private List<Zi> luna;

    /**
     * Constructorul clasei Luna
     *
     * @param zile lista de obiecte Zi
     */
    public Luna(List<Zi> zile) {
        this.luna = zile;
    }

    /**
     * Extrage informatia privind lista cu obiectele Zi dintr-o luna
     *
     * @return luna
     */
    public List<Zi> getEventList() {
        return this.luna;
    }
}
