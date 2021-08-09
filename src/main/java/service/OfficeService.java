package service;

import DAO.EmployeeDAO;
import DAO.OfficeDAO;

import java.util.Scanner;

public class OfficeService {
    OfficeDAO officeDAO;
    EmployeeDAO employeeDAO;
    Scanner scanner;

    public OfficeService() {
        this.officeDAO = new OfficeDAO();
        this.employeeDAO = new EmployeeDAO();
        this.scanner = new Scanner(System.in);
    }
}
