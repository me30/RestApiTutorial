package com.commons.restAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commons.restAPI.entity.Employee;
import com.commons.restAPI.service.EmployeeService;
import com.commons.restAPI.utils.URI;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value=URI.EMPLOYEE)
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@ApiOperation(value = "get all Employee matching search", notes = "get all Employee matching search")
	@GetMapping("/search/")
	public Page<Employee> search(Pageable pageable, @RequestParam("searchText") String searchText) {
		return service.search(pageable, searchText);
	}

	@ApiOperation(value = "get ICD by id", notes = "get ICD by id")
	@ApiImplicitParam(name = "id", value = "ICD id", required = true, dataType = "Long", paramType = "path")
	@GetMapping("/{id}")
	public Employee read(@PathVariable Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "get all ICD", notes = "get all ICD")
	@GetMapping()
	public Page<Employee> readAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@ApiOperation(value = "save ICD", notes = "save ICD")
	@ApiParam(name = "ICD", value = "ICD to save", required = true)
	@PostMapping()
	public ResponseEntity<Employee> create(@RequestBody Employee entity) {
		entity = service.save(entity);
		return new ResponseEntity<Employee>(entity, HttpStatus.CREATED);
	}

	@ApiOperation(value = "update ICD", notes = "update ICD")
	@ApiParam(name = "ICD", value = "ICD to update", required = true)
	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@RequestBody Employee entity) {
		Employee db = service.findById(entity.getId());
		if (db == null)
			return new ResponseEntity("Employee ID not found", HttpStatus.BAD_REQUEST);

		entity.setId(db.getId());
		entity = service.save(entity);
		return new ResponseEntity<Employee>(entity, HttpStatus.OK);
	}

	@ApiOperation(value = "delete ICD", notes = "delete ICD")
	@ApiImplicitParam(name = "id", value = "ICD id", required = true, dataType = "Long", paramType = "path")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
