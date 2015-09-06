package sample.reflection.parsing.json.pojo;

import sample.reflection.parsing.json.annotaions.JsonFieldAnnotation;
import sample.reflection.parsing.json.annotaions.JsonRootAnnotation;

/**
 * Created by kopelevi on 02/09/2015.
 */
@JsonRootAnnotation
public class Person {

    @JsonFieldAnnotation
    public int id;

    @JsonFieldAnnotation
    public String name;

    @JsonFieldAnnotation
    public Object[] addresses;

    public Person() {
    }

    public Person(int id, String name, Object[] addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public Object[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Object[] addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
