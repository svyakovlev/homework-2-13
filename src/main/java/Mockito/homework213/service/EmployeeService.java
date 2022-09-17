package Mockito.homework213.service;

import Mockito.homework213.model.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, double salary);

    Employee remove(String firstName, String lastName, int department, double salary);

    Employee find(String firstName, String lastName, int department, double salary);

    Collection<Employee> findAll();

    Employee maxSalaryInDept(int department);

    Employee minSalaryInDept(int departmentId);

    List<String> allEmployeesInDept(int departmentId);

    List<String> allEmployeesSortByDept();
}
