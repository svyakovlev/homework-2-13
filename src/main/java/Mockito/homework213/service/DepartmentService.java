package Mockito.homework213.service;

import Mockito.homework213.model.Employee;

import java.util.List;

public interface DepartmentService {
    Employee maxSalaryInDept(int department);

    Employee minSalaryInDept(int departmentId);

    List<String> allEmployeesInDept(int departmentId);

    List<String> allEmployeesSortByDept();
}
