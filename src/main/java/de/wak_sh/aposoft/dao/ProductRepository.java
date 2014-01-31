package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);
}
