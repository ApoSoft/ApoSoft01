package de.wak_sh.aposoft;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.PaymentConditionDAO;
import de.wak_sh.aposoft.dao.impl.PaymentConditionDAOImpl;
import de.wak_sh.aposoft.domain.PaymentCondition;

public class TestPaymentCondition {

    public PaymentCondition createPaymentCondition() {
        PaymentCondition paymentCondition = new PaymentCondition();

        paymentCondition.setDiscountDate(new DateTime(2000, 1, 3, 1, 1));
        paymentCondition.setPaymentDate(new DateTime(2000, 1, 12, 1, 1));
        paymentCondition.setDiscountValue(10f);

        return paymentCondition;
    }

    @Test
    public void testInsert() {
        PaymentConditionDAO dao = new PaymentConditionDAOImpl();
        PaymentCondition paymentCondition = createPaymentCondition();

        dao.insertPaymentCondition(paymentCondition);

        List<PaymentCondition> listpaycon = dao.findBydiscountDate(paymentCondition.getDiscountDate());
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
        PaymentConditionDAO dao = new PaymentConditionDAOImpl();
        PaymentCondition paymentCondition = createPaymentCondition();

        dao.insertPaymentCondition(paymentCondition);

        List<PaymentCondition> listpaycon = dao.findByPaymentDate(paymentCondition.getPaymentDate());
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
        PaymentConditionDAO dao = new PaymentConditionDAOImpl();
        PaymentCondition paymentCondition = createPaymentCondition();

        dao.insertPaymentCondition(paymentCondition);
        paymentCondition.setDiscountValue(11f);
        dao.updatePaymentCondition(paymentCondition);

        List<PaymentCondition> listpaycon = dao.findByPaymentDate(paymentCondition.getPaymentDate());
        for (PaymentCondition paymentCondition2 : listpaycon) {
            if (paymentCondition.getId() == paymentCondition2.getId()) {
                Assert.assertEquals(paymentCondition.getDiscountValue(), paymentCondition2.getDiscountValue());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        PaymentConditionDAO dao = new PaymentConditionDAOImpl();
        PaymentCondition paymentCondition = createPaymentCondition();

        dao.insertPaymentCondition(paymentCondition);
        dao.deletePaymentCondition(paymentCondition);

        List<PaymentCondition> listpaycon = dao.findByPaymentDate(paymentCondition.getPaymentDate());
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
        PaymentConditionDAO dao = new PaymentConditionDAOImpl();
        PaymentCondition paymentCondition = createPaymentCondition();
        int size = dao.findAll().size();
        dao.insertPaymentCondition(paymentCondition);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }
}
