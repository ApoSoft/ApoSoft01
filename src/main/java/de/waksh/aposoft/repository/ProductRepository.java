package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.waksh.aposoft.domain.Product;

/**
 * JPA repository for Product objects
 * 
 * @author Christoph Mende
 * 
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    /**
     * Search for a product by name, supporting wildcards
     * 
     * @param name
     *            Product name to search for, optionally wildcarded with %
     * @return List of matching product
     */
    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    List<Product> findByName(@Param("name") String name);
}
