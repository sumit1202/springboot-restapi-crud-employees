package com.example.springboot.crudrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.crudrestapi.dao.EmployeeDAO;
import com.example.springboot.crudrestapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAllService() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee findEmployeeByIdService(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee saveEmployeeService(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeByIdService(int id) {
        employeeDAO.deleteEmployeeById(id);
    }

}
