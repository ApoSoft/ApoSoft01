package de.wak_sh.aposoft.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.PaymentCondition;

public interface PaymentConditionRepository extends CrudRepository<PaymentCondition, Integer> {

    List<PaymentCondition> findByPaymentDate(DateTime paymentDate);

    List<PaymentCondition> findBydiscountDate(DateTime discountDate);
}
