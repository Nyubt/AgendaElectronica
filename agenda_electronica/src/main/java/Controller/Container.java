/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
import java.util.List;

/**
 *
 *  
 * @author Nadia
 */
public class Container {
    
    List<Eveniment> evt;
    
    /**
     *
     * @param data
     * @return
     */
    public Zi FurnizareZi(Date data) {
        //citire din DB pt anumita zi
        return null;
    }

    /**
     *
     * @param data
     * @return
     */
    public Luna FurnizareLuna(Date data) {
        //
        return null;
    }

    /**
     *
     * @param data
     * @return
     */
    public Saptamana FurnizareSaptamana(Date data) {
        return null;
    }

    /**
     *
     * @param data
     * @return
     */
    public An FurnizareAn(Date data) {
        return null;
    }

    /**
     *
     * @return
     */
    public Eveniment FurnizareToateEvent() {
        return null;
    }

    /**
     *
     * @param e
     */
    public void ModificareEvent(Eveniment e) {

    }

    /**
     *
     * @param e
     */
    public void AnulareEvent(Eveniment e) {

    }

    /**
     *
     * @param a
     * @return
     */
    public Alarma FurnizareAlarme(Alarma a) {
        return null;
    }
}
