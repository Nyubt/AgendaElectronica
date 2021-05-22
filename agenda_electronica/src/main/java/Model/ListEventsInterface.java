package Model;

import java.util.List;

/**
 *
 * @author Nadia
 */
/**
 * Interfata pentru modelele folosite in agenda
 *
 */
public interface ListEventsInterface<T> {

    List<? extends T> getEventList();
}
