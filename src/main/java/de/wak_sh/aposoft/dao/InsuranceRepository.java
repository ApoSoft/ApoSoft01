/**
 * 
 */
package de.wak_sh.aposoft.dao;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Customer;
import de.wak_sh.aposoft.domain.Insurance;

/**
 * Repository for Insurance
 * 
 * @author lhuebsch
 * 
 */
public interface InsuranceRepository extends CrudRepository<Customer, Integer> {

    Insurance findByName(String name);

    Insurance findByInsuranceIdNumber(String insuranceIdNumber);

}
