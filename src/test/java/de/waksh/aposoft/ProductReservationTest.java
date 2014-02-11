package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.ProductReservation;
import de.waksh.aposoft.repository.ProductReservationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class ProductReservationTest {

    @Autowired
    private ProductReservationRepository repository;

    public ProductReservation createProductReservation() {

        ProductReservation productreservation = new ProductReservation();

        return productreservation;

    }

    @Test
    public void testFindAll() {
        ProductReservation productreservation = createProductReservation();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(productreservation);

        Iterable<ProductReservation> iterableproductreservation = repository.findAll();
        for (@SuppressWarnings("unused") ProductReservation productreservation2 : iterableproductreservation) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }
}
