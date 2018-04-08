
import graph.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class prueba.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class prueba
{
    /**
     * Default constructor for test class prueba
     */
    public prueba()
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
    
    @Test
    public void vcm(){
        Digraph a = new Digraph (5);
        a.addArc(0,1,4);
        a.addArc(0,2,4);
        a.addArc(0,4,6);
        a.addArc(0,3,6);
        a.addArc(1,2,2);
        a.addArc(1,0,4);
        a.addArc(2,1,2);
        a.addArc(2,0,4);
        a.addArc(2,3,8);
        a.addArc(3,0,6);
        a.addArc(3,2,8);
        a.addArc(3,4,9);
        a.addArc(4,0,6);
        a.addArc(4,3,9);
        ArrayList<Integer> c = travelSalesMan.VMC(a);
        ArrayList<Integer> d = new ArrayList <> ();
        for(int i =0; i<c.size(); ++i){
           System.out.println(c.get(i));
        }
        d.add(0);
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(0);
        assertEquals(c,d);
    }
}
