package service;


import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.OrderDAO;
import DAO.PaymentDAO;
import Entities.Costumer;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class CustomerServiceImp implements CustomerService {

    CustomerDAO customerDAO;
    EmployeeDAO employeeDAO;
    OrderDAO orderDAO;
    PaymentDAO paymentDAO;
    Scanner scanner;

    public CustomerServiceImp() {
        this.customerDAO = new CustomerDAO();
        this.employeeDAO = new EmployeeDAO();
        this.orderDAO = new OrderDAO();
        this.paymentDAO = new PaymentDAO();
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void addCustomer(Costumer customer) {
        customerDAO.addCostumers(customer);
    }

    @Override
    public Costumer getCustomerById(int id)  {
        return customerDAO.getCostumerByCostumerNumber(id);
    }

    @Override
    public Set<Costumer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public void updateCustomer(Costumer customer) {
        customerDAO.updateCostumers(customer);
    }

    @Override
    public void deleteCustomer(Costumer customer) {
        customerDAO.deleteCostumers(customer);
    }


}
