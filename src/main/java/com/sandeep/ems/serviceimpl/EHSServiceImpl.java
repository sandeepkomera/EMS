package com.sandeep.ems.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.ems.dao.EHSDao;
import com.sandeep.ems.entities.EHS;
import com.sandeep.ems.service.EHSService;

@Service
public class EHSServiceImpl implements EHSService {

	@Autowired
	private EHSDao ehsDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerEmployeeHealthInsurance(EHS ehs) {
		ehsDao.save(ehs);
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(Integer insuranceId) {
		ehsDao.deleteById(insuranceId);

	}

}
