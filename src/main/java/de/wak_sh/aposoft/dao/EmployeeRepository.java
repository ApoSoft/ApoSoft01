package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByFirstNameAndName(String firstName, String name);
}
