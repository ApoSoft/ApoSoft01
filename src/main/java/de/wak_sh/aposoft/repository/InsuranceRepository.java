/**
 * 
 */
package de.wak_sh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Insurance;

/**
 * Repository for Insurance
 * 
 * @author lhuebsch
 * 
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {

    Insurance findByName(String name);

    Insurance findByInsuranceIdNumber(String insuranceIdNumber);

}
