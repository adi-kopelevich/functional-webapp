package sample.design.patterns.filter;

import java.util.List;

/**
 * Created by kopelevi on 31/08/2015.
 */
public interface PersonCriteria {
    public List<Person> meetCriteria(List<Person> persons);
}