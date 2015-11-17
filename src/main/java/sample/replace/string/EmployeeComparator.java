package sample.replace.string;

import java.util.Comparator;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1 == null || o2 == null) {
            throw new NullPointerException();
        }
        return o1.compareTo(o2);
    }
}
