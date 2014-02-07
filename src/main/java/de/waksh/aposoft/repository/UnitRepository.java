package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Unit;

public interface UnitRepository extends CrudRepository<Unit, Integer> {

    List<Unit> findByName(String name);
}
