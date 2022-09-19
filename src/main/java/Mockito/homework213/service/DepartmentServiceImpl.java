package Mockito.homework213.service;

import Mockito.homework213.exception.EmployeeNotFoundException;
import Mockito.homework213.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryInDept(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minSalaryInDept(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<String> allEmployeesInDept(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> allEmployeesSortByDept() {
        return employeeService.findAll().stream()
                .sorted(comparingInt(Employee::getDepartment))
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .collect(Collectors.toList());
    }
}
