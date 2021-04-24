/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 * Clasa Luna creeaza un obiect cu informatii despre evenimentele dintr-o luna
 * 
 */
public class Luna implements ListEventsInterface {
    /**
     * Lista de obiecte Zi dintr-o luna
     */
    private List <Zi> luna;

    /**
     * Constructorul clasei Luna
     * @param zile 
     */
    public Luna(List <Zi> zile) {
        this.luna = zile;
    }

    /**
     * Returneaza lista cu obiectele Zi dintr-o luna
     * @return 
     */
    public List <Zi> getEventList () {
        return this.luna;
    }   
}
