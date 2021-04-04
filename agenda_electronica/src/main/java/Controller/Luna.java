/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *Clasa luna
 */


public class Luna {
     /**
     *Atribut pentru stocare date zile
     */
    private Zi zile;

    public Luna(Zi z) {
        this.zile = z;
    }
  /**
     * getter pentru a intoarce ziua
*/
    public Zi getLuna() {
        return zile;
    }

    public void setLuna(Zi z) {
        this.zile = z;
    }
}
