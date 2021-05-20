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
        
    }
    
}
