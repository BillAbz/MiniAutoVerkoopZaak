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

    public void showEmployeeByLand() {
        System.out.println ("Which country would you like to look at employees in? \n1: U.S.A\n2: France\n3: Japan\n4: Australia\n5: England\n0: End");
        int input = scanner.nextInt();
        if (input == 1){
            System.out.println ("Employees working in the U.S.A.");
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("1"))).forEach (System.out::println);
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("2"))).forEach (System.out::println);
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("3"))).forEach (System.out::println);
        }else if (input == 2){
            System.out.println ("Employees working in the France");
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("4"))).forEach (System.out::println);
        }
        else if (input == 3){
            System.out.println ("Employees working in the Japan");
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("5"))).forEach (System.out::println);
        }
        else if (input == 4){
            System.out.println ("Employees working in the Australia");
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("6"))).forEach (System.out::println);
        }
        else if (input == 5){
            System.out.println ("Employees working in the England");
            employeeDAO.getAllEmployees ().stream().filter (employee -> (employee.getOfficeCode ().equals ("7"))).forEach (System.out::println);
        }else {
            System.out.println ("Please write correct number!");
            showEmployeeByLand ();
        }

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
