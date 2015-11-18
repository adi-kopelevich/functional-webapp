package sample.code.kata;

import java.util.*;

/**
 * Created by kopelevi on 18/11/2015.
 */
public class SortingBalls {

    private static final int NUMBER_OF_BALLS = 60;
    private final int NUMBER_OF_RESULTS = new Random().nextInt(15);

    public Set<Integer> doLottery() {
        System.out.println("Today's Lottery is drawing "+NUMBER_OF_RESULTS+" balls..");
        Set<Integer> resultSet = new TreeSet<>();
        List<Integer> numbersArray = new ArrayList<>(NUMBER_OF_BALLS);
        for (int i = 0; i < NUMBER_OF_BALLS; ++i) {
            numbersArray.add(i);
        }
        for (int j = 0; j < NUMBER_OF_RESULTS; j++) {
            int ballIndx = new Random().nextInt(numbersArray.size());
            Integer ballNum = numbersArray.remove(ballIndx);
            resultSet.add(ballNum);
            System.out.println("Ball "+j+": " + ballNum);
        }
        System.out.println("Result Set: " + resultSet);
        return resultSet;
    }

    public static void main(String[] args) {
        new SortingBalls().doLottery();
    }
}
