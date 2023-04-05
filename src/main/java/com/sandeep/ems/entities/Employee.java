package com.sandeep.ems.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String ename;
	private String role;
	private Integer salary;

	@OneToOne(cascade = CascadeType.ALL)
	private EHS ehs;

	protected Employee() {
		super();
	}

	public Employee(Integer id, String ename, String role, Integer salary, EHS ehs) {
		super();
		this.id = id;
		this.ename = ename;
		this.role = role;
		this.salary = salary;
		this.ehs = ehs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public EHS getEhs() {
		return ehs;
	}

	public void setEhs(EHS ehs) {
		this.ehs = ehs;
	}

}
