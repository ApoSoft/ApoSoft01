package de.wak_sh.aposoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.wak_sh.aposoft.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    List<Product> findByName(@Param("name") String name);
}
