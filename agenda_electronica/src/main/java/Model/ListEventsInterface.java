package Model;

import java.util.List;

/**
 * Interfata pentru obiectele Zi, Saptamana, Luna, An
 * 
 * @author Nadia
 */
public interface ListEventsInterface<T> {

    /**
     * Extrage lista de evenimente 
     * 
     * @return lista de evenimente
     */
    List<? extends T> getEventList();
}
