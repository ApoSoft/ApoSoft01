package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ActiveIngredient;

/**
 * JPA repository for ActiveIngredient objects
 * 
 * @author Christoph Mende
 * 
 */
public interface ActiveIngredientRepository extends CrudRepository<ActiveIngredient, Integer> {

    /**
     * Find active ingredients by name
     * 
     * @param name
     *            name of the ingredient
     * @return a list of matching ingredients
     */
    List<ActiveIngredient> findByName(String name);
}
