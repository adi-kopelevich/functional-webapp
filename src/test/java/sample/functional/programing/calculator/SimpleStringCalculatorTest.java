package sample.functional.programing.calculator;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by kopelevi on 27/08/2015.
 */
public class SimpleStringCalculatorTest {

    SimpleStringCalculator cal;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initCalculator() {
        cal = new SimpleStringCalculator();
    }

    @After
    public void tearDown() {
        cal = null;
    }

    @Test
    public void whenGivenPrimeNumThenReturnTrue() {
        Assert.assertEquals(cal.isPrime("7"), true);
    }

    @Test
    public void whenGivenNonPrimeNumThenReturnFalse() {
        Assert.assertEquals(cal.isPrime("8"), false);
    }

    @Test
    public void whenGivenNonNumThenThrowException() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Not a valid number");
        Assert.assertEquals(cal.isPrime("x"), false);
    }
}
