package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.AddressDAO;
import de.wak_sh.aposoft.dao.impl.AddressDAOImpl;
import de.wak_sh.aposoft.domain.Address;

public class TestAddress {

    private Address createAddress() {

        Address address = new Address();

        address.setCity("Kiel");

        address.setEmail("abc@mail.de");
        address.setExtra01("abc");
        address.setNumber("49");
        address.setPhone(99821);
        address.setPostalCode(0431);
        address.setStreet("abcStraße 9");

        return address;
    }

    @Test
    public void testInsert() {
        AddressDAO dao = new AddressDAOImpl();

        Address address = createAddress();

        dao.insertAddress(address);

        List<Address> listaddress = dao.findByCity(address.getCity());
        boolean exists = false;
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        AddressDAO dao = new AddressDAOImpl();

        Address address = createAddress();

        dao.insertAddress(address);
        address.setCity("Hamburg");
        dao.updateAddress(address);

        List<Address> listaddress = dao.findByCity(address.getCity());
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                Assert.assertEquals(address.getCity(), address2.getCity());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        AddressDAO dao = new AddressDAOImpl();

        Address address = createAddress();

        dao.insertAddress(address);
        dao.deleteAddress(address);

        List<Address> listaddress = dao.findByCity(address.getCity());
        boolean exists = false;
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testfindAll() {
        AddressDAO dao = new AddressDAOImpl();
        Address address = createAddress();

        int size = dao.findAll().size();
        dao.insertAddress(address);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }

    @Test
    public void testUpdateWithPostaleCode() {
        AddressDAO dao = new AddressDAOImpl();

        Address address = createAddress();

        dao.insertAddress(address);

        List<Address> listaddress = dao.findByPostalCode(0431);
        boolean exists = false;
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }
}
