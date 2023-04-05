package com.sandeep.ems.service;

import java.util.List;

import com.sandeep.ems.entities.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> retriveAllEmployees();

	public  Employee retriveEmployeeByid(Integer id);

	public void deleteEmployeesByid(Integer id);

	public void deleteAllEmployees();

}
