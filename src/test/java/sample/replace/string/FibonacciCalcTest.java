package sample.replace.string;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class FibonacciCalcTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {

    }

    @Test
    public void whenGivenNegativeNumberThenIllegalArgumentThrown() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(MessagesUtils.GIVEN_NEGATIVE_NUMBER_MSG);
        int fibIndex = getPositiveNumber() * -1;
        new FibonacciCalc().doFib(fibIndex);
    }

    @Test
    public void whenGiven0ThenReturn1() {
        int fibNumber = new FibonacciCalc().doFib(0);
        Assert.assertEquals(1, fibNumber);
    }

    @Test
    public void whenGiven1ThenReturn1() {
        int fibNumber = new FibonacciCalc().doFib(1);
        Assert.assertEquals(1, fibNumber);
    }

    @Test
    public void whenGivenNumberThenReturnTheSumOfPrevAndPrevPrev() {
        FibonacciCalc fibonacciCalc = new FibonacciCalc();
        int fibIndex = getPositiveNumber() + 2;
        int fibPrevNum = fibonacciCalc.doFib(fibIndex - 1);
        int fibPrevPrevNum = fibonacciCalc.doFib(fibIndex - 2);
        int fibNumber = fibonacciCalc.doFib(fibIndex);
        Assert.assertEquals(fibPrevNum + fibPrevPrevNum, fibNumber);
    }

    private int getPositiveNumber() {
        return new Random().nextInt(10000);
    }
}
