/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 * Clasa an
  
 */
public class An {

    /**
     *Atribut pentru stocare date luna
     */
    private Luna luni;

    /**
     * Clasa an constructor
     */
    public An(Luna l) {
        this.luni = l;
    }
  /**
     *getter pentru a intoarce luna
*/
    public Luna getLuni() {
        return luni;
    }

    public void setLuni(Luna l) {
        this.luni = l;
    }
}
