package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.ExtemporaneousProduct;

public interface ExtemporaneousProductDAO {

    List<ExtemporaneousProduct> findAll();

    List<ExtemporaneousProduct> findByDescription(String description);

    boolean insertExtemporaneousProduct(ExtemporaneousProduct extemExtemporaneousProduct);

    boolean updateExtemporaneousProduct(ExtemporaneousProduct extemExtemporaneousProduct);

    boolean deleteExtemporaneousProduct(ExtemporaneousProduct extemExtemporaneousProduct);

}
