

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class BFSTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BFSTest
{
    /**
     * Default constructor for test class BFSTest
     */
    public BFSTest()
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
    public void bfs()
    {
        DigraphAL g1 = new DigraphAL (6);
        g1.addArc(0,1,1);
        g1.addArc(0,2,1);
        g1.addArc(1,3,1);
        g1.addArc(1,4,1);
        g1.addArc(2,5,1);
        
        DigraphAM g2 = new DigraphAM (6);
        g2.addArc(0,1,1);
        g2.addArc(0,2,1);
        g2.addArc(1,3,1);
        g2.addArc(1,4,1);
        g2.addArc(2,5,1);
        
        ArrayList<Integer> res1 = new ArrayList<>();
        res1.add(0);
        res1.add(1);
        res1.add(2);
        res1.add(3);
        res1.add(4);
        res1.add(5);
        ArrayList<Integer> a = BFS.bfs(g1);
        ArrayList<Integer> b = BFS.bfs(g2);
        
        assertEquals(res1,a);
        assertEquals(res1,b);
    }
}
