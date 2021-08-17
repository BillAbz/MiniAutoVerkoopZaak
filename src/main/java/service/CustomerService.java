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
        Customer customer =  customerDAO.getCustomerByCustomerNumber(input);
        if (customer != null)
            System.out.println(customer);
        else
            System.out.println("Id does not match any existing customers.");
    }


    public Customer createACustomer() {
//        long phoneNumber = scanner.nextLong();
//        if (phoneNumber<9 || phoneNumber>10){
//            System.out.println("doesn't seem right");
//            phoneNumber = scanner.nextLong();
//        }else {
//            System.out.println(phoneNumber);                      //PhoneCheck
//            System.out.println("klopt dit nummer?   Y/N");
//            String yesNo= scanner.next();
//            if (yesNo.toUpperCase(Locale.ROOT)=="N"){
//                phoneNumber =scanner.nextLong();
//            }
//            System.out.println("thanks");
//        }
        return new Customer();
    }

    public void updateACustomer() {

    }

    public void deleteACustomer() {

    }

}
