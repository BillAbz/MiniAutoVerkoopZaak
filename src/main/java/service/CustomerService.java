package service;

import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.PaymentDAO;
import Entities.Customer;
import Entities.Employee;
import Entities.Payment;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CustomerService {

    private CustomerDAO customerDAO;
    private Scanner scanner;
    private EmployeeService employeeService;
    private EmployeeDAO employeeDAO;
    private PaymentDAO paymentDAO;
    private List<Payment>payments;

    public CustomerService() {
        customerDAO = new CustomerDAO();
        scanner = new Scanner(System.in);
        employeeService = new EmployeeService();
        employeeDAO = new EmployeeDAO();
        paymentDAO = new PaymentDAO();

    }

    public void showAllCustomers() throws SQLException {
        if (customerDAO.getAllCustomers() != null)
            customerDAO.getAllCustomers().forEach(System.out::println);
        else
            System.out.println("No customers to show.");
    }

    public void showCustomerByCustomerNumber() throws SQLException {
        System.out.println("What is the id of the customer you want to lookup?");
        int input = scanner.nextInt();
        Customer customer = customerDAO.getCustomerByCustomerNumber(input);
        if (customer != null)
            System.out.println(customer);
        else
            System.out.println("Id does not match any existing customers.");
    }


    public Customer createACustomer() throws SQLException, ParseException {

        Customer customer = new Customer();
        System.out.println("Enter Customer Details:");
        System.out.println();
        String customerName;
        boolean isUnique;
        do {
            isUnique = true;
            System.out.println("Customer name:");
            customerName = scanner.next();
            for (Customer customer1 : customerDAO.getAllCustomers()) {
                if (customer1.getCustomerName().contentEquals(customerName)) {
                    System.out.println("Customer name already exists.");
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        System.out.println("First Name:");
        String firstName = scanner.next();
        boolean wrong = true;
        while(wrong) {
            if (firstName.length() <= 0) {
                System.out.println("please enter your first name");
            } else {
                customer.setFirstName(firstName);
                wrong = false;
            }
        }

        System.out.println("Last Name:");
        String lastName = scanner.next();
        boolean wrong2 = true;
        while(wrong2) {
            if (lastName.length() <= 0) {
                System.out.println("please enter your first name");
            } else {
                customer.setLastName(lastName);
                wrong2 = false;
            }
        }
        System.out.println("PhoneNumber:");
        String phone = scanner.next();
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
        }
        System.out.println("AddressLine1:");
        String addressLine1 = scanner.next();
        System.out.println("AddressLine2:");
        String addressLine2 = scanner.next();
        System.out.println("City:");
        String city = scanner.next();
        System.out.println("State:");
        String state = scanner.next();
        System.out.println("PostalCode:");
        String postalCode = scanner.next();
        System.out.println("Country:");
        String country = scanner.next();
        System.out.println("Sales report  employee number:");
        System.out.println("Enter employee id number for sales rep: ");
        int employeeId = scanner.nextInt();
        Employee employee = employeeDAO.getEmployeeByEmployeeNumber(employeeId);
        while (employee == null) {
            System.err.println("Employee doesn't exist, please enter a valid number.");
            employeeId = scanner.nextInt();
            employee = employeeDAO.getEmployeeByEmployeeNumber(employeeId);
        }
        System.out.println("Set credit limit");
        double creditLimit = scanner.nextDouble();


        System.out.println("what payment do you want to add , give the check number");
        paymentDAO.getAllPayments();
        payments.add(paymentDAO.getPaymentByCheckNumber(scanner.nextInt()));
        customer.setPayments(payments);



        customer.setCustomerName(customerName);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setAddressLine1(addressLine1);
        customer.setAddressLine2(addressLine2);
        customer.setCity(city);
        customer.setState(state);
        customer.setPostalCode(postalCode);
        customer.setCountry(country);
        customer.setSalesRepEmployeeNumber(employee);
        customer.setCreditLimit(creditLimit);

        customerDAO.addCustomers(customer);

        return customer;
    }


    public void updateACustomer() throws SQLException {
        boolean done;
        System.out.println("please enter the id of the customer you wish to update");
        int id = scanner.nextInt();
        Customer customer = customerDAO.getCustomerByCustomerNumber(id);

        while (customer == null) {
            System.err.println("Customer doesn't exist. Please enter a valid id.");
            id = scanner.nextInt();
            customer = customerDAO.getCustomerByCustomerNumber(id);
        }
        System.out.println(customer);
        System.out.println("What would you like to update:\n");



            do {
                done = false;

                String updateMore;


                System.out.println("Please select an option: \n(1)Customer name\n(2)First name\n(3)Last name\n(4)Phone number\n(5)AddressLine1\n(6)AddressLine2\n(7)City\n(8)State\n(9)Postal code\n(10)Country\n(11)Sales report Employee\n(12)Credit Limit\n(13)Payment");
                int selection = scanner.nextInt();

                while (selection > 13 || selection < 1) {
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
                            customerName = scanner.next();
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
                        String firstName = scanner.next();
                        customer.setFirstName(firstName);
                        System.out.println("First name has been updated to: " + firstName);


                        break;

                    case 3:
                        System.out.println("Last Name:");
                        String lastName = scanner.next();
                        customer.setLastName(lastName);
                        System.out.println("Last name has been updated to: " + lastName);


                        break;


                    case 4:
                        System.out.println("PhoneNumber:"); //Todo:: Make loop instead of passing once in if else statement, also make check more solid
                        String phone = scanner.next();
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
                        String addressLine1 = scanner.next();
                        customer.setAddressLine1(addressLine1);
                        System.out.println("Address line 1 has been updated to: " + addressLine1);

                        break;
                    case 6:
                        System.out.println("AddressLine2:");
                        String addressLine2 = scanner.next();
                        customer.setAddressLine2(addressLine2);
                        System.out.println("Address line 2 has been updated to: " + addressLine2);

                        break;
                    case 7:
                        System.out.println("City:");
                        String city = scanner.next();
                        customer.setCity(city);
                        System.out.println("City has been updated to: " + city);


                        break;
                    case 8:
                        System.out.println("State:");
                        String state = scanner.next();
                        customer.setState(state);
                        System.out.println("State has been updated to: " + state);



                        break;
                    case 9:
                        System.out.println("PostalCode:");
                        String postalCode = scanner.next();
                        customer.setPostalCode(postalCode);
                        System.out.println("Postal code has been updated to: " + postalCode);


                        break;
                    case 10:
                        System.out.println("Country:");
                        String country = scanner.next();
                        customer.setCountry(country);
                        System.out.println("Country has been updated to: " + country);

                        break;

                    case 11:
                        System.out.println("Sales report employee: ");
                        int employeeId = scanner.nextInt();
                        Employee employee = employeeDAO.getEmployeeByEmployeeNumber(employeeId);
                        while (employee == null) {
                            System.err.println("Employee doesn't exist, please enter a valid number.");
                            employeeId = scanner.nextInt();
                            employee = employeeDAO.getEmployeeByEmployeeNumber(employeeId);
                        }
                        customer.setSalesRepEmployeeNumber(employee);
                        System.out.println("Sales report employee has been updated to: " + employee);

                        break;
                    case 12:
                        System.out.println("Credit limit:");
                        double creditLimit = scanner.nextDouble();
                        customer.setCreditLimit(creditLimit);
                        System.out.println("Credit limit has been updated to: " + creditLimit);
                        break;
                    case 13:
                        System.out.println("Payment: (give the checknumber)");
                        paymentDAO.getAllPayments();
                        payments.add(paymentDAO.getPaymentByCheckNumber(scanner.nextInt()));
                        customer.setPayments(payments);
                        System.out.println("payment has been updated");



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




public void deleteACustomer(){
        boolean delete;
        String deleteMore;

do{

    System.out.println("please enter the id of the customer you wish to delete");
    int id = scanner.nextInt();
    Customer customer = customerDAO.getCustomerByCustomerNumber(id);

    while (customer == null) {
        System.err.println("Customer doesn't exist. Please enter a valid id.");
        id = scanner.nextInt();
        customer = customerDAO.getCustomerByCustomerNumber(id);
    }

        System.out.println(customer);
        System.out.println("\nAre you sure you wish to delete this customer? Y/N: ");
        String answer = scanner.next();
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            System.out.println("\nAre you sure you wish to delete this customer? Y/N: ");
            answer = scanner.next();
        }
        if (answer.equalsIgnoreCase("y")) {
            customerDAO.deleteCustomers(customer);
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

