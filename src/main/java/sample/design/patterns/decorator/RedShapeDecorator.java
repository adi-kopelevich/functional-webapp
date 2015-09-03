package sample.design.patterns.decorator;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class RedShapeDecorator extends ShapeDecorator {


    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
