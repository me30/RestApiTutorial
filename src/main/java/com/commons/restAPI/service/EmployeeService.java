package com.commons.restAPI.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.commons.restAPI.entity.Employee;

public interface EmployeeService extends IService< Employee>,IFinder< Employee>{

	Page<Employee> search(Pageable pageable, String searchText);
}
