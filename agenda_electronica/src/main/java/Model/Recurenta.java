package Model;

import java.util.Date;

/**
 * Clasa Recurenta
 * 
 * @author Nadia
 */
public class Recurenta {

    /**
     * Modul de recurenta a evenimentului
     * 0=nu se repeta
     * 1=se repeta zilnic
     * 2=se repeta saptamanal
     * 3=se repeta lunar
     * 4=se repeta anual
     */
    private int modRecurenta;
    /**
     * Ultima data de aparitie a evenimentului recurent
     */
    private Date dateSfarsit;

    /**
     * Constructorul clasei Recurenta
     */
    public Recurenta() {
        this.modRecurenta = 0;
        this.dateSfarsit = new Date();
    }

    /**
     * Constructorul clasei Recurenta
     * 
     * @param modRecurenta modul de recurenta a evenimentului
     * @param dateSfarsit ultima data de aparitie a evenimentului recurent
     */
    public Recurenta(int modRecurenta, Date dateSfarsit) {
        this.modRecurenta = modRecurenta;
        this.dateSfarsit = dateSfarsit;
    }

    /**
     * Extrage informatia privind modul de recurenta
     *
     * @return valoare modului de recurenta: 0=nu se repeta; 1=se repeta zilnic; 2=se repeta saptamanal; 3=se repeta lunar; 4=se repeta anual
     */
    public int getModRecurenta() {
        return this.modRecurenta;
    }

    /**
     * Extrage informatia privind ultima data de aparitie a evenimentului recurent
     *
     * @return ultima data de de aparitie a evenimentului recurent
     */
    public Date getDataSfarsit() {
        return this.dateSfarsit;
    }
}
