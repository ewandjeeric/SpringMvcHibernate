package org.beco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.beco.model.Employee;
import org.beco.service.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addemployee")
	public String saveEmployee(@RequestBody Employee em) {
		
		employeeServices.addEmp(em);
		return "Successfully Save";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allemployee")
	public List<Employee> allEmployee(){
		return employeeServices.getAllEmp();
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/employee/{id}")
	public Employee getemployee(@PathVariable("id") long id) {
		return employeeServices.getById(id);
	}

}
