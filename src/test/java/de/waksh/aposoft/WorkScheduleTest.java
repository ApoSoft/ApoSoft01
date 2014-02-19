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

import de.waksh.aposoft.domain.Qualification;
import de.waksh.aposoft.domain.WorkSchedule;
import de.waksh.aposoft.repository.WorkScheduleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class WorkScheduleTest {

    @Autowired
    private WorkScheduleRepository repository;

    private WorkSchedule createWorkSchedule() {
        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setAccountBalance(1.1f);
        workSchedule.setDays(5f);

        Qualification qualification = new Qualification();
        Qualification quali = new Qualification();
        List<Qualification> list = new ArrayList<Qualification>();
        list.add(quali);
        list.add(qualification);
        workSchedule.setQualifications(list);

        return workSchedule;
    }

    @Test
    public void testFindAll() {
        WorkSchedule workSchedule = createWorkSchedule();
        long length = repository.count();
        long size = 0;
        repository.save(workSchedule);
        Iterable<WorkSchedule> it = repository.findAll();
        for (@SuppressWarnings("unused") WorkSchedule workSchedule2 : it) {
            size++;
        }
        Assert.assertEquals(length + 1, size);
    }
}
