package sample.design.patterns.decorator;

/**
 * Created by kopelevi on 03/09/2015.
 */
public abstract class ShapeDecorator {

    private Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public String getTypr() {
        return shape.getType();
    }

    public abstract String getColor();

}
