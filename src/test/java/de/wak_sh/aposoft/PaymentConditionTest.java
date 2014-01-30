package de.wak_sh.aposoft;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.dao.PaymentConditionRepository;
import de.wak_sh.aposoft.domain.PaymentCondition;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
public class PaymentConditionTest {

    @Autowired
    private PaymentConditionRepository repository;

    public PaymentCondition createPaymentCondition() {
        PaymentCondition paymentCondition = new PaymentCondition();

        paymentCondition.setDiscountDate(new DateTime(2000, 1, 3, 1, 1));
        paymentCondition.setPaymentDate(new DateTime(2000, 1, 12, 1, 1));
        paymentCondition.setDiscountValue(10f);

        return paymentCondition;
    }

    @Test
    public void testInsert() {
        PaymentCondition paymentCondition = createPaymentCondition();

        repository.save(paymentCondition);

        List<PaymentCondition> listpaycon = repository.findBydiscountDate(paymentCondition.getDiscountDate());
        boolean exists = false;
        for (PaymentCondition paymentCondition2 : listpaycon) {
            if (paymentCondition.getId() == paymentCondition2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testInsertWithFindByPaymentDate() {
        PaymentCondition paymentCondition = createPaymentCondition();

        repository.save(paymentCondition);

        List<PaymentCondition> listpaycon = repository.findByPaymentDate(paymentCondition.getPaymentDate());
        boolean exists = false;
        for (PaymentCondition paymentCondition2 : listpaycon) {
            if (paymentCondition.getId() == paymentCondition2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        PaymentCondition paymentCondition = createPaymentCondition();

        repository.save(paymentCondition);
        paymentCondition.setDiscountValue(11f);
        repository.save(paymentCondition);

        List<PaymentCondition> listpaycon = repository.findByPaymentDate(paymentCondition.getPaymentDate());
        for (PaymentCondition paymentCondition2 : listpaycon) {
            if (paymentCondition.getId() == paymentCondition2.getId()) {
                Assert.assertEquals(paymentCondition.getDiscountValue(), paymentCondition2.getDiscountValue(), 0.01);
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        PaymentCondition paymentCondition = createPaymentCondition();

        repository.save(paymentCondition);
        repository.delete(paymentCondition);

        List<PaymentCondition> listpaycon = repository.findByPaymentDate(paymentCondition.getPaymentDate());
        boolean exists = false;
        for (PaymentCondition paymentCondition2 : listpaycon) {
            if (paymentCondition.getId() == paymentCondition2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testfindAll() {
        PaymentCondition paymentCondition = createPaymentCondition();
        long size = repository.count();
        repository.save(paymentCondition);
        Assert.assertEquals(size + 1, repository.count());
    }
}
