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
public class FizzBuzzStringTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {

    }

    @Test
    public void whenGivenNegativeNumberThenIllegalArgumentThrown() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(MessagesUtils.GIVEN_NEGATIVE_NUMBER_MSG);
        int number = getPositiveNumber() * -1;
        new FizzBuzzString().getFizzBuzzString(number);
    }

    @Test
    public void whenGivenZeroThenReturnEmptyString() {
        int number = 0;
        Assert.assertEquals("", new FizzBuzzString().getFizzBuzzString(number));
    }

    @Test
    public void whenGivenNumberThenPrintFizzBuzzStringRep() {
        int number = 47;
        String fizzBuzzStringFor47 = "1-2-Fizz-4-Buzz-Fizz-7-8-Fizz-Buzz-11-Fizz-13-14-FizzBuzz-16-17-Fizz-19-Buzz-Fizz-22-23-Fizz-Buzz-26-Fizz-28-29-FizzBuzz-31-32-Fizz-34-Buzz-Fizz-37-38-Fizz-Buzz-41-Fizz-43-44-FizzBuzz-46-47-";
        Assert.assertEquals(fizzBuzzStringFor47,new FizzBuzzString().getFizzBuzzString(number));
    }

    private int getPositiveNumber() {
        return new Random().nextInt(10000);
    }

}
