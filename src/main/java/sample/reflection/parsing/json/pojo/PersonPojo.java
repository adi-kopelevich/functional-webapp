package sample.reflection.parsing.json.pojo;

/**
 * Created by kopelevi on 02/09/2015.
 */
public class PersonPojo {
    public String id;
    public String name;
    public String addresses;

    public PersonPojo() {
    }

    public PersonPojo(String id, String name, String addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
