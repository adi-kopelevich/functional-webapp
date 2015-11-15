package sample.parallel.prime.number;

/**
 * Created by kopelevi on 15/11/2015.
 */
public class SingleThread {

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n <= 0) {
            throw new IllegalArgumentException("Expected positive number, given: " + n);
        }
        if (n != 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }


}
