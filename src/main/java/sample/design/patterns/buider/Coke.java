package sample.design.patterns.buider;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class Coke extends Soda {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 5.0f;
    }

}
