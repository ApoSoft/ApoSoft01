package de.wak_sh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.dao.RecipeRepository;
import de.wak_sh.aposoft.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class RecipeTest {

    @Autowired
    private RecipeRepository repository;

    public Recipe createRecipe() {
        Recipe recipe = new Recipe();

        return recipe;
    }

    @Test
    public void testFindAll() {
        Recipe recipe = new Recipe();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(recipe);

        Iterable<Recipe> iterablerecipe = repository.findAll();
        for (Recipe recipe2 : iterablerecipe) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }

}
