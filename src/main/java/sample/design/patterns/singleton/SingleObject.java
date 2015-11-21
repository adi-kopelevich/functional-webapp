package sample.design.patterns.singleton;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class SingleObject {

    private static final SingleObject _INSTANCE = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return _INSTANCE;
    }

    public String getMessage() {
        return "Hello";
    }

}
