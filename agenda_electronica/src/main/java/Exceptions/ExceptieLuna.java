package Exceptions;

/**
 * ExceptieLuna: Luna poate sa fie intre 1 si 12
 * 
 * @author Ale-PC
 */
public class ExceptieLuna extends Exception {

    @Override
    public String toString() {
        return "Luna poate sa fie intre 1 si 12! MAI INCEARCA!";
    }
}
