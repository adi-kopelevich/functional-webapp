package sample.functional.programing.calculator;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by kopelevi on 27/08/2015.
 */
public class SimpleStringCalculator {

//    public boolean isPrime(String number) {
//        boolean isPrime = true;
//        int num;
//        try {
//             num = Integer.valueOf(number);
//        }catch(NumberFormatException e){
//            throw new RuntimeException("Not a valid number: "+ number, e);
//        }
//        for (int i = 2; i < num; i++) {
//            if (num % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }
//        return isPrime;
//    }


    public boolean isDivisible(int num, int divisor) {
        return num % divisor == 0;
    }

    public boolean isPrime(String number) {
        int num;
        try {
            num = Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Not a valid number: " + number, e);
        }
        Predicate<Integer> isGreateThan3 = i -> i > 3;
        Predicate<Integer> isDivisible = i -> num % i == 0;
        return num > 1 && IntStream.range(2, num).
                noneMatch(i -> isDivisible(num, i));
    }
    
    public int sumEven(List<Integer> numbers){
        return numbers.stream().filter(i -> i%2==0).reduce(0, Math::addExact);
    }

}
