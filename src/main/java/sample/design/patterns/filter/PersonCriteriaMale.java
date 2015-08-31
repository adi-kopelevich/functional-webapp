package sample.design.patterns.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kopelevi on 31/08/2015.
 */
public class PersonCriteriaMale implements PersonCriteria {

    public static boolean isMale(Person p){
        return  p.getGender().equals("Male");
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return persons.stream().filter(PersonCriteriaMale::isMale).
                collect(Collectors.toList());
    }
}
