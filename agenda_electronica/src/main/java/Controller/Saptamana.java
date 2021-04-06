/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;

/**
 *  Clasa Saptamana creeaza un obiect cu informatii despre toate evenimentele dintr-o saptamana
 * 
 */
public class Saptamana {
    /**
     * Lista de obiecte Zi dintr-o saptamana
     */
    private List <Zi> saptamana;

    /**
     * Constructorul clasei Saptamana
     * @param zile 
     */
    public Saptamana(List <Zi> zile) {
        this.saptamana = zile;
    }

    /**
     * Returneaza lista cu obiectele Zi dintr-o saptamana
     * @return 
     */
    public List <Zi> getSaptamana() {
        return this.saptamana;
    }
}
