package primes;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 

public class PrintPrimesTest {

    PrintPrimes met;

    @Before
    public void setUp() throws Exception {
        met = new PrintPrimes();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test() {
        assertEquals("2 3 5 7 11 ", met.printPrimes(5));
    }

}