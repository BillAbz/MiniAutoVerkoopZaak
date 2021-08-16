package service;

import DAO.EmployeeDAO;
import Entities.Customer;
import Entities.Employee;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeService {

    private EmployeeDAO employeeDAO;
    private Scanner scanner;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllEmployees() throws SQLException {
        if (employeeDAO.getAllEmployees() != null)
            employeeDAO.getAllEmployees().forEach(System.out::println);
        else
            System.out.println("No employees to show.");
    }

    public void showEmployeeByEmployeeNumber() throws SQLException {
        System.out.println("What is the id of the employee you want to lookup?");
        int input = scanner.nextInt();
        Employee employee =  employeeDAO.getEmployeeByEmployeeNumber(input);
        if (employee != null)
            System.out.println(employee);
        else
            System.out.println("Id does not match any of the employees.");
    }


    public Employee createAnEmployee() {
        return new Employee();
    }

    public void updateAnEmployee() {

    }

    public void deleteAnEmployee() {

    }

}
