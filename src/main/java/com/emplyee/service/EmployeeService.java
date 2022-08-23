package com.emplyee.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emplyee.model.Employee;


@Repository
public interface EmployeeService extends  JpaRepository<Employee,Long>{
	

}
