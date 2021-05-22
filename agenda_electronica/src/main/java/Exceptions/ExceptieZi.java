package Exceptions;

/**
 * ExceptieZi: Ziua poate sa fie intre 1 si 31
 * 
 * @author Ale-PC
 */
public class ExceptieZi extends Exception {

    @Override
    public String toString() {
        return "Ziua poate sa fie intre 1 si 31! MAI INCEARCA!";
    }
}
