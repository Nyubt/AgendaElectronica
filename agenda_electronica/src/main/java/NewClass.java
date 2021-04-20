/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nadia
 */
import java.math.BigInteger;

public class NewClass {

   
    public static void main(String[] args) {
        BigInteger nn = new BigInteger("8716664131891073309298060436222387808362956786786341866937428783455365962391673917249574491595229207084297741464557132198229086365652604590297378403184129");
        int p = 13;
        int q= 17;
        double n;
        n=p*q;
        int c_p=10;
        int c_q=6;
        int N_p = 13*17/13;
        int N_q = 13*17/17;
        double pow=Math.pow(17, -1);
         double pow_2 =Math.pow(13, -1);
        
         double M_p = pow mod 13;
         double M_q = pow_2 mod 17;
        double x = (N_p * M_p * c_p + N_q * M_q * c_q);
        BigInteger c = new BigInteger("1375865583010982618632308529423371271821438577980922927124130396877925863587827122886875024570556859122064458153631");
       
        System.out.println("\nm = " + m.toString());

    }
}
