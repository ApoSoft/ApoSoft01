package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Employee;
import de.waksh.aposoft.domain.Qualification;
import de.waksh.aposoft.repository.QualificationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class QualificationTest {

    @Autowired
    private QualificationRepository repository;

    private Qualification createQualifikation() {
        Qualification qualification = new Qualification();

        Employee empl = new Employee();
        empl.setFirstName("first");
        empl.setGender("gender");
        Employee empl2 = new Employee();
        empl.setFirstName("second");
        empl.setGender("secondgender");
        List<Employee> employees = new ArrayList<>();
        qualification.setEmployees(employees);

        return qualification;
    }

    @Test
    public void testFindAll() {
        Qualification quali = createQualifikation();

        long lenth = repository.count();
        long size = 0;
        repository.save(quali);
        Iterable<Qualification> it = repository.findAll();
        for (@SuppressWarnings("unused") Qualification qualification : it) {
            size++;
        }
        Assert.assertEquals(lenth + 1, size);
    }
}
