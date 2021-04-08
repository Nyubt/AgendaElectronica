/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *  Clasa eveniment creaza un obiect cu informatii despre un singur eveniment
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
     * Culoarea evenimentului
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
     * @param titlu
     * @param descriere
     * @param inceput
     * @param sfarsit
     * @param alarma
     * @param culoare 
     */
    public Eveniment(int id, String titlu, String descriere, Date inceput, Date sfarsit, Alarma alarma, String culoare, boolean alarmaPornita, boolean inactive) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
        this.inceput = inceput;
        this.sfarsit = sfarsit;
        this.alarma = alarma;
        this.culoare = culoare;
        this.alarmaPornita = alarmaPornita;
        this.inactive = inactive;
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
     * Returneaza starea evenimentului
     * @return true or false
     */
    public boolean getInactiveState(){
        return this.inactive;
    }
    
    /**
     * Returneaza daca alarma e pornita sau nu
     * @return 
     */
    public boolean isAlarmaPornita(){
        return this.alarmaPornita;
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
    
    /**
     * Seteaza alarma pornita la true sau false
     * @param alarmaPornita 
     */
    public void setStareAlarma(boolean alarmaPornita){
        this.alarmaPornita = alarmaPornita;
    }
    
    /**
     * Seteaza starea evenimentului
     * @param inactive 
     */
    public void setInactiveState(boolean inactive){
        this.inactive = inactive;
    }
    
    /**
     * Supraincarcarea metodei equals pentru obiectul Eveniment
     * @param obj
     * @return 
     */
    @Override  
    public boolean equals(Object obj)   
    {  
        if (obj == null)
            return false;  
        if (obj == this)  
            return true;  
        return (this.id == ((Eveniment) obj).id);  
    } 
}
