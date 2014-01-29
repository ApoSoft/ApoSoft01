package de.wak_sh.aposoft;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.dao.EmployeeRepository;
import de.wak_sh.aposoft.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApoSoft.class)
public class EmployeeTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    public void testInsert() {
        Employee employee = createEmployee();

        repository.save(employee);

        List<Employee> listemployee = repository.findByFirstNameAndName(employee.getFirstName(), employee.getName());
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

        repository.save(employee);
        employee.setTitle("Prof.");
        repository.save(employee);

        List<Employee> listemployee = repository.findByFirstNameAndName(employee.getFirstName(), employee.getName());
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

        repository.save(employee);

        repository.delete(employee);

        List<Employee> listemployee = repository.findByFirstNameAndName(employee.getFirstName(), employee.getName());
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

        long size = repository.count();

        repository.save(employee);

        Assert.assertEquals(size + 1, repository.count());
    }
}