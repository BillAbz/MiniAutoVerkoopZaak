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
                if (customer1.getCustomerName().contentEquals(customerName)) {
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

        boolean done;
        int id = scanner.nextInt();
        Customer customer = customerDAO.getCustomerByCustomerNumber(id);

        if (customer == null) {
            System.err.println("Customer doesn't exist.");
        } else {
            System.out.println("What would you like to update:\n");



            do {

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
                            }}while (!isUnique);

                        customer.setCustomerName(customerName);
                            System.out.println("Username has been updated to: " + customerName);

                            System.out.println("\nWould you like to update anything else?: Y/N");
                            updateMore = scanner.next();
                            while (updateMore != "Y" && updateMore != "N") {
                                System.out.println("Would you like to update anything else?: ->Y/N<-");
                                updateMore = scanner.next();
                            }
                            if (updateMore == "N"){
                                done = true;
                            }else done = false;

                            break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:



                        }
                }while (!done);


            }

    public void deleteACustomer() {

    }

}
}
