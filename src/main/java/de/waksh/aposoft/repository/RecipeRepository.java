package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Recipe;

/**
 * JPA Repository for recipes
 * 
 * @author Jannik Kuptz
 * 
 */
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    /**
     * Returns a list of all recipes having the given description
     * 
     * @param description
     *            description of recipe
     * @return list of matching recipe
     */
    List<Recipe> findByDescription(String description);
}
