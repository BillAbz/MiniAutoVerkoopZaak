package service;

import Entities.Employee;

import java.util.Set;

public interface EmployeeService {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    Set<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
