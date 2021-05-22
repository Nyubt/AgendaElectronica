/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

import Exceptions.Exceptie4cifre;
import Exceptions.ExceptieFebruarie;
import Exceptions.ExceptieLuna;
import Exceptions.ExceptieZi;
import Exceptions.LimiteAni;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * Clasa DateTimeValidator pentru validarea datei si orei
 * 
 * @author Ale-PC, Elena
 */
public class DateTimeValidator {
    /**
     * Valideaza data unui eveniment
     * 
     * @param day ziua evenimentului
     * @param month luna evenimentului
     * @param year anul evenimentului
     * @return valoare de adevar a testului de validare
     */
    public static boolean validateDateInput(String day, String month, String year) {        
        return validateYear(year) && validateMonth(month) && validateDate(day, month);
    }
    
    /**
     * Valideaza anul unui eveniment format yyyy
     * 
     * @param year anul evenimentului. Ales sa fie intre 2018 si 2030 pentru aplicatia curenta
     * @return valoare de adevar a testului de validare 
     */
    private static boolean validateYear(String year){
        boolean dateValid = true;
        try {
            if (Integer.parseInt(year) < 2018 || Integer.parseInt(year) > 2030) {
                throw new LimiteAni();
            }
            int n = Integer.parseInt(year);
            int nrCifre = 0;
            while (n != 0) {
                nrCifre++;
                n = n / 10;
            }
            if (nrCifre != 4) {
                throw new Exceptie4cifre();
            }
        } catch (NumberFormatException e) {
            dateValid = false;
            System.out.println("Exceptie : Introduceti doar cifre in caseta pt an!");
        } catch (Exceptie4cifre ex) {
            dateValid = false;
            System.out.println("Exceptie : " + ex.toString());
        } catch (LimiteAni ex) {
            dateValid = false;
            System.out.println("Exceptie : " + ex.toString());
        }
        return dateValid;
    }
    
    /**
     * Valideaza luna unui eveniment
     * 
     * @param month luna evenimentului
     * @return valoare de adevar a testului de validare 
     */
    private static boolean validateMonth(String month){
        boolean dateValid = true;
        try {
            if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
                throw new ExceptieLuna();
            }
        } catch (ExceptieLuna ex) {
            dateValid = false;
            System.out.println("Exceptie : " + ex.toString());
        } catch (NumberFormatException e) {
            dateValid = false;
            System.out.println("Exceptie : Introduceti doar cifre in caseta pt luna!");
        }
        return dateValid;
    }
    
    /**
     * Valideaza ziua unui eveniment
     * 
     * @param day ziua evenimentului
     * @param month luna evenimentului
     * @return valoare de adevar a testului de validare 
     */
    private static boolean validateDate(String day, String month){
        boolean dateValid = true;
        try {
            if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31) {
                throw new ExceptieZi();
            }
            if (Integer.parseInt(month) == 2 && Integer.parseInt(day) > 29) {
                throw new ExceptieFebruarie();
            }
        } catch (NumberFormatException e) {
            dateValid = false;
            System.out.println("Exceptie : Introduceti doar cifre in caseta pt zi!");
        } catch (ExceptieZi ex) {
            dateValid = false;
            System.out.println("Exceptie : " + ex.toString());
        } catch (ExceptieFebruarie ex) {
            dateValid = false;
            System.out.println("Exceptie : " + ex.toString());
        }
        return dateValid;
    }

    /**
     * Valideaza timpul declansarii unui eveniment
     * 
     * @param inputTimeString timpul declansarii evenimentului format hh:mm:ss
     * @return valoare de adevar a testului de validare 
     */
    public static boolean validateTimeInput(String inputTimeString) {
        try {
            LocalTime.parse(inputTimeString);

        } catch (DateTimeParseException | NullPointerException e) {
            System.out.println("Invalid time string: " + inputTimeString + "\n" + e.getMessage());
            return false;
        }
        return true;
    }    
}
