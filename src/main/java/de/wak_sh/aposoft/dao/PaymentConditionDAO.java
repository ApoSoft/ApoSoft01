package de.wak_sh.aposoft.dao;

import java.util.List;

import org.joda.time.DateTime;

import de.wak_sh.aposoft.domain.PaymentCondition;

public interface PaymentConditionDAO {

    boolean insertPaymentCondition(PaymentCondition paymentCondition);

    boolean updatePaymentCondition(PaymentCondition paymentCondition);

    boolean deletePaymentCondition(PaymentCondition paymentCondition);

    List<PaymentCondition> findAll();

    List<PaymentCondition> findByPaymentDate(DateTime paymentDate);

    List<PaymentCondition> findBydiscountDate(DateTime discountDate);
}
