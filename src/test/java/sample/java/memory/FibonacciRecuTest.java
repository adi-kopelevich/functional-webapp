package sample.java.memory;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class FibonacciRecuTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void whenGiven0ThenReturnedValueIs1() throws Exception {
        Assert.assertEquals(1, Fibonacci.doRecuFib(0));
    }

    @Test
    public void whenGiven1ThenReturnedValueIs1() throws Exception {
        Assert.assertEquals(1, Fibonacci.doRecuFib(1));
    }

    @Test
    public void whenGivenNegativeNumberThenReturnedInavlidArgException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("negative number");
        int negativeNumber = (int) Math.random() * -100 - 1; //force negative number
        Fibonacci.doRecuFib(negativeNumber);
    }

    @Test
    public void whenGivenRandomNumberThenReturnedValueIsSumOfPrevious2Fibs() throws Exception {
        int randVal = (int) Math.random() * 100 + 2; //force positive number
        Assert.assertEquals(Fibonacci.doRecuFib(randVal - 1) + Fibonacci.doRecuFib(randVal - 2), Fibonacci.doRecuFib(randVal));
    }

    @Test
    public void whenGivenVeryLargerNumberThenExceptionIsThrown() throws Exception {
        expectedException.expect(StackOverflowError.class);
        Fibonacci.doRecuFib(1000000);
    }
}
