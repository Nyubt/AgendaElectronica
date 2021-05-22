package Model;

import java.util.List;

/**
 *
 * @author Nadia
 */
/**
 * Clasa Luna creeaza un obiect cu informatii despre evenimentele dintr-o luna
 *
 */
public class Luna implements ListEventsInterface {

    /**
     * Lista de obiecte Zi dintr-o luna
     */
    private List<Zi> luna;

    /**
     * Constructorul clasei Luna
     *
     * @param zile
     */
    public Luna(List<Zi> zile) {
        this.luna = zile;
    }

    /**
     * Getter care returneaza lista cu obiectele Zi dintr-o luna
     *
     * @return luna
     */
    public List<Zi> getEventList() {
        return this.luna;
    }
}
