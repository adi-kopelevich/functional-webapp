package sample.parallel.prime.number;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

/**
 * Created by kopelevi on 15/11/2015.
 */
public class ParallelStreamTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void whenGivenNegativeNumberThenThrowIllegalException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expected positive number");
        int negativeNumber = getPositiveNumber() * -1;
        ParallelStream.isPrime(negativeNumber);
    }

    @Test
    public void whenGivenZeroThenThrowIllegalException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expected positive number");
        ParallelStream.isPrime(0);
    }

    @Test
    public void whenGivenOneThenReturnTrue() {
        boolean isPrime = ParallelStream.isPrime(1);
        Assert.assertEquals(true, isPrime);
    }

    @Test
    public void whenGivenANonPrimeNumberThenReturnFalse() {
        int nonPrimeNumber = getPositiveNumber() * getPositiveNumber();
        boolean isPrime = ParallelStream.isPrime(nonPrimeNumber);
        Assert.assertEquals(false, isPrime);
    }

    @Test
    public void whenGivenAPrimeNumberThenReturnTrue() {
        int[] primesList = {2, 3, 5, 7, 11, 13, 17, 19};
        int primeNumIndex = new Random().nextInt(primesList.length);
        int primeNumber = primesList[primeNumIndex];
        boolean isPrime = ParallelStream.isPrime(primeNumber);
        Assert.assertEquals(true, isPrime);
    }

    private int getPositiveNumber() {
        return new Random().nextInt(10000);
    }

}
