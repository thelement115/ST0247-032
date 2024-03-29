/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class DigraphALTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DigraphALTest
{
    /**
     * Default constructor for test class DigraphAMTest
     */
    public DigraphALTest()
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
    public void From0To3()
    {
       DigraphAL dgal = new DigraphAL(5);
       dgal.addArc(0,1,10);
       dgal.addArc(0,2,3);
       dgal.addArc(1,2,1);
       dgal.addArc(1,3,2);
       dgal.addArc(2,1,4);
       dgal.addArc(2,3,8);
       dgal.addArc(2,4,2);
       dgal.addArc(3,4,7);
       dgal.addArc(4,3,9);
       ArrayList path = DigraphAlgorithms.getPath(DigraphAlgorithms.dijsktra(dgal,0),0,3);
       assertEquals(path.get(0),0);
       assertEquals(path.get(1),2);
       assertEquals(path.get(2),1);
       assertEquals(path.get(3),3);

    }
}
