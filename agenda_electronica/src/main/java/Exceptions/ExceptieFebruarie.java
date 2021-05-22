package Exceptions;

/**
 * Exceptie pentru luna Februarie: poate avea doar 29 zile
 * 
 * @author Ale-PC
 */
public class ExceptieFebruarie extends Exception {

    @Override
    public String toString() {
        return "Luna februarie are 29 zile! MAI INCEARCA!";
    }
}
