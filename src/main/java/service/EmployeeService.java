package service;

import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.OfficeDAO;

import java.util.Scanner;

public class EmployeeService {

    EmployeeDAO employeeDAO;
    CustomerDAO customerDAO;
    OfficeDAO officeDAO;
    Scanner scanner;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
        this.customerDAO = new CustomerDAO();
        this.officeDAO = new OfficeDAO();
        this.scanner = new Scanner(System.in);
    }
}
