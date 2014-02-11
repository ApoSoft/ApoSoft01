package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Insurance;
import de.waksh.aposoft.repository.InsuranceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class InsuranceTest {

    @Autowired
    private InsuranceRepository repository;

    public Insurance createInsurance() {
        Insurance insurance = new Insurance();

        insurance.setInsuranceIdNumber("1234");
        insurance.setName("Kasse");
        insurance.setPhone("+49 111 1111");
        insurance.setPrivateInsurance(false);

        return insurance;
    }

    @Test
    public void testFindByName() {
        Insurance insurance = createInsurance();

        repository.save(insurance);
        boolean exists = false;
        Insurance it = repository.findByName(insurance.getName());
        if (insurance.getId() == it.getId()) {
            exists = true;
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testFindByInsuranceIdNumber() {
        Insurance insurance = createInsurance();

        repository.save(insurance);
        boolean exists = false;
        Insurance insur = repository.findByInsuranceIdNumber(insurance.getInsuranceIdNumber());
        if (insurance.getId() == insur.getId()) {
            exists = true;
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testFindAll() {
        Insurance insurance = createInsurance();

        long size = repository.count();
        long length = 0;

        repository.save(insurance);

        Iterable<Insurance> it = repository.findAll();
        for (@SuppressWarnings("unused") Insurance insurance2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
