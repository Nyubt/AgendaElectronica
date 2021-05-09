/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ale-PC
 */
public class EvenimentTest {
    
    public EvenimentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getEvenimentId method, of class Eveniment.
     */
    @Test
    public void testGetEvenimentId() {
        System.out.println("getEvenimentId");
         Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
        Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        int expResult = 2;
        int result = instance.getEvenimentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getTitlu method, of class Eveniment.
     */
    @Test
    public void testGetTitlu() {
        System.out.println("getTitlu");
         Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
        Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        String expResult = "a";
        String result = instance.getTitlu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescriere method, of class Eveniment.
     */
    @Test
    public void testGetDescriere() {
        System.out.println("getDescriere");
         Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        
        String expResult = "b";
        String result = instance.getDescriere();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getInceput method, of class Eveniment.
     */
    @Test
    public void testGetInceput() {
        System.out.println("getInceput");
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
        Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        
        Date expResult =  new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date result = instance.getInceput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getSfarsit method, of class Eveniment.
     */
    @Test
    public void testGetSfarsit() {
        System.out.println("getSfarsit");
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        
        Date expResult = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
        Date result = instance.getSfarsit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getAlarma method, of class Eveniment.
     */
    @Test
    public void testGetAlarma() {
        System.out.println("getAlarma");
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        
        Alarma expResult = a;
        Alarma result = instance.getAlarma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCuloare method, of class Eveniment.
     */
    @Test
    public void testGetCuloare() {
        System.out.println("getCuloare");
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        String expResult = "c";
        String result = instance.getCuloare();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getInactiveState method, of class Eveniment.
     */
    @Test
    public void testGetInactiveState() {
        System.out.println("getInactiveState");
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        
        boolean expResult = false;
        boolean result = instance.getInactiveState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of isAlarmaPornita method, of class Eveniment.
     */
    @Test
    public void testIsAlarmaPornita() {
        System.out.println("isAlarmaPornita");
         Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
        Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        
        boolean expResult = true;
        boolean result = instance.isAlarmaPornita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTitlu method, of class Eveniment.
     */
    @Test
    public void testSetTitlu() {
        System.out.println("setTitlu");
        String titlu = "x";
         Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
      Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
       String expResult= "x";
        instance.setTitlu(titlu);
        String result= instance.getTitlu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescriere method, of class Eveniment.
     */
    @Test
    public void testSetDescriere() {
        System.out.println("setDescriere");
        String descriere = "y";
         Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        String expResult= "y";
       instance.setDescriere(descriere);
        String result= instance.getDescriere();
        assertEquals(expResult, result);
       
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setInceput method, of class Eveniment.
     */
    @Test
    public void testSetInceput() {
        System.out.println("setInceput");
        Date inceput = new GregorianCalendar(2014, Calendar.FEBRUARY, 25).getTime();
       Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
       Date expResult=new GregorianCalendar(2014, Calendar.FEBRUARY, 25).getTime();
        instance.setInceput(inceput);
        Date result=instance.getInceput();
         assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setSfarsit method, of class Eveniment.
     */
    @Test
    public void testSetSfarsit() {
        System.out.println("setSfarsit");
        Date sfarsit = new GregorianCalendar(2015, Calendar.FEBRUARY, 26).getTime();
       Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        Date expResult=sfarsit;
         instance.setSfarsit(sfarsit);
        Date result=instance.getSfarsit();
         assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAlarma method, of class Eveniment.
     */
    @Test
    public void testSetAlarma() {
        System.out.println("setAlarma");
        Alarma alarma = new Alarma(5,7);
Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);         Alarma expResult= alarma;
        instance.setAlarma(alarma);
        Alarma result=instance.getAlarma();
         assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCuloare method, of class Eveniment.
     */
    @Test
    public void testSetCuloare() {
        System.out.println("setCuloare");
        String culoare = "m";
       Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        String expResult=culoare;
        instance.setCuloare(culoare);
        String result=instance.getCuloare();
                 assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setStareAlarma method, of class Eveniment.
     */
    @Test
    public void testSetStareAlarma() {
        System.out.println("setStareAlarma");
        boolean alarmaPornita = false;
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        boolean expResult=alarmaPornita;
        instance.setStareAlarma(alarmaPornita);
        boolean result=instance.isAlarmaPornita();
         assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setInactiveState method, of class Eveniment.
     */
    @Test
    public void testSetInactiveState() {
        System.out.println("setInactiveState");
        boolean inactive = true;
        Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
        boolean expResult=inactive;
        instance.setInactiveState(inactive);
        boolean result=instance.isAlarmaPornita();
         assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Eveniment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
Date startdate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
         Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
Alarma a=new Alarma(2,2);
       Recurenta r=new Recurenta(1,enddate);
        Eveniment instance = new Eveniment(2,"a","b",startdate,enddate,a,r,"c",true,false);
                boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
