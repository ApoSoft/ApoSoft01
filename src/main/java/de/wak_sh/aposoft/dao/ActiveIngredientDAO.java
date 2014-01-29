package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.ActiveIngredient;

public interface ActiveIngredientDAO {

    boolean insertActiveIngredient(ActiveIngredient activeIngredient);

    boolean updateActiveIngredient(ActiveIngredient activeIngredient);

    boolean deleteActiveIngredient(ActiveIngredient activeIngredient);

    List<ActiveIngredient> findAll();

    List<ActiveIngredient> findByName(String name);
}
