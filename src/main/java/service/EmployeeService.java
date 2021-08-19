package service;

import DAO.EmployeeDAO;
import DAO.OfficeDAO;
import Entities.Customer;
import Entities.Employee;
import Entities.Office;

import java.sql.SQLException;
import java.util.Locale;
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



        Employee employee = new Employee();
        System.out.println("Enter Employee Details:");
        System.out.println();
        String customerName;

        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Extension:");
        String extension = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Office code:");
        String officeCode = scanner.nextLine();
        System.out.println("Reports to:");
        int reportsTo = scanner.nextInt();
        System.out.println("Job title");
        String jobTitle = scanner.nextLine();




        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setExtension(extension);
        employee.setEmail(email);
        employee.setOfficeCode(officeCode);
        employee.setReportsTo(reportsTo);
        employee.setJobTitle(jobTitle);

        employeeDAO.addEmployees(employee);

        return employee;
    }

    public void updateAnEmployee() {

        boolean done;
        System.out.println("please enter the number of the employee you wish to update");
        int id = scanner.nextInt();
        Employee employee = employeeDAO.getEmployeeByEmployeeNumber(id);

        while (employee == null) {
            System.err.println("Employee doesn't exist, please enter a valid number.");
            id = scanner.nextInt();
            employee = employeeDAO.getEmployeeByEmployeeNumber(id);
        }
            System.out.println("What would you like to update:\n");



            do {
                done = false;

                String updateMore;


                System.out.println("Please select an option: \n(1)First name\n(2)Last name\n(3)Email\n(4)Office code\n(5)Reports to\n(6)Job title");
                int selection = scanner.nextInt();

                while (selection > 6 || selection < 1) {
                    System.out.println("Please make a valid selection");
                    selection = scanner.nextInt();
                }

                switch (selection) {

                    case 1:
                        System.out.println("First Name:");
                        String firstName = scanner.nextLine();
                        employee.setFirstName(firstName);
                        System.out.println("First name has been updated to: " + firstName);


                        break;

                    case 2:
                        System.out.println("Last Name:");
                        String lastName = scanner.nextLine();
                        employee.setLastName(lastName);
                        System.out.println("Last name has been updated to: " + lastName);


                        break;


                    case 3:
                        System.out.println("Email:");
                        String email = scanner.nextLine();
                        employee.setEmail(email);
                        System.out.println("Phone number has been updated to: " + email);


                        break;


                    case 4:
                        System.out.println("Office code:");
                        String officeCode = scanner.nextLine();
                        employee.setOfficeCode(officeCode);
                        System.out.println("Address line 1 has been updated to: " + officeCode);

                        break;
                    case 5:
                        System.out.println("Reports to:");
                        int reportsTo = scanner.nextInt();
                        employee.setReportsTo(reportsTo);
                        System.out.println("Address line 2 has been updated to: " + reportsTo);

                        break;
                    case 6:
                        System.out.println("Job title:");
                        String jobTitle = scanner.nextLine();
                        employee.setJobTitle(jobTitle);
                        System.out.println("City has been updated to: " + jobTitle);





                }
                System.out.println("\nWould you like to update anything else?: Y/N");
                updateMore = scanner.next();
                while (!updateMore.equalsIgnoreCase("y") && !updateMore.equalsIgnoreCase("n") ) {
                    System.out.println("Would you like to update anything else?: ->Y/N<-");
                    updateMore = scanner.next();
                }
                if (updateMore.equalsIgnoreCase("n")){
                    done = true;
                }else done = false;




            }while (!done);

            employeeDAO.updateEmployees(employee);


        }



    public void deleteAnEmployee() {
        boolean delete;
        String deleteMore;

        do{

            System.out.println("please enter the number of the employee you wish to delete");
            int id = scanner.nextInt();
            Employee employee = employeeDAO.getEmployeeByEmployeeNumber(id);

            while (employee == null) {
                System.err.println("Employee doesn't exist. Please enter a valid id.");
                id = scanner.nextInt();
                employee = employeeDAO.getEmployeeByEmployeeNumber(id);
            }

            System.out.println(employee);
            System.out.println("\nAre you sure you wish to delete this employee? Y/N: ");
            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("\nAre you sure you wish to delete this employee? Y/N: ");
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("y")) {
                employeeDAO.deleteEmployees(employee);
            }if (answer.equalsIgnoreCase("n")){
                System.out.println("No changes have been made.");
            }



            System.out.println("\nWould you like to delete anything else?: Y/N");
            deleteMore = scanner.next();
            while (!deleteMore.equalsIgnoreCase("y") && !deleteMore.equalsIgnoreCase("n") ) {
                System.out.println("Would you like to update anything else?: ->Y/N<-");
                deleteMore = scanner.next();
            }
            if (deleteMore.equalsIgnoreCase("n")){
                delete = true;
            }else delete = false;


        }while (!delete);

    }

}
