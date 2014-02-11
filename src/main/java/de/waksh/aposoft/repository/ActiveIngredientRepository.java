package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ActiveIngredient;

public interface ActiveIngredientRepository extends CrudRepository<ActiveIngredient, Integer> {

    List<ActiveIngredient> findByName(String name);
}
