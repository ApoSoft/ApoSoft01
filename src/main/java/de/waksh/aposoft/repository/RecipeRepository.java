package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Recipe;

/**
 * 
 * @author ahofmann
 * 
 */

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
