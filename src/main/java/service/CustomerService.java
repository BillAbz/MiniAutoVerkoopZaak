package service;

import DAO.CustomerDAO;
import Entities.Customer;

import java.sql.SQLException;
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
        Customer customer =  customerDAO.getCustomerByCustomerNumber(input);
        if (customer != null)
            System.out.println(customer);
        else
            System.out.println("Id does not match any existing customers.");
    }


    public Customer createACustomer() {
        return new Customer();
    }

    public void updateACustomer() {

    }

    public void deleteACustomer() {

    }

}
