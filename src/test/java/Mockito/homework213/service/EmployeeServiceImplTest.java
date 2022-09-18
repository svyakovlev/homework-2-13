package Mockito.homework213.service;

import Mockito.homework213.exception.EmployeeAlreadyAddedException;
import Mockito.homework213.exception.EmployeeNotFoundException;
import Mockito.homework213.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImplTest {

    private String firstName = "Иван";
    private String lastName = "Иванов";
    private int department = 1;
    private double salary = 35_000;
    private Employee employee1 = new Employee(firstName, lastName, department, salary);
    private Employee employee2 = new Employee("Иван", "Петров", 1, 40_000);
    private Employee employee3 = new Employee("Иван", "Сидоров", 2, 20_000);


    private List<Employee> employeeList = new ArrayList<>();

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void addTest() {
        Employee actual = employeeService.add(firstName, lastName, department, salary);
        Assertions.assertEquals(employee1,actual);
    }

    @Test
    public void shouldReturnExceptionWhenEmployeeAlreadyAdded() {
        employeeList.add(employee1);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeList.add(employee1));
    }

    @Test
    public void removeTest() {
        employeeList.add(employee1);
        Employee actual = employeeService.remove(firstName, lastName, department, salary);
        Assertions.assertEquals(employee1,actual);
    }

    @Test
    public void shouldReturnExceptionWhenEmployeeNotFoundWhenRemove() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeList.remove(employee1));
    }

    @Test
    public void findTest() {
        employeeList.add(employee1);
        Employee actual = employeeService.find(firstName, lastName, department, salary);
        Assertions.assertEquals(employee1,actual);
    }

    @Test
    public void shouldReturnExceptionWhenEmployeeNotFound() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(firstName, lastName,department,salary));
    }

    @Test
    public void maxSalaryInDeptTest() {
        employeeService.add("Иван", "Иванов", 1, 35_000);
        employeeService.add("Иван", "Петров", 1, 40_000);
        employeeService.add("Иван", "Сидоров", 2, 20_000);

        Employee actual = employeeService.maxSalaryInDept(1);
        Assertions.assertEquals(employee2,actual);
    }

    @Test
    public void minSalaryInDeptTest() {
        employeeService.add("Иван", "Иванов", 1, 35_000);
        employeeService.add("Иван", "Петров", 1, 40_000);
        employeeService.add("Иван", "Сидоров", 2, 20_000);

        Employee actual = employeeService.minSalaryInDept(1);
        Assertions.assertEquals(employee1,actual);
    }
}
