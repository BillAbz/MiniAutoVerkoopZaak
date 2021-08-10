package service;

import Entities.Costumer;

import java.util.Set;

public interface CustomerService {

    void addCustomer(Costumer customer);

    Costumer getCustomerById(long id);

    Set<Costumer> getAllCustomers();

    void updateCustomer(Costumer customer);

    void deleteCustomer(Costumer customer);
}
