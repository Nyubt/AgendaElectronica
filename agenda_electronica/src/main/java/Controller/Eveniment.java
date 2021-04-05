/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 *  
 */
public class Eveniment {

    private String titlu;
    private String descriere;
    private Date inceput;
    private Date sfarsit;
    Alarma alarma;
    private String culoare;

    public Eveniment(String t, String d, Date i, Date s, Alarma a, String c) {
        this.titlu = t;
        this.descriere = d;
        this.inceput = i;
        this.sfarsit = s;
        this.alarma = a;
        this.culoare = c;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public Date getInceput() {
        return inceput;
    }

    public Date getSfarsit() {
        return sfarsit;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setTitlu(String t) {
        this.titlu = t;
    }

    public void setDescriere(String d) {
        this.descriere = d;
    }

    public void setInceput(Date i) {
        this.inceput = i;
    }

    public void setSfarsit(Date s) {
        this.sfarsit = s;
    }

    public void setAlarma(Alarma a) {
        this.alarma = a;
    }

    public void setCuloare(String c) {
        this.culoare = c;
    }
}
