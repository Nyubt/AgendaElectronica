/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *  Clasa Eveniment creaza un obiect cu informatii despre un singur eveniment
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
    Alarma alarma;
    /**
     * Culoarea evenimentului
     */
    private String culoare;

    /**
     * Constructorul clasei eveniment
     * @param titlu
     * @param descriere
     * @param inceput
     * @param sfarsit
     * @param alarma
     * @param culoare 
     */
    public Eveniment(String titlu, String descriere, Date inceput, Date sfarsit, Alarma alarma, String culoare) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.inceput = inceput;
        this.sfarsit = sfarsit;
        this.alarma = alarma;
        this.culoare = culoare;
    }

    /**
     * Returneaza titlul evenimentului
     * @return 
     */
    public String getTitlu() {
        return this.titlu;
    }

    /**
     * Returneaza descrierea evenimentului
     * @return 
     */
    public String getDescriere() {
        return this.descriere;
    }

    /**
     * Returneaza data de inceput a evenimentului
     * @return 
     */
    public Date getInceput() {
        return this.inceput;
    }

    /**
     * Returneaza data de sfarsit a evenimentului
     * @return 
     */
    public Date getSfarsit() {
        return this.sfarsit;
    }

    /**
     * Returneaza alarma evenimentului
     * @return 
     */
    public Alarma getAlarma() {
        return this.alarma;
    }

    /**
     * Returneaza culoarea evenimentului
     * @return 
     */
    public String getCuloare() {
        return this.culoare;
    }

    /**
     * Seteaza titlul evenimentului
     * @param titlu 
     */
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    /**
     * Seteaza descrierea evenimentului
     * @param descriere 
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * Seteaza data de inceput a evenimentului
     * @param inceput 
     */
    public void setInceput(Date inceput) {
        this.inceput = inceput;
    }

    /**
     * Seteaza data de sfarsit a evenimentului
     * @param sfarsit 
     */
    public void setSfarsit(Date sfarsit) {
        this.sfarsit = sfarsit;
    }

    /**
     * Seteaza alarma evenimentului
     * @param alarma 
     */
    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    /**
     * Seteaza culoarea evenimentului
     * @param culoare 
     */
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
}
