/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 * Clasa Zi creeaza un obiect cu informatii despre evenimentele dintr-o zi
 * 
 */
public class Zi implements ListEventsInterface {
    /**
     * Lista de obiecte Eveniment dintr-o zi
     */
    private List <Eveniment> eveniment;

    /**
     * Constructorul clasei Zi
     * @param eveniment 
     */
    public Zi(List <Eveniment> eveniment) {
        this.eveniment = eveniment;
    }

    /**
     * Returneaza lista de obiecte Eveniment
     * @return 
     */
    public List <Eveniment> getEventList() {
        return this.eveniment;
    }
}
