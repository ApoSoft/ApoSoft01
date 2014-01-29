package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.Unit;

public interface UnitDAO {

    boolean insertUnit(Unit unit);

    boolean updateUnit(Unit unit);

    boolean deleteUnit(Unit unit);

    List<Unit> findAll();

    List<Unit> findByName(String name);
}
