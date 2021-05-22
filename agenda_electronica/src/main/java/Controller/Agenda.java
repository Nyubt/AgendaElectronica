package Controller;

import Model.ListEventsInterface;
import Model.Eveniment;
import Model.Alarma;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * Clasa Agenda face legatura dintre interfata agendei si metodele de manipulare a evenimentelor
 * 
 * @author Nadia, Elena
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
     * Data evenimentului
     */
    private Date data;
    /**
     * Lista de alarme din ziua curenta
     */
    List<Alarma> alarme;
    /**
     * Lista obiectelor Timer
     */
    List<Timer> timer;

    /**
     * Constructorul clasei Agenda
     *
     * @param modAfisare modul de afisare a evenimentelor
     * @param data data evenimentului
     * @param alarma lista de alarme din ziua curent
     * @param timer lista obiectelor Timer
     */
    public Agenda(String modAfisare, Date data, List<Alarma> alarma, List<Timer> timer) {
        this.modAfisare = EnumerareModAfisare.valueOf(modAfisare);
        this.data = data;
        this.alarme = alarma;
        this.timer = timer;
    }

    /**
     * Extrage informatia privind modul de afisare a evenimentelor
     *
     * @return modul de afisare a evenimentelor
     */
    public String getModAfisare() {
        return modAfisare.toString();
    }

    /**
     * Extrage informatia privind data evenimentului
     *
     * @return data evenimentului
     */
    public Date getData() {
        return data;
    }

    /**
     * Extrage informatia privind alarmele agedei
     *
     * @return lista de alarme ale agendei
     */
    public List<Alarma> getAlarma() {
        return alarme;
    }

    /**
     * Extrage informatia privind obiectele Timer
     *
     * @return lista de obiecte Timer
     */
    public List<Timer> getTimer() {
        return timer;
    }

    /**
     * Seteaza modul de afisare a evenimentelor
     * 
     * @param modAfisare modul de afisare a evenimentelor
     */
    public void setModAfisare(String modAfisare) {
        this.modAfisare = EnumerareModAfisare.valueOf(modAfisare);
    }

    /**
     * Seteaza data declansarii evenimentului
     *
     * @param data evenimentului
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Seteaza lista de alarme din ziua curenta
     *
     * @param alarma lista de alarme din ziua curenta
     */
    public void setAlarma(List<Alarma> alarma) {
        this.alarme = alarma;
    }

    /**
     * Seteaza lista de obiecte Timer
     *
     * @param timer lista de obiecte Timer
     */
    public void setTimer(List<Timer> timer) {
        this.timer = timer;
    }

    /**
     * Adauga un eveniment
     *
     * @param titlu titlul evenimentului
     * @param descriere descrierea evenimentului
     * @param dataInceput data de incepere a evenimentului format yyyy-mm-dd
     * @param timpSfarsit timpul de incepere a evenimentului hh:mm:ss
     * @param dataSfarsit data de terminare a evenimentului format yyyy-mm-dd
     * @param timpInceput timpul de terminare a evenimentului hh:mm:ss
     * @param culoare culoare in hexa a evenimentului
     * @param alarmaPornita valoarea de adevar sau fals a starii alarmei
     * @param factorRecurenta factorul de recurenta dat in minute care declanseaa alarma din timp in timp pana cand este oprita de utilizator
     * @param intervalTimp intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora
     * @param esteRecurenta valoarea de adevar sau fals al starii de recurenta a evenimentului
     * @param modRecurenta modul de recurenta a evenimentului
     * @param dataFinala ultima data de declansare a evenimentului recurent
     */
    public static void AdaugareEveniment(String titlu, String descriere, String dataInceput, String timpInceput, String dataSfarsit, String timpSfarsit, String culoare,
            boolean alarmaPornita, int factorRecurenta, int intervalTimp, boolean esteRecurenta, int modRecurenta, String dataFinala) {
        Container.getInstance().AdaugareEveniment(titlu, descriere, dataInceput, timpInceput, dataSfarsit, timpSfarsit, culoare,
                alarmaPornita, factorRecurenta, intervalTimp, esteRecurenta, modRecurenta, dataFinala);
    }

    /**
     * Selecteaza evenimente
     *
     * @param data data de declansare a evenimentelor
     * @param modAfisare modul de afisare a evenimentelor in UI
     * @return obiect Zi,Saptamana,Luna,An cu lista de evenimente in dependenta de modul de afisare transmis
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
     * Modifica un eveniment
     *
     * @param eveniment evenimentul care va fi modificat
     */
    public static void ModificareEvent(Eveniment eveniment) {
        Container.getInstance().ModificareEvent(eveniment);
    }

    /**
     * Anuleaza un eveniment
     *
     * @param eveniment evenimentul care va fi anulat
     */
    public static void AnulareEvent(Eveniment eveniment) {
        Container.getInstance().AnulareEvent(eveniment);
    }

    /**
     * Amana alarma unui eveniment
     *
     * @param eveniment evenimentul carui alarma va fi amanata
     */
    public static void AmanareAlarma(Eveniment eveniment) {
        Container.getInstance().AmanareAlarma(eveniment);
    }

    /**
     * Oprireste alarma unui eveniment
     *
     * @param eveniment evenimentul carui alarma va fi oprita
     */
    public static void OprireAlarma(Eveniment eveniment) {
        Container.getInstance().OprireAlarma(eveniment);
    }
}
