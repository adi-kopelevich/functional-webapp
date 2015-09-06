package sample.design.patterns.singleton;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class SingleObject {

    private static SingleObject _instance;

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        if (_instance == null) {
            _instance = new SingleObject();
        }
        return _instance;
    }

    public String getMessage() {
        return "Hello";
    }

}
