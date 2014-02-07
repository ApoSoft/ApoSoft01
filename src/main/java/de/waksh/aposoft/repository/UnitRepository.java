package de.wak_sh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Unit;

public interface UnitRepository extends CrudRepository<Unit, Integer> {

    List<Unit> findByName(String name);
}
