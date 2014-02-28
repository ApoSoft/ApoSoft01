package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class ProductTest {

    @Autowired
    private ProductRepository repository;

    public Product createProduct() {
        Product product = new Product();

        product.setDosage(10000.99f);
        product.setName("Salbe abc");
        product.setPrescription(true);
        product.setPrice(19.99f);

        // Vendor vendor = new Vendor();
        // vendor.setName("abc");
        // vendor.setVendorCode("123");
        // vendor.setWebsite("www.website.de");
        // product.setVendor(vendor);

        Recipe recipe = new Recipe();
        product.setRecipe(recipe);

        // ProductShape productshape = new ProductShape();
        // productshape.setName("Name");
        // product.setProductShape(productshape);

        // ProductType producttype = new ProductType();
        // producttype.setName("abc");
        // product.setProductType(producttype);

        // ProductGroup productgroup = new ProductGroup();
        // productgroup.setName("abc");
        // productgroup.setDescription("description");
        // product.setProductGroup(productgroup);

        // Unit unit = new Unit();
        // unit.setName("abc");
        // product.setUnit(unit);
        //
        // Store store = new Store();
        // // store.setBranch("abc");
        // store.setAmount(543);
        // store.setDepot("cba");
        // product.setStore(store);

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
