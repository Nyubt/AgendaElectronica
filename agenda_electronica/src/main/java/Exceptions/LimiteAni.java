package Exceptions;

/**
 * Exceptie LimiteAni: Ani pot fi alesi intre 2018 si 2030
 * 
 * @author Ale-PC
 */
public class LimiteAni extends Exception {

    @Override
    public String toString() {
        return "Ani pot fi alesi intre 2018 si 2030! MAI INCEARCA!";
    }

}
