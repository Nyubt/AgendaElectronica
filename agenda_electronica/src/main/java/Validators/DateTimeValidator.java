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
 *
 * @author Elena
 */
public class DateTimeValidator {
    /**
     * Fuctie pentru a valida data introdusa
     *
     * @return validDate
     * @param day
     * @param month
     * @param year
     */
    public static boolean validateDateInput(String day, String month, String year) {        
        return validateYear(year) && validateMonth(month) && validateDate(day, month);
    }
    
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
