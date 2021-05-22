package Model;

/**
 * Clasa Alarma creeaza un obiect cu informatii despre alarma unui eveniment
 * 
 * @author Ale-PC, Nadia
 */
public class Alarma {
    /**
     * Intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora
     */
    protected int intervalTimp;
    /**
     * Factorul de recurenta dat in minute care declanseaa alarma din timp in timp pana cand este oprita de utilizator
     */
    protected int factorRecurenta;

    /**
     * Constructorul clasei Alarma
     *
     * @param intervalTimp intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora
     * @param recurenta factorul de recurenta dat in minute care declanseaa alarma din timp in timp pana cand este oprita de utilizator
     */
    public Alarma(int intervalTimp, int recurenta) {
        this.intervalTimp = intervalTimp;
        this.factorRecurenta = recurenta;
    }

    /**
     * Extrage informatia privind intervalul de timp pana la alarma
     *
     * @return intervalul de timp dinaintea alarmei
     */
    public int getIntervalTimp() {
        return this.intervalTimp;
    }

    /**
     * Extrage informatia privind factorul de recurenta a alarmei
     *
     * @return factorul de recurenta al alarmei
     */
    public int getFactorRecurenta() {
        return this.factorRecurenta;
    }

    /**
     * Seteaza intervalul de timp dinaintea alarmei
     *
     * @param intervalTimp intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora
     */
    public void setIntervalTimp(int intervalTimp) {
        this.intervalTimp = intervalTimp;
    }

    /**
     * Seteaza factorul de recurenta a alarmei
     *
     * @param factorRecurenta factorul de recurenta dat in minute care declanseaa alarma din timp in timp pana cand este oprita de utilizator
     */
    public void setFactorRecurenta(int factorRecurenta) {
        this.factorRecurenta = factorRecurenta;
    }
}
