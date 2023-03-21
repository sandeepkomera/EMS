package com.sandeep.ems.service;

import com.sandeep.ems.entities.EHS;
import com.sandeep.ems.entities.Employee;

public interface OrganizationService {

	public void joinOrganization(Employee employee, EHS employeeHealthInsurance);

	public void leaveOrganization(Employee employee, EHS employeeHealthInsurance);

}