package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.Supplier;

public interface SupplierDAO {
    boolean insertSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean deleteSupplier(Supplier supplier);

    List<Supplier> findAll();

    List<Supplier> findByName(String name);

}
