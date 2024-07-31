package com.mysite.demo.app.recipeat.rest;


import com.mysite.demo.app.recipeat.entity.Recipe;
import com.mysite.demo.app.recipeat.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

	//	inject employee Service (use constructor injection)
	private EmployeeService employeeService;

	@Autowired

	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	//	expose "/employees" and return a list of employees
	@GetMapping("recipes")
	public List<Recipe> findAll(){
		return employeeService.findAll();
	}
}
