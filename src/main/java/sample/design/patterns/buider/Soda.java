package sample.design.patterns.buider;

/**
 * Created by kopelevi on 31/08/2015.
 */
public abstract class Soda implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Soda && (((Soda) obj).name()).equals(name());
    }

    @Override
    public int hashCode() {
        return 1234567;
    }
}
