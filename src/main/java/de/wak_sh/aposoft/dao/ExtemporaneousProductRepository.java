package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.ExtemporaneousProduct;

public interface ExtemporaneousProductRepository extends CrudRepository<ExtemporaneousProduct, Integer> {
    List<ExtemporaneousProduct> findByDescription(String description);
}
