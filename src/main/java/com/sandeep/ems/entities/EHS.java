package com.sandeep.ems.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "insurance")
public class EHS {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private Integer insuranceId;
	private Integer coverageAmount;
	private String insuranceType;

	protected EHS() {
		super();
	}

	public EHS(Integer insuranceId, Integer coverageAmount, String insuranceType) {
		super();
		this.insuranceId = insuranceId;
		this.coverageAmount = coverageAmount;
		this.insuranceType = insuranceType;
	}

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Integer getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Integer coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

}
