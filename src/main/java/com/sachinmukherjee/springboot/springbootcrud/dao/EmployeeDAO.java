package com.sachinmukherjee.springboot.springbootcrud.dao;

import java.util.List;

import com.sachinmukherjee.springboot.springbootcrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
