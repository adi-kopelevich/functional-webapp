package sample.design.patterns.buider;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class VeggieBurger extends Burger {
    @Override
    public String name() {
        return "VeggieBurger";
    }

    @Override
    public float price() {
        return 10.0f;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof VeggieBurger;
    }

    @Override
    public int hashCode() {
        return 1234567;
    }
}
