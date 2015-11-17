package sample.replace.string;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class FizzBuzzString {

    public String getFizzBuzzString(int n) {
        StringBuilder fizzBuzzStringBuilder = new StringBuilder();
        if (n < 0) {
            throw new IllegalArgumentException(MessagesUtils.GIVEN_NEGATIVE_NUMBER_MSG);
        } else {
            for (int i = 1; i <= n; i++) {
                boolean multipleOfThree = i % 3 == 0;
                boolean multipleOfFive = i % 5 == 0;
                if (multipleOfThree && multipleOfFive) {
                    fizzBuzzStringBuilder.append("FizzBuzz");
                } else if (multipleOfThree) {
                    fizzBuzzStringBuilder.append("Fizz");
                } else if (multipleOfFive) {
                    fizzBuzzStringBuilder.append("Buzz");
                } else {
                    fizzBuzzStringBuilder.append(i);
                }
                fizzBuzzStringBuilder.append("-");
            }
        }
        return fizzBuzzStringBuilder.toString();
    }
}
