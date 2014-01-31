package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.ExtemporaneousProduct;

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
