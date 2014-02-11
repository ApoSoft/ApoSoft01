package de.wak_sh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.dao.InsuranceRepository;
import de.wak_sh.aposoft.domain.Insurance;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class InsuranceTest {

    @Autowired
    private InsuranceRepository repository;

    public Insurance createInsurance() {
        Insurance insurance = new Insurance();

        insurance.setInsuranceIdNumber("TEST");
        insurance.setName("Versicherung");
        insurance.setPrivateInsurance(true);
        insurance.setPhone("+49431");

        return insurance;
    }

    @Test
    public void testFindAll() {
        Insurance insurance = new Insurance();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(insurance);

        Iterable<Insurance> iterableinsurance = repository.findAll();
        for (Insurance insurance2 : iterableinsurance) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }
}
