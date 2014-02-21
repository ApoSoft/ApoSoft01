package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.repository.RecipeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class RecipeTest {

    @Autowired
    private RecipeRepository repository;

    private Recipe createRecipe() {
        Recipe recipe = new Recipe();

        recipe.setDescription("Salbe");

        List<ActiveIngredient> items = new ArrayList<>();
        ActiveIngredient activeIngredient = new ActiveIngredient();
        activeIngredient.setName("test");
        ActiveIngredient activeIngredient2 = new ActiveIngredient();
        activeIngredient.setName("test2");
        items.add(activeIngredient2);
        items.add(activeIngredient);
        recipe.setActiveIngredient(items);

        return recipe;
    }

    @Test
    public void testInsert() {
        Recipe recipe = createRecipe();

        repository.save(recipe);

        List<Recipe> listext = repository.findByDescription(recipe.getDescription());
        boolean exists = false;
        for (Recipe ext2 : listext) {
            if (recipe.getId() == ext2.getId()) {
                exists = true;
                break;
            }
        }

        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        Recipe recipe = createRecipe();

        repository.save(recipe);

        recipe.setDescription("Creme");

        repository.save(recipe);

        List<Recipe> listextemproduct = repository.findByDescription(recipe.getDescription());
        for (Recipe rec : listextemproduct) {
            if (recipe.getId() == rec.getId()) {
                Assert.assertEquals(rec.getDescription(), "Creme");
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        Recipe recipe = createRecipe();

        repository.save(recipe);

        repository.delete(recipe);

        List<Recipe> listRecipe = repository.findByDescription(recipe.getDescription());
        boolean exists = false;
        for (Recipe ext : listRecipe) {
            if (recipe.getId() == ext.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testfindAll() {
        Recipe recipe = createRecipe();

        long size = repository.count();
        long length = 0;
        repository.save(recipe);
        Iterable<Recipe> it = repository.findAll();
        for (@SuppressWarnings("unused") Recipe recipe2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

}
