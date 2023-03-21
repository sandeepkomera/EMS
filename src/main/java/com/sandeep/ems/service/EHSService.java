package com.sandeep.ems.service;

import com.sandeep.ems.entities.EHS;

public interface EHSService {

	public void registerEmployeeHealthInsurance(EHS employeeHealthInsurance);

	public void deleteEmployeeHealthInsuranceById(Integer insuranceid);

}
