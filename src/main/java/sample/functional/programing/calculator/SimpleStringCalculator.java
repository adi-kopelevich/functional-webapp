package sample.functional.programing.calculator;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by kopelevi on 27/08/2015.
 */
// Followed "Functional Programming with Java 8" (https://www.youtube.com/watch?v=Ee5t_EGjv0A)
//
// expressive (What) instead of implicate (How)
// more clear and human readable
// lazy eval
// parallel invocation
// pure functions
// more testable
// immutable instead of mutable

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

    private static boolean isGreaterThan3(int num) {
        return num > 3;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static int doubleNum(int num) {
        return num * 2;
    }

    public int getDoubleOfFirstNumberGreaterThan3(List<Integer> numbers) {
        Predicate<Integer> isGreaterThan3 = i -> i > 3;

        Function<Integer, Predicate<Integer>> isGreaterThan = x -> i -> i > x;

        return numbers.stream().
                filter(isGreaterThan.apply(3)).
                filter(SimpleStringCalculator::isEven).
                map(SimpleStringCalculator::doubleNum).
                findFirst().
                get();
    }

    public int getTotalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream().filter(selector).reduce(0, Math::addExact);
    }

    public int getTotalValues(List<Integer> numbers) {
        return getTotalValues(numbers, n -> true);
    }

    public int getTotalEvenNumbers(List<Integer> numbers) {
        return getTotalValues(numbers, n -> n % 2 == 0);
    }

    // parallel stream
    public int getSumOfDoubles(List<Integer> numbers) {
        return numbers.parallelStream().mapToInt(SimpleStringCalculator::doubleNum).sum();
    }

    interface Selector {
        public boolean pick(int i);
    }

    class EvenNumberSlector implements Selector {
        @Override
        public boolean pick(int i) {
            return i % 2 == 0;
        }
    }
}
