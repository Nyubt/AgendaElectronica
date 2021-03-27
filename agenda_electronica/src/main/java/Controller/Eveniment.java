/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 * @author Ale-PC
 */
public class Eveniment {

    private String titlu;
    private String descriere;
    private Date inceput;
    private Date sfarsit;
    Alarma alarma;
    private String culoare;

    public Eveniment(String t, String d, Date i, Date s, Alarma a, String c) {
        titlu = t;
        descriere = d;
        inceput = i;
        sfarsit = s;
        alarma = a;
        culoare = c;
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
        titlu = t;
    }

    public void setDescriere(String d) {
        descriere = d;
    }

    public void setInceput(Date i) {
        inceput = i;
    }

    public void setSfarsit(Date s) {
        sfarsit = s;
    }

    public void setAlarma(Alarma a) {
        alarma = a;
    }

    public void setCuloare(String c) {
        culoare = c;
    }
}
