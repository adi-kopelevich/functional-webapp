package sample.functional.programing.calculator;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by kopelevi on 27/08/2015.
 */
public class SimpleStringCalculator {

    public boolean isDivisible(int num, int divisor) {
        return num % divisor == 0;
    }

    public int sumEven(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 == 0).reduce(0, Math::addExact);
    }

    public boolean isPrime(String number) {
        int num;
        try {
            num = Integer.valueOf(number);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Not a valid number...");
        }
        return num > 1 && IntStream.range(2, num).noneMatch(i -> num % i == 0);
    }

}
