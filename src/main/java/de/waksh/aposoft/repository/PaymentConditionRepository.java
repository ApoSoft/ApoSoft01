package de.waksh.aposoft.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.PaymentCondition;

/**
 * JPA repository for PaymentCondition objects
 * 
 * @author Christoph Mende
 * 
 */
public interface PaymentConditionRepository extends CrudRepository<PaymentCondition, Integer> {

    /**
     * Find payment conditions by date
     * 
     * @param paymentDate
     *            date to search for
     * @return list of matching payment conditions
     */
    List<PaymentCondition> findByPaymentDate(DateTime paymentDate);

    /**
     * FInd payment conditions by discount date
     * 
     * @param discountDate
     *            discount date to search for
     * @return list of matching payment conditions
     */
    List<PaymentCondition> findByDiscountDate(DateTime discountDate);
}
