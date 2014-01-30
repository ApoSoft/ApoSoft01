package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {

    List<Supplier> findByName(String name);

}
