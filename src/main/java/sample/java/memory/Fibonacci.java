package sample.java.memory;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class Fibonacci {

    public static int doRecuFib(int i) {
        int retVal;
        if (i < 0) {
            throw new IllegalArgumentException("Invalid param, negative number was given: " + i);
        } else if (i == 0) {
            retVal = 1;
        } else if (i == 1) {
            retVal = 1;
        } else {
            retVal = doRecuFib(i - 1) + doRecuFib(i - 2);
        }
        return retVal;
    }

    public static int doIterFib(int i) {
        int retVal;
        if (i < 0) {
            throw new IllegalArgumentException("Invalid param, negative number was given: " + i);
        } else if (i == 0) {
            retVal = 1;
        } else if (i == 1) {
            retVal = 1;
        } else {
            int prev = 1;
            int current = 1;
            for (int j = 2; j <= i; j++) {
                int tmp = current;
                current += prev;
                prev = tmp;
            }
            retVal = current;
        }
        return retVal;
    }

}
