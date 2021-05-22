package Model;

import java.util.List;

/**
 * Clasa Saptamana creeaza un obiect cu informatii despre toate evenimentele dintr-o saptamana
 * 
 * @author Ale-PC, Nadia
 */
public class Saptamana implements ListEventsInterface {

    /**
     * Lista de obiecte Zi dintr-o saptamana
     */
    private List<Zi> saptamana;

    /**
     * Constructorul clasei Saptamana
     *
     * @param zile lista de obiecte Zi
     */
    public Saptamana(List<Zi> zile) {
        this.saptamana = zile;
    }

    /**
     * Extrage informatia privind lista cu obiectele Zi dintr-o saptamana
     *
     * @return lista cu obiectele Zi dintr-o saptamana
     */
    public List<Zi> getEventList() {
        return this.saptamana;
    }
}
