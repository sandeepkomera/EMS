package com.sandeep.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.ems.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
