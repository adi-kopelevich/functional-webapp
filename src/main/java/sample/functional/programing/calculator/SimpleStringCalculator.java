package sample.functional.programing.calculator;

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

    public boolean isPrime(String number) {
        int num;
        try {
             num = Integer.valueOf(number);
        }catch(NumberFormatException e){
            throw new RuntimeException("Not a valid number: "+ number, e);
        }
        return num > 1 && IntStream.range(2, num).
                                    noneMatch(i -> num % i == 0);
    }

}
