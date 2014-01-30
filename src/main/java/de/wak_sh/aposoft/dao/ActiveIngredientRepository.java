package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.ActiveIngredient;

public interface ActiveIngredientRepository extends CrudRepository<ActiveIngredient, Integer> {

    List<ActiveIngredient> findByName(String name);
}
