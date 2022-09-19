package Mockito.homework213.service;

import Mockito.homework213.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static Mockito.homework213.service.TestConstant.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void maxSalaryTest() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.maxSalaryInDept(DEPT));
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionInEmployeesListWhenFindMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalaryInDept(DEPT));
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionInEmptyDept() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalaryInDept(BAD_DEPT));
    }

    @Test
    public void minSalaryTest() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.minSalaryInDept(DEPT));
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionInEmployeesListWhenFindMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalaryInDept(DEPT));
    }

    @Test
    public void shouldReturnEmptyListWhenEmployeesDontExist() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(emptyList(), out.allEmployeesInDept(BAD_DEPT));
    }
}
