package service;

import DAO.CustomerDAO;
import Entities.Customer;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class CustomerService {

    private CustomerDAO customerDAO;
    private Scanner scanner;

    public CustomerService() {
        customerDAO = new CustomerDAO();
        scanner = new Scanner(System.in);
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


    public Customer createACustomer() {

        Customer customer = new Customer();
        System.out.println("Enter Customer Details:");
        System.out.println();
        String customerName;
        boolean isUnique;
        do {
            isUnique = true;
            System.out.println("Customer name:");
            customerName = scanner.nextLine();
            for (Customer customer1 : customerDAO.getAllCustomers()) {
                if (customer.getCustomerName().contentEquals(customerName)) {
                    System.out.println("Customer name already exists.");
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("PhoneNumber:");
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
        }
        System.out.println("AddressLine1:");
        String addressLine1 = scanner.nextLine();
        System.out.println("AddressLine2:");
        String addressLine2 = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("State:");
        String state = scanner.nextLine();
        System.out.println("PostalCode:");
        String postalCode = scanner.nextLine();
        System.out.println("Country:");
        String country = scanner.nextLine();
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
        customerDAO.addCustomers(customer);

        return new Customer();
    }

    public void updateACustomer() {


    }

    public void deleteACustomer() {

    }

}
