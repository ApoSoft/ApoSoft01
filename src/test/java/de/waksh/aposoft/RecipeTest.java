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

import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.domain.SubstanceItem;
import de.waksh.aposoft.repository.RecipeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class RecipeTest {

    @Autowired
    private RecipeRepository repository;

    private Recipe createRecipe() {
        Recipe recipe = new Recipe();

        List<SubstanceItem> items = new ArrayList<>();
        SubstanceItem item = new SubstanceItem();
        item.setAmount(20);
        SubstanceItem item2 = new SubstanceItem();
        item.setAmount(1);
        items.add(item2);
        items.add(item);
        recipe.setItems(items);

        return recipe;
    }

    @Test
    public void testFindAll() {
        Recipe recipe = createRecipe();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(recipe);

        Iterable<Recipe> iterablerecipe = repository.findAll();
        for (@SuppressWarnings("unused") Recipe recipe2 : iterablerecipe) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }
}
