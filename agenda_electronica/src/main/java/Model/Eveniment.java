package Model;

import java.util.Date;

/**
 * Clasa Eveniment creaza un obiect cu informatii despre un singur eveniment
 * 
 * @author Ale-PC, Nadia, Elena
 */
public class Eveniment {

    /**
     * Titlul evenimentului
     */
    private String titlu;
    /**
     * Descrierea evenimentului
     */
    private String descriere;
    /**
     * Data de inceut a evenimentului
     */
    private Date inceput;
    /**
     * Data de sfarsit a evenimentului
     */
    private Date sfarsit;
    /**
     * Alarma evenimentului
     */
    private Alarma alarma;
    /**
     * Recurenta evenimentului
     */
    private Recurenta recurenta;
    /**
     * Culoarea evenimentului in format hexa
     */
    private String culoare;
    /**
     * Starea alarmei
     */
    private boolean alarmaPornita;
    /**
     * ID-ul evenimentului folosit pentru a verifica daca doua evenimente sunt egale
     */
    private int id;
    /**
     * Starea evenimentului
     */
    private boolean inactive;

    /**
     * Constructorul clasei eveniment
     *
     * @param id id-ul evenimentului
     * @param titlu denuminrea evenimentului
     * @param descriere descrierea evenimentului
     * @param inceput data de inceput a evenimentului
     * @param sfarsit data de sfarsit a evenimentului
     * @param alarma obiect Alarma atasat evenimentului
     * @param recurenta obiect Recurenta atasat evenimentului
     * @param culoare culoarea evenimentului
     * @param alarmaPornita true daca alarma e pornita
     * @param inactive true daca evenimentul e inactiv
     */
    public Eveniment(int id, String titlu, String descriere, Date inceput, Date sfarsit, Alarma alarma, Recurenta recurenta, String culoare, boolean alarmaPornita, boolean inactive) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
        this.inceput = inceput;
        this.sfarsit = sfarsit;
        this.alarma = alarma;
        this.recurenta = recurenta;
        this.culoare = culoare;
        this.alarmaPornita = alarmaPornita;
        this.inactive = inactive;
    }

    /**
     * Extrage informatia privind ID-ul evenimentului
     *
     * @return id-ul evenimentului
     */
    public int getEvenimentId() {
        return this.id;
    }

    /**
     * Extrage informatia privind titlul evenimentului
     *
     * @return titlul evenimentului
     */
    public String getTitlu() {
        return this.titlu;
    }

    /**
     * Extrage informatia privind descrierea evenimentului
     *
     * @return descrierea evenimentului
     */
    public String getDescriere() {
        return this.descriere;
    }

    /**
     * Extrage informatia privind data de inceput evenimentului
     *
     * @return data de inceput a evenimentului
     */
    public Date getInceput() {
        return this.inceput;
    }

    /**
     * Extrage informatia privind data de sfarsit evenimentului
     *
     * @return data de sfarsit a evenimentului
     */
    public Date getSfarsit() {
        return this.sfarsit;
    }

    /**
     * Extrage informatia privind obiectul Alarma atasat evenimentului
     *
     * @return alarma evenimentului
     */
    public Alarma getAlarma() {
        return this.alarma;
    }

    /**
     * Extrage informatia privind obiectul Recurenta atasat evenimentului
     *
     * @return modul de recurenta a evenimentului
     */
    public Recurenta getRecurenta() {
        return this.recurenta;
    }

    /**
     * Extragere informatie privind modul de recurenta a evenimentului
     * 
     * @return modul de recurenta a eveniimentului
     */
    public String getModRecurenta() {
        if (this.getRecurenta().getModRecurenta() == 1) {
            return "Zilnic";
        }
        if (this.getRecurenta().getModRecurenta() == 2) {
            return "Saptamanal";
        }
        if (this.getRecurenta().getModRecurenta() == 3) {
            return "Lunar";
        }
        if (this.getRecurenta().getModRecurenta() == 4) {
            return "Anual";
        }
        return "";
    }

    /**
     * Extrage informatia privind culoarea evenimentului
     *
     * @return culoarea evenimentului
     */
    public String getCuloare() {
        return this.culoare;
    }

    /**
     * Extrage informatia privind starea evenimentului
     *
     * @return true daca evenimentului e inactiv
     */
    public boolean getInactiveState() {
        return this.inactive;
    }

    /**
     * Extrage informatia privind starea alarmei evenimentului
     * 
     * @return true daca alarma e pornita
     */
    public boolean isAlarmaPornita() {
        return this.alarmaPornita;
    }

    /**
     * Seteaza titlul evenimentului
     *
     * @param titlu titlul evenimentului
     */
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    /**
     * Seteaza descrierea evenimentului
     *
     * @param descriere descrierea evenimentului
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Seteaza data de inceput a evenimentului
     *
     * @param inceput data de incepere a evenimentului
     */
    public void setInceput(Date inceput) {
        this.inceput = inceput;
    }

    /**
     * Seteaza data de sfarsit a evenimentului
     *
     * @param sfarsit data de sfarsire a evenimentului
     */
    public void setSfarsit(Date sfarsit) {
        this.sfarsit = sfarsit;
    }

    /**
     * Seteaza alarma evenimentului
     *
     * @param alarma obiectul Alarma corespunzator evenimentului
     */
    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    /**
     * Seteaza culoarea evenimentului
     *
     * @param culoare culoarea evenimentului
     */
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    /**
     * Seteaza starea alarmei evenimentului
     *
     * @param alarmaPornita true daca alarma e pornita
     */
    public void setStareAlarma(boolean alarmaPornita) {
        this.alarmaPornita = alarmaPornita;
    }

    /**
     * Seteaza starea evenimentului
     *
     * @param inactive true daca evenimentul e inactiv
     */
    public void setInactiveState(boolean inactive) {
        this.inactive = inactive;
    }

    /**
     * Supraincarcarea metodei equals pentru obiectul Eveniment
     * 
     * @param obj obiectul cu care se compara
     * @return true daca obiectele comparate sunt egale
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (this.id == ((Eveniment) obj).id);
    }
}
