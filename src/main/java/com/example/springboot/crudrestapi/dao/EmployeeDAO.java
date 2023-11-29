package com.example.springboot.crudrestapi.dao;

import java.util.List;
import com.example.springboot.crudrestapi.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(int id);

}
