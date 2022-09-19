package Mockito.homework213.service;

import Mockito.homework213.exception.EmployeeAlreadyAddedException;
import Mockito.homework213.exception.EmployeeNotFoundException;
import Mockito.homework213.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static Mockito.homework213.service.TestConstant.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    private EmployeeService out = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployeeWhenTheyDontExist() {
        Employee expected = new Employee(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        assertEquals(0, out.findAll().size());
        assertFalse(out.findAll().contains(expected));

        Employee actual = out.add(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        assertEquals(expected, actual);
        assertEquals(1, out.findAll().size());
        assertTrue(out.findAll().contains(expected));
    }

    @Test
    public void shouldReturnEmployeeAllreadyAddedException() {
        Employee existed = out.add(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        assertTrue(out.findAll().contains(existed));
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.add(FIRST_NAME, LAST_NAME, DEPT, SALARY));
    }

    @Test
    public void findTest() {
        Employee existed = out.add(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        assertEquals(existed, out.find(FIRST_NAME, LAST_NAME, DEPT, SALARY));
    }

    @Test
    public void shouldReturnEmployeeNotFoundException() {
        assertEquals(0, out.findAll().size());
        assertThrows(EmployeeNotFoundException.class, () -> out.find(FIRST_NAME, LAST_NAME, DEPT, SALARY));
    }

    @Test
    public void removeTest() {
        Employee expected = out.add(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        assertEquals(1, out.findAll().size());
        assertTrue(out.findAll().contains(expected));

        Employee actual = out.remove(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        assertEquals(expected, actual);
        assertTrue(out.findAll().isEmpty());
        assertFalse(out.findAll().contains(expected));
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionWhenRemove() {
        assertTrue(out.findAll().isEmpty());
        assertThrows(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME, LAST_NAME, DEPT, SALARY));
    }

    @Test
    public void findAllTest() {
        Employee employee = out.add(FIRST_NAME, LAST_NAME, DEPT, SALARY);
        Employee employee2 = out.add(FIRST_NAME2, LAST_NAME2, DEPT, SALARY);
        Collection<Employee> expected = List.of(employee, employee2);
        Collection<Employee> actual = out.findAll();
        assertIterableEquals(expected, actual);
    }

}
