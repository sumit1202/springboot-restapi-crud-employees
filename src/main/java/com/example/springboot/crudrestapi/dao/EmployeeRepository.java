package com.example.springboot.crudrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springboot.crudrestapi.entity.Employee;

// annotation used incase want to customize path name as "/members" 
// else "/employees" will be auto generated
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
