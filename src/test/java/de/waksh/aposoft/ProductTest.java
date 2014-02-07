package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class ProductTest {

    @Autowired
    private ProductRepository repository;

    public Product createProduct() {
        Product product = new Product();

        product.setDosage(10000.99f);
        product.setHeight(320);
        product.setLength(200);
        product.setName("Salbe abc");
        product.setPrescription(true);
        product.setPrice(19.99f);
        product.setWidth(150);

        return product;
    }

    @Test
    public void testFindAll() {
        Product product = new Product();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(product);

        Iterable<Product> iterableproduct = repository.findAll();
        for (@SuppressWarnings("unused") Product product2 : iterableproduct) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }

    @Test
    public void testFindByName() {
        Product product = createProduct();

        repository.save(product);

        boolean result = false;

        Iterable<Product> iter = repository.findByName("%Sal%");
        for (Product product2 : iter) {
            if (product2.getName().equals(product.getName())) {
                result = true;
            }
        }

        Assert.assertTrue(result);
    }
}
