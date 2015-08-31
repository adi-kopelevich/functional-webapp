package sample.design.patterns.filter;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class PersonCriteriaTest {


    List<Person> persons = new ArrayList<Person>();


    @Before
    public final void init() {
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));
    }

    @After
    public final void tearDown() {
        persons.clear();
    }

    @Test
    public final void whenGivenListOfPersonThenReturnListOfMales() {
        PersonCriteria crt = new PersonCriteriaMale();
        Assert.assertEquals(crt.meetCriteria(persons).size(), 4);
    }
}
