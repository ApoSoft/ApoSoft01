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

import de.waksh.aposoft.domain.MaterialsAdministration;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.Store;
import de.waksh.aposoft.repository.StoreRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class StoreTest {

    @Autowired
    private StoreRepository repository;

    private Store createStore() {
        Store store = new Store();
        store.setBranch("Medikamentenindustrie");
        store.setAmount(10);
        store.setDepot("A");

        MaterialsAdministration materialsAdministration = new MaterialsAdministration();
        materialsAdministration.setAmount(10);
        store.setMaterialsAdministration(materialsAdministration);

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setName("test");
        Product product2 = new Product();
        product2.setName("test2");
        products.add(product2);
        products.add(product);
        store.setProducts(products);

        return store;
    }

    @Test
    public void testFindAll() {
        Store store = createStore();
        long length = repository.count();
        long size = 0;
        repository.save(store);
        Iterable<Store> it = repository.findAll();
        for (@SuppressWarnings("unused") Store store2 : it) {
            size++;
        }
        Assert.assertEquals(length + 1, size);
    }

}
