package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Store;
import de.waksh.aposoft.repository.StoreRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class StoreTest {

    @Autowired
    private StoreRepository repository;

    private Store createStore() {
        Store store = new Store();
        store.setBranch("Medikamentenindustrie");
        store.setAmount(10);
        store.setDepot("A");
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
