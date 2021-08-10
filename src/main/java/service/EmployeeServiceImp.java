package service;

import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.OfficeDAO;
import Entities.Employee;
import org.hibernate.boot.archive.scan.spi.Scanner;

import java.util.Set;


public class EmployeeServiceImp implements EmployeeService {

    EmployeeDAO employeeDAO;
    CustomerDAO customerDAO;
    OfficeDAO officeDAO;
    Scanner scanner;

    public EmployeeServiceImp() {
        this.employeeDAO = new EmployeeDAO();
        this.customerDAO = new CustomerDAO();
        this.officeDAO = new OfficeDAO();
//        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployees(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeByEmployeeNumber(id);
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployee();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployees(employee);

    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployees(employee);
    }
}
