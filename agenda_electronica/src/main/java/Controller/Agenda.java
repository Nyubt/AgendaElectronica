/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
import java.util.Timer;

/**
 *
 * 
 */
public class Agenda {

    private String modAfisare;
    private Date data;
    Alarma alarme;
    Timer timer;

    public Agenda(String modafis, Date d, Alarma alarm, Timer time) {
        this.modAfisare = modafis;
        this.data = d;
        this.alarme = alarm;
        this.timer = time;
    }
    
    public String getModAfisare() {
        return modAfisare;
    }

    public Date getData() {
        return data;
    }

    public Alarma getAlarma() {
        return alarme;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setModAfisare(String m) {
        this.modAfisare = m;
    }

    public void setData(Date d) {
        this.data = d;
    }

    public void setAlarma(Alarma a) {
        this.alarme = a;
    }

    public void setTimer(Timer t) {
        this.timer = t;
    }
    
    void Afisare() {
    }

    ;
    void SelectareEvent() {
    }

    ;
    void ModificareEvent() {
    }

    ;
    void AnulareEvent() {
    }

    ;
    void AmanareAlarma() {
    }

    ;
    void OprireAlarma() {
    }
;

}
