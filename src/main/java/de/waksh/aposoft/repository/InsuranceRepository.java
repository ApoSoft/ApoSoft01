/**
 * 
 */
package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Insurance;

/**
 * JPA epository for Insurance objecrts
 * 
 * @author Lennart Huebsch
 * 
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {

    /**
     * Find insurance by name
     * 
     * @param name
     *            name to search for
     * @return matching insurance
     */
    Insurance findByName(String name);

    /**
     * Find insurance by id number
     * 
     * @param insuranceIdNumber
     *            id number to search for
     * @return matching insurance
     */
    Insurance findByInsuranceIdNumber(String insuranceIdNumber);

}
