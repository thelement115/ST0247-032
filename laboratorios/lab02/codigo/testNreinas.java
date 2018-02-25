

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testNreinas.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testNreinas
{
    /**
     * Default constructor for test class testNreinas
     */
    public testNreinas()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    public void Nreinas(){
        int uno = Nreinas.nreinas(1);
        int dos = Nreinas.nreinas(2);
        int tres = Nreinas.nreinas(3);
        int cuatro = Nreinas.nreinas(4);
        int cinco = Nreinas.nreinas(5);
        int seis = Nreinas.nreinas(6);
        int siete = Nreinas.nreinas(7);
        int ocho = Nreinas.nreinas(8);
        
        assertEquals(uno,1);
        assertEquals(dos,0);
        assertEquals(tres,0);
        assertEquals(cuatro,2);
        assertEquals(cinco,10);
        assertEquals(seis,4);
        assertEquals(siete,40);
        assertEquals(ocho,92);
    }

    @Test
    public void nreinas()
    {
    }
}

