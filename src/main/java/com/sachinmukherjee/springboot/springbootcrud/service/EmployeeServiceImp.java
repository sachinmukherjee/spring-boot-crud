package com.sachinmukherjee.springboot.springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sachinmukherjee.springboot.springbootcrud.dao.EmployeeDAO;
import com.sachinmukherjee.springboot.springbootcrud.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService, EmployeeDAO {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);

	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);

	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.deleteById(id);

	}

}
