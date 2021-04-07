/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * Clasa Agenda face legatura dintre interfata agendei si metodele de manipulare a evenimentelor
 * 
 */
public class Agenda {
    /**
     * Modul de afisare a agendei
     */
    private String modAfisare;
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
    List <Timer> timer;

    /**
     * Constructorul clasei Agenda
     * @param modAfisare
     * @param data
     * @param alarma
     * @param timer 
     */
    public Agenda(String modAfisare, Date data, List <Alarma> alarma, List <Timer> timer) {
        this.modAfisare = modAfisare;
        this.data = data;
        this.alarme = alarma;
        this.timer = timer;
    }
    
    /**
     * Returneaza modul de afisare
     * @return 
     */
    public String getModAfisare() {
        return modAfisare;
    }

    /**
     * Returneaza data
     * @return 
     */
    public Date getData() {
        return data;
    }

    /**
     * Returneaza lista de alarme
     * @return 
     */
    public List <Alarma> getAlarma() {
        return alarme;
    }

    /**
     * Returneaza lista de timere
     * @return 
     */
    public List <Timer> getTimer() {
        return timer;
    }

    /**
     * Seteaza modul de afisare
     * @param modAfisare 
     */
    public void setModAfisare(String modAfisare) {
        this.modAfisare = modAfisare;
    }

    /**
     * Seteaza data
     * @param data 
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Seteaza lista de alarme
     * @param alarma 
     */
    public void setAlarma(List <Alarma> alarma) {
        this.alarme = alarma;
    }

    /**
     * Seteaza lista de timere
     * @param timer 
     */
    public void setTimer(List <Timer> timer) {
        this.timer = timer;
    }
    
    /**
     * Afisarea unui eveniment
     */
    }

    /**
     * Selectarea unui eveniment
     */
    }

    /**
     * Modificarea unui eveniment
     */
    public void ModificareEvent() {
    }

    /**
     * Anularea unui eveniment
     */
    public void AnulareEvent() {
    }

    /**
     * Amanarea alarmei
     */
    public void AmanareAlarma() {
    }

    /**
     * Oprireaz alarmei
     */
    public void OprireAlarma() {
    }
;

}
