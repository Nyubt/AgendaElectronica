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

    protected int intervalTimp;
    protected String factorRecurenta;

    public Alarma(int intervalT, String recurenta) {
        intervalTimp = intervalT;
        factorRecurenta = recurenta;
    }

    public int getIntervalTimp() {
        return intervalTimp;
    }

    public String getFactorRecurenta() {
        return factorRecurenta;
    }

    public void setIntervalTimp(int t) {
        intervalTimp = t;
    }

    public void setFactorRecurenta(String f) {
        factorRecurenta = f;
    }
}
