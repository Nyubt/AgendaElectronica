package Model;

/**
 *
 * @author Nadia
 */

/**
 * Clasa Alarma creeaza un obiect cu informatii despre alarma unui eveniment
 *  
 */
public class Alarma {
    /**
     * Intervalul de timp setat de utilizator inaintea evenimentului dupa care se va declansa alarma sonora 
     */
    protected int intervalTimp;
    /**
     * Factorul de recurenta dat in minute care declanseaa alarma din timp in timp pâana cand este oprita de utilizator
     */
    protected int factorRecurenta;

    /**
     * Constructorul clasei Alarma
     * @param intervalTimp
     * @param recurenta 
     */
    public Alarma(int intervalTimp, int recurenta) {
        this.intervalTimp = intervalTimp;
        this.factorRecurenta = recurenta;
    }

    /**
     * Returneaza intervalul de timp dinaintea alarmei
     * @return 
     */
    public int getIntervalTimp() {
        return this.intervalTimp;
    }

    /**
     * Returneaza factorul de recurenta al alarmei
     * @return 
     */
    public int getFactorRecurenta() {
        return this.factorRecurenta;
    }

    /**
     * Seteaza intervalul de timp dinaintea alarmei
     * @param intervalTimp 
     */
    public void setIntervalTimp(int intervalTimp) {
        this.intervalTimp = intervalTimp;
    }

    /**
     * Returneaza factorul de recurenta a alarmei
     * @param factorRecurenta 
     */
    public void setFactorRecurenta(int factorRecurenta) {
        this.factorRecurenta = factorRecurenta;
    }
}
