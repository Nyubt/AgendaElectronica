package Controller;

import Model.ListEventsInterface;
import Model.Eveniment;
import Model.Alarma;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Nadia
 */
/**
 * Clasa Agenda face legatura dintre interfata agendei si metodele de manipulare
 * a evenimentelor
 *
 */
public class Agenda {

    /**
     * Enumerare moduri afisare
     */
    private enum EnumerareModAfisare {
        DAY, WEEK, MONTH, YEAR, ALL;
    }
    /**
     * Modul de afisare a agendei
     */
    static EnumerareModAfisare modAfisare;
    /**
     * Data selectata
     */
    private Date data;
    /**
     * Lista de alarme
     */
    List<Alarma> alarme;
    /**
     * Lista obiectelor Timer
     */
    List<Timer> timer;

    /**
     * Constructorul clasei Agenda
     *
     * @param modAfisare
     * @param data
     * @param alarma
     * @param timer
     */
    public Agenda(String modAfisare, Date data, List<Alarma> alarma, List<Timer> timer) {
        this.modAfisare = EnumerareModAfisare.valueOf(modAfisare);
        this.data = data;
        this.alarme = alarma;
        this.timer = timer;
    }

    /**
     * Functia get pentru modul de afisare
     *
     * @return modul de afisare
     */
    public String getModAfisare() {
        return modAfisare.toString();
    }

    /**
     * Functia get pentru data
     *
     * @return data
     */
    public Date getData() {
        return data;
    }

    /**
     * Functia get pentru alarme
     *
     * @return lista de alarme
     */
    public List<Alarma> getAlarma() {
        return alarme;
    }

    /**
     * Functia get pentru timer
     *
     * @return lista de timere
     */
    public List<Timer> getTimer() {
        return timer;
    }

    /**
     * Seteaza modul de afisare
     *
     * @param modAfisare
     */
    public void setModAfisare(String modAfisare) {
        this.modAfisare = EnumerareModAfisare.valueOf(modAfisare);
    }

    /**
     * Seteaza data
     *
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Seteaza lista de alarme
     *
     * @param alarma
     */
    public void setAlarma(List<Alarma> alarma) {
        this.alarme = alarma;
    }

    /**
     * Seteaza lista de timere
     *
     * @param timer
     */
    public void setTimer(List<Timer> timer) {
        this.timer = timer;
    }

    /**
     * Adaugarea unui eveniment
     *
     * @param titlu
     * @param descriere
     * @param dataInceput
     * @param timpSfarsit
     * @param dataSfarsit
     * @param timpInceput
     * @param culoare
     * @param alarmaPornita
     * @param factorRecurenta
     * @param intervalTimp
     * @param esteRecurenta
     * @param modRecurenta
     * @param dataFinala
     */
    public static void AdaugareEveniment(String titlu, String descriere, String dataInceput, String timpInceput, String dataSfarsit, String timpSfarsit, String culoare,
            boolean alarmaPornita, int factorRecurenta, int intervalTimp, boolean esteRecurenta, int modRecurenta, String dataFinala) {
        Container.getInstance().AdaugareEveniment(titlu, descriere, dataInceput, timpInceput, dataSfarsit, timpSfarsit, culoare,
                alarmaPornita, factorRecurenta, intervalTimp, esteRecurenta, modRecurenta, dataFinala);
    }

    /**
     * Selectarea unui eveniment
     *
     * @param data
     * @param modAfisare
     * @return
     */
    public static ListEventsInterface SelectareEvente(Date data, String modAfisare) throws ParseException {
        EnumerareModAfisare mod = modAfisare != null ? EnumerareModAfisare.valueOf(modAfisare) : null;
        if (mod == EnumerareModAfisare.DAY || Agenda.modAfisare == EnumerareModAfisare.DAY) {
            return Container.getInstance().FurnizareZi(data);
        } else if (mod == EnumerareModAfisare.WEEK || Agenda.modAfisare == EnumerareModAfisare.WEEK) {
            return Container.getInstance().FurnizareSaptamana(data);
        } else if (mod == EnumerareModAfisare.MONTH || Agenda.modAfisare == EnumerareModAfisare.MONTH) {
            return Container.getInstance().FurnizareLuna(data);
        } else if (mod == EnumerareModAfisare.YEAR || Agenda.modAfisare == EnumerareModAfisare.YEAR) {
            return Container.getInstance().FurnizareAn(data);
        } else if (mod == EnumerareModAfisare.ALL || Agenda.modAfisare == EnumerareModAfisare.ALL) {
            return Container.getInstance().FurnizareToateEvent();
        }
        return null;
    }

    /**
     * Modificarea unui eveniment
     *
     * @param eveniment
     */
    public static void ModificareEvent(Eveniment eveniment) {
        //System.out.println(eveniment.getTitlu());
        Container.getInstance().ModificareEvent(eveniment);
    }

    /**
     * Anularea unui eveniment
     *
     * @param eveniment
     */
    public static void AnulareEvent(Eveniment eveniment) {
        Container.getInstance().AnulareEvent(eveniment);
    }

    /**
     * Amanarea alarmei
     *
     * @param eveniment
     */
    public static void AmanareAlarma(Eveniment eveniment) {
        Container.getInstance().AmanareAlarma(eveniment);
    }

    /**
     * Oprireaz alarmei
     *
     * @param eveniment
     */
    public static void OprireAlarma(Eveniment eveniment) {
        Container.getInstance().OprireAlarma(eveniment);
    }
}
