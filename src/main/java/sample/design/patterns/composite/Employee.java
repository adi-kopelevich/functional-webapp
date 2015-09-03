package sample.design.patterns.composite;

import java.util.List;

/**
 * Created by kopelevi on 03/09/2015.
 */

//composite
public class Employee {

    private int salary;
    private int id;
    private String name;
    private String jobTitle;
    private List<Employee> subordinates;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee() {

    }

    public void addEmployee(Employee employee) {
        this.subordinates.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.subordinates.remove(employee);
    }


}
