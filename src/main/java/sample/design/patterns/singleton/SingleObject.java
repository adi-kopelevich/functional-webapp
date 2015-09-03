package sample.design.patterns.singleton;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class SingleObject {

    private static SingleObject _instance = new SingleObject();

    private SingleObject(){

    }

    public static SingleObject getInstance(){
        return _instance;
    }

    public String getMessage(){
        return "Hello";
    }

}
