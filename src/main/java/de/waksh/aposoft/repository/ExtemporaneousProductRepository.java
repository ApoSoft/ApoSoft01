package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ExtemporaneousProduct;

/**
 * JPA Repository for extemporaneous products
 * 
 * @author Jannik Kuptz
 * 
 */
public interface ExtemporaneousProductRepository extends CrudRepository<ExtemporaneousProduct, Integer> {
    /**
     * Returns a list of all extemporaneous products having the given
     * description
     * 
     * @param description
     *            description of extemporaneous product
     * @return list of matching extemporaneous product
     */
    List<ExtemporaneousProduct> findByDescription(String description);
}
