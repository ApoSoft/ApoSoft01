package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.ExtemporaneousProductDAO;
import de.wak_sh.aposoft.dao.impl.ExtemporaneousProductDAOImpl;
import de.wak_sh.aposoft.domain.ExtemporaneousProduct;

public class TestExtemporaneousProduct {

    private ExtemporaneousProduct createExtemporaneousProduct() {
        ExtemporaneousProduct extemporaneousProduct = new ExtemporaneousProduct();

        extemporaneousProduct.setDescription("Salbe");

        return extemporaneousProduct;
    }

    @Test
    public void testInstert() {
        ExtemporaneousProductDAO dao = new ExtemporaneousProductDAOImpl();

        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        dao.insertExtemporaneousProduct(extemporaneousProduct);

        List<ExtemporaneousProduct> listext = dao.findByDescription(extemporaneousProduct.getDescription());
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
        ExtemporaneousProductDAO dao = new ExtemporaneousProductDAOImpl();

        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        dao.insertExtemporaneousProduct(extemporaneousProduct);

        ExtemporaneousProduct extProduct = extemporaneousProduct;

        extemporaneousProduct.setDescription("Creme");

        dao.updateExtemporaneousProduct(extemporaneousProduct);

        List<ExtemporaneousProduct> listextemproduct = dao.findAll();
        boolean exists = false;
        for (ExtemporaneousProduct ext : listextemproduct) {
            if (extProduct.equals(ext)) {
                exists = true;
                break;
            }
        }

        Assert.assertFalse(exists);
    }

    @Test
    public void testDelete() {
        ExtemporaneousProductDAO dao = new ExtemporaneousProductDAOImpl();

        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        dao.insertExtemporaneousProduct(extemporaneousProduct);

        dao.deleteExtemporaneousProduct(extemporaneousProduct);

        List<ExtemporaneousProduct> listextemproduct = dao.findAll();
        boolean exists = false;
        for (ExtemporaneousProduct ext : listextemproduct) {
            if (extemporaneousProduct.equals(ext)) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testfindAll() {
        ExtemporaneousProductDAO dao = new ExtemporaneousProductDAOImpl();

        ExtemporaneousProduct extemporaneousProduct = createExtemporaneousProduct();

        int size = dao.findAll().size();

        dao.insertExtemporaneousProduct(extemporaneousProduct);

        Assert.assertEquals(size + 1, dao.findAll().size());
    }

}
