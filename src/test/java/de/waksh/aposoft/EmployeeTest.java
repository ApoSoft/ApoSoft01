package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Employee;
import de.waksh.aposoft.domain.Qualification;
import de.waksh.aposoft.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class EmployeeTest {

    @Autowired
    private EmployeeRepository repository;

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

        Qualification qualification = new Qualification();
        Qualification quali = new Qualification();
        List<Qualification> list = new ArrayList<Qualification>();
        list.add(quali);
        list.add(qualification);
        employee.setQualifications(list);

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
        long length = 0;
        repository.save(employee);
        Iterable<Employee> it = repository.findAll();
        for (@SuppressWarnings("unused") Employee employee2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
