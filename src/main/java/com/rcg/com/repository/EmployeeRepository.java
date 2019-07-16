package com.rcg.com.repository;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> 
{

}
