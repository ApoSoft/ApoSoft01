package de.wak_sh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Employee;

/**
 * JPA Repository for employee objects
 * 
 * @author Christoph Mende
 * 
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    /**
     * Returns a list of all employee objects having the given first and last
     * name
     * 
     * @param firstName
     *            first name of the employee
     * @param name
     *            last name of the employee
     * @return list of matching employees
     */
    List<Employee> findByFirstNameAndName(String firstName, String name);
}
