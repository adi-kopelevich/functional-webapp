package sample.parallel.prime.number;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

/**
 * Created by kopelevi on 15/11/2015.
 */
public class PrimeNumChecekerTest {

    PrimeNumChecker primeNumChecker;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
//        primeNumChecker = new SingleThreadImpl();
//        primeNumChecker = new ParallelStreamImpl();
        primeNumChecker = new ExecutorServiceImpl();
    }

    @Test
    public void whenGivenNegativeNumberThenThrowIllegalException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expected positive number");
        int negativeNumber = getPositiveNumber() * -1;
        primeNumChecker.isPrime(negativeNumber);
    }

    @Test
    public void whenGivenZeroThenThrowIllegalException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expected positive number");
        primeNumChecker.isPrime(0);
    }

    @Test
    public void whenGivenOneThenReturnTrue() {
        boolean isPrime = primeNumChecker.isPrime(1);
        Assert.assertEquals(true, isPrime);
    }

    @Test
    public void whenGivenANonPrimeNumberThenReturnFalse() {
        int nonPrimeNumber = getPositiveNumber() * getPositiveNumber();
        boolean isPrime = primeNumChecker.isPrime(nonPrimeNumber);
        Assert.assertEquals(false, isPrime);
    }

    @Test
    public void whenGivenAPrimeNumberThenReturnTrue() {
        int[] primesList = {2, 3, 5, 7, 11, 13, 17, 19};
        int primeNumIndex = new Random().nextInt(primesList.length);
        int primeNumber = primesList[primeNumIndex];
        boolean isPrime = primeNumChecker.isPrime(primeNumber);
        Assert.assertEquals(true, isPrime);
    }

    private int getPositiveNumber() {
        return new Random().nextInt(10000);
    }

}
