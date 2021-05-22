package Exceptions;

/**
 * Exceptie: Anul trebuie sa aiba 4 cifre
 * 
 * @author Ale-PC
 */
public class Exceptie4cifre extends Exception {

    @Override
    public String toString() {
        return "Anul trebuie sa aiba 4 cifre! MAI INCEARCA!";
    }
}
