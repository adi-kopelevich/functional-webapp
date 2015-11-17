package sample.replace.string;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class FibonacciCalc {

    public int doFib(int i) {
        int fibNumber;

        if (i < 0) {
                throw new IllegalArgumentException(MessagesUtils.GIVEN_NEGATIVE_NUMBER_MSG);
        } else if (i == 0 || i == 1) {
            fibNumber = 1;
        } else {
            int prevFibNumber = 1;
            int prevPrevFibNumber = 1;
            int tmp;
            for (int j = 2; j < i; j++) {
                tmp = prevFibNumber;
                prevFibNumber = prevPrevFibNumber + prevFibNumber;
                prevPrevFibNumber = tmp;
            }
            fibNumber = prevFibNumber + prevFibNumber;
        }
        return fibNumber;
    }

    public int doFibRecursion(int i) {
        int fibNumber;
        if (i < 0) {
            throw new IllegalArgumentException(MessagesUtils.GIVEN_NEGATIVE_NUMBER_MSG);
        } else if (i == 0 || i == 1) {
            fibNumber = 1;
        } else {
            fibNumber = doFib(i - 1) + doFib(i - 2);
        }
        return fibNumber;
    }

}
