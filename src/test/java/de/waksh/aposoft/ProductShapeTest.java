package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.ProductShape;
import de.waksh.aposoft.repository.ProductShapeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class ProductShapeTest {

    @Autowired
    private ProductShapeRepository repository;

    private ProductShape createProductShape() {
        ProductShape proshape = new ProductShape();

        proshape.setName("test");

        return proshape;
    }

    @Test
    public void testFindAll() {
        ProductShape proshape = new ProductShape();
        long length = 0;
        long size = repository.count();
        repository.save(proshape);
        Iterable<ProductShape> it = repository.findAll();
        for (@SuppressWarnings("unused") ProductShape productShape : it) {
            length++;
        }
        Assert.assertEquals(length, size + 1);
    }

}
