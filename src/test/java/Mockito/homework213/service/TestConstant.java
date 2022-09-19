package Mockito.homework213.service;

import Mockito.homework213.model.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Set;

public class TestConstant {
    public static final String FIRST_NAME = "Name1";
    public static final String FIRST_NAME2 = "Name2";
    public static final String LAST_NAME = "Surname1";
    public static final String LAST_NAME2 = "Surname2";
    public static final int DEPT = 1;
    public static final int BAD_DEPT = 2;
    public static final double SALARY = 30000;
    public static final double MIN_SALARY = 20000;
    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, DEPT, SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, DEPT, MIN_SALARY);
    public static final List<Employee> EMPLOYEES = List.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE);

}
