package sample.design.patterns.buider;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class Pepsi extends Soda {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 4.0f;
    }
}
