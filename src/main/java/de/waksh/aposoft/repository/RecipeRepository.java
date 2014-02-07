package de.wak_sh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Recipe;

/**
 * 
 * @author ahofmann
 * 
 */

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
