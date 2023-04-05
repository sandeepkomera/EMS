package com.sandeep.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.ems.dao.EmployeeDao;
import com.sandeep.ems.entities.Employee;
import com.sandeep.ems.exception.UserNotFoundException;
import com.sandeep.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Employee saveEmployee(Employee employee) {
		return employeedao.save(employee);
	}

	@Override
	public List<Employee> retriveAllEmployees() {

		return employeedao.findAll();
	}

	@Override
	public Employee retriveEmployeeByid(Integer eid) {

		Optional<Employee> employee = employeedao.findById(eid);
		if (!employee.isPresent()) {
			throw new UserNotFoundException("eid -" + eid);
		}
		return employee.get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteEmployeesByid(Integer eid) {
		if (employeedao.findById(eid).isPresent()) {
			employeedao.deleteById(eid);
		} else
			throw new UserNotFoundException("Entered Employee id is not present" + eid);

	}

	@Override
	public void deleteAllEmployees() {
		employeedao.deleteAll();
	}

}
