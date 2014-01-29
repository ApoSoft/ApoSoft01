package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.SupplierDAO;
import de.wak_sh.aposoft.dao.impl.SupplierDAOImpl;
import de.wak_sh.aposoft.domain.Supplier;

public class TestSupplier {

    public Supplier createSupplier() {
        Supplier suppllier = new Supplier();

        suppllier.setContactPerson("Karl Of");
        suppllier.setName("Bayer");
        suppllier.setRating("A");
        suppllier.setShortdescription("Großer Pharmakonzern");
        suppllier.setWebsite("www.bayer.de");

        return suppllier;
    }

    @Test
    public void testInsert() {
        SupplierDAO dao = new SupplierDAOImpl();
        Supplier supplier = createSupplier();

        dao.insertSupplier(supplier);

        List<Supplier> listsupplier = dao.findByName(supplier.getName());
        boolean exists = false;
        for (Supplier supplier2 : listsupplier) {
            if (supplier.getId() == supplier2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        SupplierDAO dao = new SupplierDAOImpl();
        Supplier supplier = createSupplier();

        dao.insertSupplier(supplier);
        supplier.setContactPerson("Alfred Bayer");
        dao.updateSupplier(supplier);

        List<Supplier> listsupplier = dao.findByName(supplier.getName());
        for (Supplier supplier2 : listsupplier) {
            if (supplier.getId() == supplier2.getId()) {
                Assert.assertEquals(supplier.getContactPerson(), supplier2.getContactPerson());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        SupplierDAO dao = new SupplierDAOImpl();
        Supplier supplier = createSupplier();

        dao.insertSupplier(supplier);
        dao.deleteSupplier(supplier);

        List<Supplier> listsupplier = dao.findByName(supplier.getName());
        boolean exists = false;
        for (Supplier supplier2 : listsupplier) {
            if (supplier.getId() == supplier2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        SupplierDAO dao = new SupplierDAOImpl();
        Supplier supplier = createSupplier();
        int size = dao.findAll().size();
        dao.insertSupplier(supplier);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }

}
