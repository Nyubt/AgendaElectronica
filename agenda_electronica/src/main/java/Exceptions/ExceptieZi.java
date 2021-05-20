package Exceptions;

/**
 *
 * @author Ale-PC
 */

/**
 * ExceptieZi: Ziua poate sa fie intre 1 si 31
 */
public class ExceptieZi extends Exception{
     public String toString(){
		 return "Ziua poate sa fie intre 1 si 31! MAI INCEARCA!";
		}
}
