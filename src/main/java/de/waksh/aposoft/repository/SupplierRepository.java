package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {

    List<Supplier> findByName(String name);

}
