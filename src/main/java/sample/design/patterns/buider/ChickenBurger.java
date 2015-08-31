package sample.design.patterns.buider;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 15.0f;
    }


}
