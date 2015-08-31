package sample.design.patterns.prototype;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}