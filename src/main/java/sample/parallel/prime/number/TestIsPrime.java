package sample.parallel.prime.number;

/**
 * Created by kopelevi on 15/11/2015.
 */
public class TestIsPrime {

    public static void main(String[] args) {
        int number = 179424937;
        long startTime = System.currentTimeMillis();
        SingleThread.isPrime(number);
        long endTime = System.currentTimeMillis();
        System.out.println("SingleThread - Total execution time (ms) = " + String.valueOf(endTime - startTime));

        startTime = System.currentTimeMillis();
        ParallelStream.isPrime(number);
        endTime = System.currentTimeMillis();
        System.out.println("ParallelStream - Total execution time (ms) = " + String.valueOf(endTime - startTime));
    }
}
