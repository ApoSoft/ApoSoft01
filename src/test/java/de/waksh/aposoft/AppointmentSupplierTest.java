package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.AppointmentSupplier;
import de.waksh.aposoft.repository.AppointmentSupplierRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class AppointmentSupplierTest {

    @Autowired
    private AppointmentSupplierRepository repository;

    private AppointmentSupplier createAppointmentSupplier() {
        AppointmentSupplier appointmentSupplier = new AppointmentSupplier();
        return appointmentSupplier;
    }

    @Test
    public void testFindAll() {
        AppointmentSupplier aposupp = createAppointmentSupplier();
        long length = repository.count();
        long size = 0;
        repository.save(aposupp);
        Iterable<AppointmentSupplier> it = repository.findAll();
        for (AppointmentSupplier appointmentSupplier : it) {
            size++;
        }
        Assert.assertEquals(length + 1, size);
    }

}
