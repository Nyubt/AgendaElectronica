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
public class RecurentaTest {
    
    public RecurentaTest() {
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
     * Test of getModRecurenta method, of class Recurenta.
     */
    @Test
    public void testGetModRecurenta() {
        System.out.println("getModRecurenta");
        Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
        Recurenta instance = new Recurenta(4,enddate);
        int expResult = 4;
        int result = instance.getModRecurenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
    }

    /**
     * Test of getDataSfarsit method, of class Recurenta.
     */
    @Test
    public void testGetDataSfarsit() {
        System.out.println("getDataSfarsit");
        Date enddate = new GregorianCalendar(2015, Calendar.FEBRUARY, 11).getTime();
        Recurenta instance = new Recurenta(4,enddate);
        Date expResult = enddate;
        Date result = instance.getDataSfarsit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
