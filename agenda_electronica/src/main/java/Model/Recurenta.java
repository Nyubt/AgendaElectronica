package Model;

import java.util.Date;

/**
 *
 * @author Elena
 */
public class Recurenta {
    private int modRecurenta;
    private Date dateSfarsit;
    
    public Recurenta(){
        this.modRecurenta = 0;
        this.dateSfarsit = new Date();
    }
     /**
     * Constructorul clasei Recurenta
     */
    public Recurenta(int modRecurenta, Date dateSfarsit){
        this.modRecurenta = modRecurenta;
        this.dateSfarsit = dateSfarsit;
    }
    
    /**
     * Getter pentru Modul de recurenta
     * @return valoare modului de recurenta
     */
    public int getModRecurenta() {
        return this.modRecurenta;
    }
    
    /**
     * Getter pentru Data de Sfarsit
     * @return ultima data de recurenta
     */
    public Date getDataSfarsit() {
        return this.dateSfarsit;
    }
}
