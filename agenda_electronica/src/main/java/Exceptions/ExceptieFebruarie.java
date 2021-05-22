package Exceptions;

/**
 *
 * @author Ale-PC
 */
/**
 * Exceptie pentru luna Februarie: poate avea doar 29 zile
 */
public class ExceptieFebruarie extends Exception {

    public String toString() {
        return "Luna februarie are 29 zile! MAI INCEARCA!";
    }
}
