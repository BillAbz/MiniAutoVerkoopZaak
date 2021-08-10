package service;

import Entities.Costumer;

import java.sql.SQLException;
import java.util.Set;

public interface CustomerService {

    void addCustomer(Costumer customer);

    Costumer getCustomerById(int id) throws SQLException;

    Set<Costumer> getAllCustomers();

    void updateCustomer(Costumer customer);

    void deleteCustomer(Costumer customer);
}
