package sample.design.patterns.decorator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class ShapeDecoratotTest {
    @Test
    public void whenGivenRedShapeDecoratorThenShapeTypeIsTheSameAndColorisRed() throws Exception {
        ShapeDecorator shapeDecor = new RedShapeDecorator(new Circle());
        Assert.assertEquals(shapeDecor.getTypr(), "Circle");
        Assert.assertEquals(shapeDecor.getColor(), "RED");

    }
}
