package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    List<Employee> findByFirstNameAndName(String firstname, String name);

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Employee employee);

}
