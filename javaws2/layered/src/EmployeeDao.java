package com.layered.dao;

import java.util.List;

import com.layered.entity.Employee;
import com.layered.exception.DataNotFoundException;
import com.layered.exception.InvalidUpdateException;
import com.layered.exception.SaveDataException;

public interface EmployeeDao {
	
	void SaveEmployee(Employee e) throws SaveDataException;
	Employee getEmployee(int empId);  //returns null if object is not found
	List<Employee> getAllEmployee();
	void updateEmployee(Employee e) throws DataNotFoundException;
	void deleteEmployee (int empId) throws DataNotFoundException;
	}
	


