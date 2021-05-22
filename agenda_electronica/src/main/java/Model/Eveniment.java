package Model;

import java.util.Date;

/**
 *
 * @author Nadia
 */
/**
 * Clasa eveniment creaza un obiect cu informatii despre un singur eveniment
 *
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
     * Culoarea evenimentului
     */
    private String culoare;
    /**
     * Starea alarmei
     */
    private boolean alarmaPornita;
    /**
     * ID-ul evenimentului folosit pentru a verifica daca doua evenimente sunt
     * egale
     */
    private int id;
    /**
     * Starea evenimentului
     */
    private boolean inactive;

    /**
     * Constructorul clasei eveniment
     *
     * @param id
     * @param titlu denuminrea evenimentului
     * @param descriere
     * @param inceput data de inceput a evenimentului
     * @param sfarsit data de sfarsit a evenimentului
     * @param alarma
     * @param recurenta
     * @param culoare
     * @param alarmaPornita
     * @param inactive
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
     * Functia get pentru a accesa ID-ul evenimentului
     *
     * @return id-ul evenimentului
     */
    public int getEvenimentId() {
        return this.id;
    }

    /**
     * Functia get pentru a gasi Titlul evenimentului
     *
     * @return titlul evenimentului
     */
    public String getTitlu() {
        return this.titlu;
    }

    /**
     * Functia get pentru a gasi Descrierea evenimentului
     *
     * @return descrierea evenimentului
     */
    public String getDescriere() {
        return this.descriere;
    }

    /**
     * Functia get pentru a gasi data de inceput evenimentului
     *
     * @return data de inceput a evenimentului
     */
    public Date getInceput() {
        return this.inceput;
    }

    /**
     * Functia get pentru a gasi data de sfarsit evenimentului
     *
     * @return data de sfarsit a evenimentului
     */
    public Date getSfarsit() {
        return this.sfarsit;
    }

    /**
     * Functia get pentru a gasi alarma evenimentului
     *
     * @return alarma evenimentului
     */
    public Alarma getAlarma() {
        return this.alarma;
    }

    /**
     * Functia get pentru a afla modul de recurenta al evenimentului
     *
     * @return modul de recurenta a evenimentului
     */
    public Recurenta getRecurenta() {
        return this.recurenta;
    }

    /**
     * Functia get pentru a afla culoarea evenimentului
     *
     * @return culoarea evenimentului
     */
    public String getCuloare() {
        return this.culoare;
    }

    /**
     * true or false Functia get pentru a afla daca starea evenimentului este
     * true sau false
     *
     * @return starea evenimentului
     */
    public boolean getInactiveState() {
        return this.inactive;
    }

    /**
     * @return daca alarma e pornita sau nu
     */
    public boolean isAlarmaPornita() {
        return this.alarmaPornita;
    }

    /**
     * Seteaza titlul evenimentului
     *
     * @param titlu
     */
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    /**
     * Seteaza descrierea evenimentului
     *
     * @param descriere
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Seteaza data de inceput a evenimentului
     *
     * @param inceput
     */
    public void setInceput(Date inceput) {
        this.inceput = inceput;
    }

    /**
     * Seteaza data de sfarsit a evenimentului
     *
     * @param sfarsit
     */
    public void setSfarsit(Date sfarsit) {
        this.sfarsit = sfarsit;
    }

    /**
     * Seteaza alarma evenimentului
     *
     * @param alarma
     */
    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    /**
     * Seteaza culoarea evenimentului
     *
     * @param culoare
     */
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    /**
     * Seteaza alarma pornita la true sau false
     *
     * @param alarmaPornita
     */
    public void setStareAlarma(boolean alarmaPornita) {
        this.alarmaPornita = alarmaPornita;
    }

    /**
     * Seteaza starea evenimentului
     *
     * @param inactive
     */
    public void setInactiveState(boolean inactive) {
        this.inactive = inactive;
    }

    /**
     * Supraincarcarea metodei equals pentru obiectul Eveniment
     *
     * @param obj
     * @return id
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
