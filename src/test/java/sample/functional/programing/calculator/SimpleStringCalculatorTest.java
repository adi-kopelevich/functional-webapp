package sample.functional.programing.calculator;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kopelevi on 27/08/2015.
 */
public class SimpleStringCalculatorTest {

    private SimpleStringCalculator stringCalculator;

    public SimpleStringCalculatorTest() {

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initCalculator() {
        stringCalculator = new SimpleStringCalculator();
    }

    @After
    public void tearDown() {
        stringCalculator = null;
    }

    @Test
    public void whenGivenPrimeNumThenReturnTrue() {
        Assert.assertEquals(stringCalculator.isPrime("7"), true);
    }

    @Test
    public void whenGivenNonPrimeNumThenReturnFalse() {
        Assert.assertEquals(stringCalculator.isPrime("8"), false);
    }

    @Test
    public void whenGivenNonNumThenThrowException() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Not a valid number");
        Assert.assertEquals(stringCalculator.isPrime("x"), false);
    }

    @Test
    public void whenGiveListOfNumbersThenReturnTheSumOfEven() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertEquals(stringCalculator.sumEven(nums), 30);
    }

    // given a prime number return true
    @Test
    public final void whenGivenPrimeNumberThenReturnTrue() {
        Assert.assertEquals(true, stringCalculator.isPrime("3"));
    }

    // given a non prime number return false
    @Test
    public final void whenGivenNonPrimeNumberThenReturnFalse() {
        Assert.assertEquals(false, stringCalculator.isPrime("4"));
    }

    // given a non number throw exception
    @Test
    public final void whenGivenNonNumberThenTrhowException() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Not a valid number");
        stringCalculator.isPrime("x");
    }

    // get the double value of the fisrt number bigger than 3
    @Test
    public final void whenGivenListOfNumbersThenReturnTheDoubleOfFirstBiggerThan3() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertEquals(stringCalculator.getDoubleOfFirstNumberGreaterThan3(nums), 8);
    }


    // get the total values of  given numbers
    @Test
    public final void whenGivenListOfNumbersThenReturnTheTotalValue() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertEquals(stringCalculator.getTotalValues(nums), 55);
    }

    // get the total values of given even numbers
    @Test
    public final void whenGivenListOfNumbersThenReturnTheTotalValueOfTheEven() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertEquals(stringCalculator.getTotalEvenNumbers(nums), 30);
    }

    // get the total sum of the ducle values of given numbers
    @Test
    public final void whenGivenListOfNumbersThenReturnTheTotalSumOfThierDouble(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertEquals(stringCalculator.getSumOfDoubles(nums), 110);
    }
}