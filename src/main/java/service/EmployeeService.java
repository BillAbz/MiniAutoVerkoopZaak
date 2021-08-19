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
            System.err.println("Employee doesn't exist.");
            id = scanner.nextInt();
        } else {
            System.out.println("What would you like to update:\n");



            do {
                done = false;

                String updateMore;


                System.out.println("Please select an option: \n(1)Customer name\n(2)First name\n(3)Last name\n(4)Phone number\n(5)AddressLine1\n(6)AddressLine2\n(7)City\n(8)State\n(9)Postal code\n(10)Country");
                int selection = scanner.nextInt();

                while (selection > 10 || selection < 1) {
                    System.out.println("Please make a valid selection");
                    selection = scanner.nextInt();
                }

                switch (selection) {
                    case 1:
                        System.out.println("customer name:");
                        String customerName;
                        boolean isUnique;
                        do {
                            isUnique = true;
                            System.out.println("Customer name:");
                            customerName = scanner.nextLine();
                            for (Customer customer1 : customerDAO.getAllCustomers()) {
                                if (customer1.getCustomerName().contentEquals(customerName)) {
                                    System.out.println("Customer name already exists.");
                                    isUnique = false;
                                    break;
                                }
                            }
                        } while (!isUnique);

                        customer.setCustomerName(customerName);
                        System.out.println("Username has been updated to: " + customerName);


                        break;
                    case 2:
                        System.out.println("First Name:");
                        String firstName = scanner.nextLine();
                        customer.setFirstName(firstName);
                        System.out.println("First name has been updated to: " + firstName);


                        break;

                    case 3:
                        System.out.println("Last Name:");
                        String lastName = scanner.nextLine();
                        customer.setLastName(lastName);
                        System.out.println("Last name has been updated to: " + lastName);


                        break;


                    case 4:
                        System.out.println("PhoneNumber:"); //Todo:: Make loop instead of passing once in if else statement, also make check more solid
                        String phone = scanner.nextLine();
                        if (phone.length() < 9 || phone.length() > 10) {
                            System.out.println("doesn't seem right");
                            phone = scanner.next();
                        } else {
                            System.out.println(phone);
                            System.out.println("klopt dit nummer?   Y/N");
                            String yesNo = scanner.next();
                            if (yesNo.toUpperCase(Locale.ROOT) == "N") {
                                phone = scanner.next();
                            }
                            System.out.println("thanks");
                            customer.setPhone(phone);
                        }
                        System.out.println("Phone number has been updated to: " + phone);


                        break;


                    case 5:
                        System.out.println("AddressLine1:");
                        String addressLine1 = scanner.nextLine();
                        customer.setAddressLine1(addressLine1);
                        System.out.println("Address line 1 has been updated to: " + addressLine1);

                        break;
                    case 6:
                        System.out.println("AddressLine2:");
                        String addressLine2 = scanner.nextLine();
                        customer.setAddressLine2(addressLine2);
                        System.out.println("Address line 2 has been updated to: " + addressLine2);

                        break;
                    case 7:
                        System.out.println("City:");
                        String city = scanner.nextLine();
                        customer.setCity(city);
                        System.out.println("City has been updated to: " + city);


                        break;
                    case 8:
                        System.out.println("State:");
                        String state = scanner.nextLine();
                        customer.setState(state);
                        System.out.println("State has been updated to: " + state);



                        break;
                    case 9:
                        System.out.println("PostalCode:");
                        String postalCode = scanner.nextLine();
                        customer.setPostalCode(postalCode);
                        System.out.println("Postal code has been updated to: " + postalCode);


                        break;
                    case 10:
                        System.out.println("Country:");
                        String country = scanner.nextLine();
                        customer.setCountry(country);
                        System.out.println("Country has been updated to: " + country);

                        break;


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

            customerDAO.updateCustomers(customer);


        }

    }

    public void deleteAnEmployee() {

    }

}
