package sample.parallel.prime.number;

import java.util.stream.IntStream;

/**
 * Created by kopelevi on 15/11/2015.
 */
public class ParallelStreamImpl implements PrimeNumChecker{

    public boolean isPrime(final int n) {
        boolean isPrime = true;
        if (n <= 0) {
            throw new IllegalArgumentException("Expected positive number, given: " + n);
        }
        if (IntStream.range(2, n)
                .limit(Runtime.getRuntime().availableProcessors()).parallel()
                .filter(x -> n % x == 0)
                .count() > 0) {
            isPrime = false;
        }
        return isPrime;
    }

}
