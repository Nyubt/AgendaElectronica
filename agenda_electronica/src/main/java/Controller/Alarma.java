/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Ale-PC
 */
public class Alarma {

    //alarma sonora care se va declanșa la un interval de timp setat de utilizator înaintea evenimentului
    protected int intervalTimp;
    // factor de recurenta dat în minute, care o va face sa se declanseze din timp în timp până când este oprită de utilizator
    protected int factorRecurenta;

    public Alarma(int intervalT, int recurenta) {
        intervalTimp = intervalT;
        factorRecurenta = recurenta;
    }

    public int getIntervalTimp() {
        return intervalTimp;
    }

    public int getFactorRecurenta() {
        return factorRecurenta;
    }

    public void setIntervalTimp(int t) {
        intervalTimp = t;
    }

    public void setFactorRecurenta(int f) {
        factorRecurenta = f;
    }
}
