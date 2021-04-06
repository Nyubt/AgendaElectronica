/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
import java.util.List;

/**
 * Clasa Container manipuleaza cu evenimentele din baza de date
 *  
 */
public class Container {
    /**
     * Lista de evenimente
     */
    List<Eveniment> evenimente;
    
    /**
     * Returneaza evenimentele dintr-o zi
     * @param data
     * @return
     */
    public Zi FurnizareZi(Date data) {
        //citire din DB pt anumita zi
        return null;
    }

    /**
     * Returneaza evenimentele dintr-o luna
     * @param data
     * @return
     */
    public Luna FurnizareLuna(Date data) {
        //
        return null;
    }

    /**
     * Returneaza evenimentele dintr-o saptamana
     * @param data
     * @return
     */
    public Saptamana FurnizareSaptamana(Date data) {
        return null;
    }

    /**
     * Returneaza evenimentele dintr-un an
     * @param data
     * @return
     */
    public An FurnizareAn(Date data) {
        return null;
    }

    /**
     * Returneaza toate evenimentele din baza de date
     * @return
     */
    public List <Eveniment> FurnizareToateEvent() {
        return null;
    }

    /**
     * Modifica un eveniment
     * @param eveniment 
     */
    public void ModificareEvent(Eveniment eveniment) {

    }

    /**
     * Anuleaza un eveniment
     * @param eveniment 
     */
    public void AnulareEvent(Eveniment eveniment) {

    }

    /**
     * Returneaza lista de alarme
     * @param alarma
     * @return 
     */
    public Alarma FurnizareAlarme(Alarma alarma) {
        return null;
    }
}
