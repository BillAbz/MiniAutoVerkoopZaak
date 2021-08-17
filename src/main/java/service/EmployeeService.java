package service;

import DAO.EmployeeDAO;
import DAO.OfficeDAO;
import Entities.Customer;
import Entities.Employee;
import Entities.Office;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeService {

    private EmployeeDAO employeeDAO;
    private Scanner scanner;
    private Office office;
    private OfficeService officeService;
    private OfficeDAO officeDAO;


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

    public void employeeToOffice(){
        try {
            showAllEmployees();

            System.out.println("Enter the ID of Employee you want to select:");
            int id = scanner.nextInt();
            Employee employee = employeeDAO.getEmployeeByEmployeeNumber(id);

            officeService.showAllOffices();

            System.out.println("Enter the ID of Office you want to select:");
            int id2 = scanner.nextInt();
            Office office = officeDAO.getOfficeByOfficeCode(id2);

            employee.setOffice(office);
            System.out.println("You put: "+employee+" in Office: "+office);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee createAnEmployee() {
        return new Employee();
    }

    public void updateAnEmployee() {

    }

    public void deleteAnEmployee() {

    }

}
