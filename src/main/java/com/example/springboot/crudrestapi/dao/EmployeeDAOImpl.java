package com.example.springboot.crudrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.springboot.crudrestapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    // save new employee if not exist, id==0
    // else save updated existing employee
    @Override
    public Employee saveEmployee(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }

}
