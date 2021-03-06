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

import de.waksh.aposoft.domain.Occupation;
import de.waksh.aposoft.domain.Qualification;
import de.waksh.aposoft.repository.OccupationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class OccupationTest {

    @Autowired
    private OccupationRepository repository;

    private Occupation createOccupation() {
        Occupation occupation = new Occupation();

        Qualification qualification = new Qualification();
        Qualification quali = new Qualification();
        List<Qualification> list = new ArrayList<Qualification>();
        list.add(quali);
        list.add(qualification);
        occupation.setQualifications(list);

        occupation.setStart((new LocalDate(2000, 1, 1)));
        occupation.setEnd((new LocalDate(2000, 1, 1)));

        return occupation;
    }

    @Test
    public void testFindAll() {
        Occupation occupation = createOccupation();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(occupation);

        Iterable<Occupation> it = repository.findAll();
        for (@SuppressWarnings("unused") Occupation occupation2 : it) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }

}
