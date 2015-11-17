package sample.replace.string;

import java.util.SortedSet;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int age;
    private SortedSet<String> departments;

    public Employee(int id, String name, int age, SortedSet<String> departments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.departments = departments;
    }

    @Override
    public int compareTo(Employee o) {
        if (o == null) {
            throw new NullPointerException();
        }

        int nameCompareValue = name.compareTo(o.name);
        if (nameCompareValue < 0) {
            return -1;
        } else if (nameCompareValue > 0) {
            return 1;
        } else {
            if (age < o.age) {
                return -1;
            } else if (age > o.age) {
                return 1;
            } else {
                if (!departments.equals(o.departments)) {
                    int departmentsCompareValue = departments.first().compareTo(o.departments.first());
                    if (departmentsCompareValue < 0) {
                        return -1;
                    } else if (departmentsCompareValue > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }
    }
}
