package Model;

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
public class AlarmaTest {
    
    public AlarmaTest() {
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
     * Test of getIntervalTimp method, of class Alarma.
     */
    @Test
    public void testGetIntervalTimp() {
        System.out.println("getIntervalTimp");
        Alarma instance = new Alarma(1,2);
        int expResult = 1;
        int result = instance.getIntervalTimp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getFactorRecurenta method, of class Alarma.
     */
    @Test
    public void testGetFactorRecurenta() {
        System.out.println("getFactorRecurenta");
        Alarma instance = new Alarma(2,3);
        int expResult = 3;
        int result = instance.getFactorRecurenta();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setIntervalTimp method, of class Alarma.
     */
    @Test
    public void testSetIntervalTimp() {
        System.out.println("setIntervalTimp");
        int intervalTimp = 20;
        Alarma instance = new Alarma(2,3);
        instance.setIntervalTimp(intervalTimp);
        int expResult = 20;
        int result = instance.getIntervalTimp();
         assertEquals(expResult, result); 
    }

    /**
     * Test of setFactorRecurenta method, of class Alarma.
     */
    @Test
    public void testSetFactorRecurenta() {
        System.out.println("setFactorRecurenta");
        int factorRecurenta = 15;
      Alarma instance = new Alarma(2,3);
        instance.setFactorRecurenta(factorRecurenta);
         int expResult = 15;
        int result = instance.getFactorRecurenta();
         assertEquals(expResult, result); 
    }
    
}
