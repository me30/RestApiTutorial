package com.commons.restAPI.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.commons.restAPI.entity.Employee;
import com.commons.restAPI.respository.EmployeeRepository;
import com.commons.restAPI.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends BasicService<Employee, EmployeeRepository> implements EmployeeService{

	@Override 
	public Page<Employee> search(Pageable pageable, String searchText) {
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		return repository.search(pageable, queriableText);
	}
}