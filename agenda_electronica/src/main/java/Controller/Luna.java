/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;

/**
 *Clasa luna
 */


public class Luna {

      private List <Eveniment> evt;

    public Luna(List <Eveniment> e) {
        this.evt = e;
    }

    public List <Eveniment> getEvents() {
        return evt;
    }   
}
