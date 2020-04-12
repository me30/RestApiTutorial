package com.commons.restAPI.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commons.restAPI.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{

	@Query(value = "select e from Employee e where e.name like ?1 or e.designation like ?1 or e.joingDate like ?1 ")
	Page<Employee> search(Pageable pageable, String queriableText);
}