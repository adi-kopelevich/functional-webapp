package sample.design.patterns.prototype;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
