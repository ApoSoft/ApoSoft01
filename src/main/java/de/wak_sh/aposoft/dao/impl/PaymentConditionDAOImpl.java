package de.wak_sh.aposoft.dao.impl;

import java.util.List;

import org.joda.time.DateTime;

import de.wak_sh.aposoft.dao.PaymentConditionDAO;
import de.wak_sh.aposoft.domain.PaymentCondition;

public class PaymentConditionDAOImpl implements PaymentConditionDAO {

    @Override
    public boolean insertPaymentCondition(PaymentCondition paymentCondition) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updatePaymentCondition(PaymentCondition paymentCondition) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deletePaymentCondition(PaymentCondition paymentCondition) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<PaymentCondition> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaymentCondition> findByPaymentDate(DateTime paymentDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaymentCondition> findBydiscountDate(DateTime discountDate) {
        // TODO Auto-generated method stub
        return null;
    }

}
