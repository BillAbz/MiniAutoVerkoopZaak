package service;

import Entities.Customer;

import java.sql.SQLException;
import java.util.Set;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int id) throws SQLException;

    Set<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
