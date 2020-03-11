package com.sachinmukherjee.springboot.springbootcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sachinmukherjee.springboot.springbootcrud.entity.Employee;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> employee = query.getResultList();
		return employee;
	}



	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}



	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		//if id is 0 the it save/inserst the entity else its update the entity
		currentSession.saveOrUpdate(employee);
		
	}



	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
