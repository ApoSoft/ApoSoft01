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

import de.waksh.aposoft.domain.AppointmentSupplier;
import de.waksh.aposoft.domain.OrderItem;
import de.waksh.aposoft.repository.AppointmentSupplierRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class AppointmentSupplierTest {

    @Autowired
    private AppointmentSupplierRepository repository;

    private AppointmentSupplier createAppointmentSupplier() {
        AppointmentSupplier appointmentSupplier = new AppointmentSupplier();
        appointmentSupplier.setDate(new LocalDate(2002, 2, 2));

        List<OrderItem> items = new ArrayList<>();
        OrderItem item = new OrderItem();
        item.setAmount(20);
        OrderItem item2 = new OrderItem();
        item.setAmount(1);
        items.add(item2);
        items.add(item);
        appointmentSupplier.setItems(items);

        return appointmentSupplier;
    }

    @Test
    public void testFindAll() {
        AppointmentSupplier aposupp = createAppointmentSupplier();
        long length = repository.count();
        long size = 0;
        repository.save(aposupp);
        Iterable<AppointmentSupplier> it = repository.findAll();
        for (@SuppressWarnings("unused") AppointmentSupplier appointmentSupplier : it) {
            size++;
        }
        Assert.assertEquals(length + 1, size);
    }

}
