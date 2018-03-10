

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
    
    @Test
    public void Nreinas(){
       int []a4 = {1,3,0,2};
       int []b4 = Nreinas.nreinas(4);
       for (int i =0; i< 4; i++){
         assertEquals(a4[i],b4[i]);
        }
       int []a5 = {0,2,4,1,3};
       int []b5 = Nreinas.nreinas(5);
       for (int i =0; i< 5; i++){
         assertEquals(a5[i],b5[i]);
        }
       int []a6 = {1,3,5,0,2,4};
       int []b6 = Nreinas.nreinas(6);
       for (int i =0; i<6; ++i){
          assertEquals(a6[i],b6[i]);
        }
       int []a7 = {0,2,4,6,1,3,5};
       int []b7 = Nreinas.nreinas(7);
       for (int i =0; i<6; ++i){
          assertEquals(a7[i],b7[i]);
        }
       int []a8 = {0,4,7,5,2,6,1,3};
       int []b8 = Nreinas.nreinas(8);
       for (int i =0; i<7; ++i){
          assertEquals(a8[i],b8[i]);
        }
    }
}
