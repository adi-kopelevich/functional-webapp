package sample.design.patterns.prototype;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
