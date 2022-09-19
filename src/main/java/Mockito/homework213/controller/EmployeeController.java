package Mockito.homework213.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Mockito.homework213.model.Employee;
import Mockito.homework213.service.EmployeeService;
import Mockito.homework213.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")

public class EmployeeController {

    private final EmployeeService service;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService service, DepartmentService departmentService) {
        this.service = service;
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return service.add(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return service.remove(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam double salary) {
        return service.find(firstName, lastName, department, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee maxSalaryInDept(@RequestParam int departmentId) {
        return departmentService.maxSalaryInDept(departmentId);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee minSalaryInDept(@RequestParam int departmentId) {
        return departmentService.minSalaryInDept(departmentId);
    }

    @GetMapping(value = "/departments/all", params = "departmentId")
    public Collection<String> allEmployeesInDept(@RequestParam (name = "departmentId") int departmentId) {
        return departmentService.allEmployeesInDept(departmentId);
    }

    @GetMapping(path = "/departments/all")
    public Collection<String> allEmployeesSortByDept() {
        return departmentService.allEmployeesSortByDept();
    }
}
