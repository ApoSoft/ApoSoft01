package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.ProductType;
import de.waksh.aposoft.repository.ProductTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class ProductTypeTest {

    @Autowired
    private ProductTypeRepository repository;

    private ProductType createProductType() {
        ProductType proType = new ProductType();
        proType.setName("TypeTest");
        return proType;
    }

    @Test
    public void testFindAll() {
        ProductType proType = createProductType();
        long length = 0;
        long size = repository.count();
        repository.save(proType);
        Iterable<ProductType> it = repository.findAll();
        for (@SuppressWarnings("unused") ProductType productType : it) {
            length++;
        }
        Assert.assertEquals(length, size + 1);
    }

}
