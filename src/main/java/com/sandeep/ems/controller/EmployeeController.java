package com.sandeep.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ems.entities.EHS;
import com.sandeep.ems.entities.Employee;
import com.sandeep.ems.service.EmployeeService;
import com.sandeep.ems.service.OrganizationService;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private OrganizationService organizationService;

	@PostMapping("/employees/save")
	public ResponseEntity<Void> joinOrganization(@RequestBody Employee employee, EHS healthinsurance) {
		organizationService.joinOrganization(employee, healthinsurance);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Void> deleteEmployeesByid(@PathVariable("id") Integer id) {
		organizationService.leaveOrganization(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/employees/retriveAll")
	public ResponseEntity<List<Employee>> retriveEmployees() {
		List<Employee> retriveEmp = employeeService.retriveAllEmployees();
		return new ResponseEntity<List<Employee>>(retriveEmp, HttpStatus.OK);
	}

	@GetMapping("/employees/retrive/{id}")
	public ResponseEntity<Employee> retriveEmployeeByid(@PathVariable("id") Integer id) {
		Employee retriveEmpId = employeeService.retriveEmployeeByid(id);
		return new ResponseEntity<Employee>(retriveEmpId, HttpStatus.OK);
	}

//	@DeleteMapping("/employees/delete/{id}")
//	public ResponseEntity<Void> deleteEmployeesByid(@PathVariable("id") Integer id) {
//		employeeService.deleteEmployeesByid(id);
//		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//	}

	@DeleteMapping("/employees/deleteAll")
	public ResponseEntity<Void> deleteAllEmployees() {
		employeeService.deleteAllEmployees();
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/employees/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updEmp = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(updEmp, HttpStatus.CREATED);
	}

}
