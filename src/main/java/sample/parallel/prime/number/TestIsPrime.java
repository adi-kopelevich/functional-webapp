package sample.parallel.prime.number;

/**
 * Created by kopelevi on 15/11/2015.
 */
public class TestIsPrime {

    public static void main(String[] args) {
        int number = 179424937;
        long startTime = System.currentTimeMillis();
        new SingleThreadImpl().isPrime(number);
        long endTime = System.currentTimeMillis();
        System.out.println("SingleThreadImpl - Total execution time (ms) = " + String.valueOf(endTime - startTime));

        startTime = System.currentTimeMillis();
        new ParallelStreamImpl().isPrime(number);
        endTime = System.currentTimeMillis();
        System.out.println("ParallelStreamImpl - Total execution time (ms) = " + String.valueOf(endTime - startTime));

        startTime = System.currentTimeMillis();
        new ExecutorServiceImpl().isPrime(number);
        endTime = System.currentTimeMillis();
        System.out.println("ExecutorServiceImpl - Total execution time (ms) = " + String.valueOf(endTime - startTime));

    }
}
