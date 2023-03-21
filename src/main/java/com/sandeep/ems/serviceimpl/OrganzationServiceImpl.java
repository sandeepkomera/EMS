package com.sandeep.ems.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.ems.entities.EHS;
import com.sandeep.ems.entities.Employee;
import com.sandeep.ems.service.EHSService;
import com.sandeep.ems.service.EmployeeService;
import com.sandeep.ems.service.OrganizationService;

@Service
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EHSService healthInsuranceService;

	@Override
	@Transactional
	public void joinOrganization(Employee employee, EHS employeeHealthInsurance) {
		employeeService.saveEmployee(employee);
		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	@Transactional
	public void leaveOrganization(Employee employee, EHS employeeHealthInsurance) {
		employeeService.deleteEmployeesByid(employee.getId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getInsuranceId());
	}

}
