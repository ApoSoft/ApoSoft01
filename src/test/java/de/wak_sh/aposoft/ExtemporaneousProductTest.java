package de.wak_sh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.domain.ExtemporaneousProduct;
import de.wak_sh.aposoft.repository.ExtemporaneousProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class ExtemporaneousProductTest {

    @Autowired
    private ExtemporaneousProductRepository repository;

    private ExtemporaneousProduct createExtemporaneousProduct() {
        ExtemporaneousProduct extemporaneousProduct = new ExtemporaneousProduct();

        extemporaneousProduct.setDescription("Salbe");

        return extemporaneousProduct;
    }

    @Test
    public void testInsert() {
        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        repository.save(extemporaneousProduct);

        List<ExtemporaneousProduct> listext = repository.findByDescription(extemporaneousProduct.getDescription());
        boolean exists = false;
        for (ExtemporaneousProduct ext2 : listext) {
            if (extemporaneousProduct.getId() == ext2.getId()) {
                exists = true;
                break;
            }
        }

        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        repository.save(extemporaneousProduct);

        extemporaneousProduct.setDescription("Creme");

        repository.save(extemporaneousProduct);

        List<ExtemporaneousProduct> listextemproduct = repository.findByDescription(extemporaneousProduct
                .getDescription());
        for (ExtemporaneousProduct ext : listextemproduct) {
            if (extemporaneousProduct.getId() == ext.getId()) {
                Assert.assertEquals(ext.getDescription(), "Creme");
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        repository.save(extemporaneousProduct);

        repository.delete(extemporaneousProduct);

        List<ExtemporaneousProduct> listextemproduct = repository.findByDescription(extemporaneousProduct
                .getDescription());
        boolean exists = false;
        for (ExtemporaneousProduct ext : listextemproduct) {
            if (extemporaneousProduct.getId() == ext.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testfindAll() {
        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        long size = repository.count();
        long length = 0;
        repository.save(extemporaneousProduct);
        Iterable<ExtemporaneousProduct> it = repository.findAll();
        for (ExtemporaneousProduct extemporaneousProduct2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

}
