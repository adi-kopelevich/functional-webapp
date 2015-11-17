package sample.replace.string;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class EmployeeComparatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {

    }

    @Test
    public void whenGivenNullThenNullPointerExceptionIsThrown() {
        expectedException.expect(NullPointerException.class);
        new EmployeeComparator().compare(generateEmployee(), null);

        expectedException.expect(NullPointerException.class);
        new EmployeeComparator().compare(null, generateEmployee());

        expectedException.expect(NullPointerException.class);
        new EmployeeComparator().compare(null, null);
    }

    @Test
    public void whenFirstEmployeeWithBiggerNameThenReturnMinus1() {
        String firstEmployeeName = "A" + UUID.randomUUID().toString();
        String secondEmployeeName = "B" + UUID.randomUUID().toString();
        int compareResult = new EmployeeComparator().compare(generateEmployee(firstEmployeeName),
                generateEmployee(secondEmployeeName));
        Assert.assertEquals(-1, compareResult);
    }

    @Test
    public void whenFirstEmployeeWithBiggerNameThenReturn1() {
        String firstEmployeeName = "B" + UUID.randomUUID().toString();
        String secondEmployeeName = "A" + UUID.randomUUID().toString();
        int compareResult = new EmployeeComparator().compare(generateEmployee(firstEmployeeName),
                generateEmployee(secondEmployeeName));
        Assert.assertEquals(1, compareResult);
    }

    @Test
    public void whenEmployeeNamesAreEqualButFirstEmployeeIsOlderThenReturnMinus1() {
        String employeeName = UUID.randomUUID().toString();
        int firstEmployeeAge = getPositiveNumber();
        int secondEmployeeAge = firstEmployeeAge - 1;
        int compareResult = new EmployeeComparator().compare(generateEmployee(employeeName, firstEmployeeAge),
                generateEmployee(employeeName, secondEmployeeAge));
        Assert.assertEquals(1, compareResult);
    }

    @Test
    public void whenEmployeeNamesAreEqualButFirstEmployeeIsYoungerThenReturn1() {
        String employeeName = UUID.randomUUID().toString();
        int firstEmployeeAge = getPositiveNumber();
        int secondEmployeeAge = firstEmployeeAge + 1;
        int compareResult = new EmployeeComparator().compare(generateEmployee(employeeName, firstEmployeeAge),
                generateEmployee(employeeName, secondEmployeeAge));
        Assert.assertEquals(-1, compareResult);
    }

    @Test
    public void whenEmployeeNamesAndAgeAreEqualButFirstEmployeeDepartmentsAreSmallerThenReturnMinus1() {
        SortedSet<String> firstDepartmentSet = new TreeSet<>();
        firstDepartmentSet.add("A");
        firstDepartmentSet.add("B");
        firstDepartmentSet.add("C");

        SortedSet<String> secondDepartmentSet = new TreeSet<>();
        secondDepartmentSet.add("B");
        secondDepartmentSet.add("C");
        secondDepartmentSet.add("D");

        String employeeName = UUID.randomUUID().toString();
        int employeeAge = getPositiveNumber();
        int compareResult = new EmployeeComparator().compare(generateEmployee(employeeName, employeeAge, firstDepartmentSet),
                generateEmployee(employeeName, employeeAge, secondDepartmentSet));
        Assert.assertEquals(-1, compareResult);
    }


    @Test
    public void whenEmployeeNamesAndAgeAreEqualButFirstEmployeeDepartmentsAreSmallerThenReturn1() {
        SortedSet<String> firstDepartmentSet = new TreeSet<>();
        firstDepartmentSet.add("B");
        firstDepartmentSet.add("C");
        firstDepartmentSet.add("D");

        SortedSet<String> secondDepartmentSet = new TreeSet<>();
        secondDepartmentSet.add("A");
        secondDepartmentSet.add("B");
        secondDepartmentSet.add("C");


        String employeeName = UUID.randomUUID().toString();
        int employeeAge = getPositiveNumber();
        int compareResult = new EmployeeComparator().compare(generateEmployee(employeeName, employeeAge, firstDepartmentSet),
                generateEmployee(employeeName, employeeAge, secondDepartmentSet));
        Assert.assertEquals(1, compareResult);
    }

    @Test
    public void whenEmployeeNamesAgeAndDepartmentAreEqualButFirstEmployeeDepartmentsAreSmallerThenReturn0() {
        SortedSet<String> departmentSet = new TreeSet<>();
        departmentSet.add("A");
        departmentSet.add("B");
        departmentSet.add("C");

        String employeeName = UUID.randomUUID().toString();
        int employeeAge = getPositiveNumber();
        int compareResult = new EmployeeComparator().compare(generateEmployee(employeeName, employeeAge, departmentSet),
                generateEmployee(employeeName, employeeAge, departmentSet));
        Assert.assertEquals(0, compareResult);
    }

    public Employee generateEmployee() {
        return generateEmployee(UUID.randomUUID().toString());
    }

    public Employee generateEmployee(String name) {
        return generateEmployee(name, new Random().nextInt(10000));
    }

    public Employee generateEmployee(String name, int age) {
        SortedSet<String> departmentSet = new TreeSet<>();
        departmentSet.add(UUID.randomUUID().toString());
        departmentSet.add(UUID.randomUUID().toString());
        departmentSet.add(UUID.randomUUID().toString());
        return generateEmployee(name, age, departmentSet);
    }


    public Employee generateEmployee(String name, int age, SortedSet<String> departmentSet) {
        return new Employee(getPositiveNumber(),
                name,
                age,
                departmentSet);
    }

    private int getPositiveNumber() {
        return new Random().nextInt(10000);
    }
}
