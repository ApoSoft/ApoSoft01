package de.wak_sh.aposoft;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.EmployeeDAO;
import de.wak_sh.aposoft.dao.impl.EmployeeDAOImpl;
import de.wak_sh.aposoft.domain.Employee;

public class TestEmployee {

    @Test
    public void testInsert() {
        EmployeeDAO dao = new EmployeeDAOImpl();

        Employee employee = createEmployee();

        dao.insertEmployee(employee);

        List<Employee> listemployee = dao.findByFirstNameAndName(employee.getFirstName(), employee.getName());
        boolean exists = false;
        for (Employee employee2 : listemployee) {
            if (employee.getId() == employee2.getId()) {
                exists = true;
                break;
            }
        }

        Assert.assertTrue(exists);
    }

    private Employee createEmployee() {
        Employee employee = new Employee();

        employee.setBirthdate(new LocalDate(2000, 1, 1));
        employee.setFirstName("Sebastian");
        employee.setGender("männlich");
        employee.setName("Brütt");
        employee.setPartTimePart(1.0f);
        employee.setTitle("Dr.");
        return employee;
    }

    @Test
    public void testUpdate() {
        Employee employee = createEmployee();

        EmployeeDAOImpl dao = new EmployeeDAOImpl();

        dao.insertEmployee(employee);
        employee.setTitle("Prof.");
        dao.updateEmployee(employee);

        List<Employee> listemployee = dao.findByFirstNameAndName(employee.getFirstName(), employee.getName());
        for (Employee employee2 : listemployee) {
            if (employee.getId() == employee2.getId()) {
                Assert.assertEquals(employee2.getTitle(), "Prof.");
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        Employee employee = createEmployee();
        EmployeeDAOImpl dao = new EmployeeDAOImpl();

        dao.insertEmployee(employee);

        dao.deleteEmployee(employee);

        List<Employee> listemployee = dao.findByFirstNameAndName(employee.getFirstName(), employee.getName());
        boolean exists = false;
        for (Employee employee2 : listemployee) {
            if (employee.getId() == employee2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        Employee employee = createEmployee();
        EmployeeDAOImpl dao = new EmployeeDAOImpl();

        int size = dao.findAll().size();

        dao.insertEmployee(employee);

        Assert.assertEquals(size + 1, dao.findAll().size());
    }
}
