package com.kodnest.DOAPattern.DOAPAttern;

import java.util.List;

public interface EmployeeDAO {
	public List<Employee> getEmployee();

	public Employee getEmployeeByid(int id);

	public String persistEmployee(Employee obj);

	public String updateEmployee(String department);

	public String deleteemployee(Employee obj);

}
