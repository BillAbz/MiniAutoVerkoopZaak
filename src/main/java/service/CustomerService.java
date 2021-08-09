package service;


import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.OrderDAO;
import DAO.PaymentDAO;

import java.util.Scanner;

public class CustomerService {

    CustomerDAO customerDAO;
    EmployeeDAO employeeDAO;
    OrderDAO orderDAO;
    PaymentDAO paymentDAO;
    Scanner scanner;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
        this.employeeDAO = new EmployeeDAO();
        this.orderDAO = new OrderDAO();
        this.paymentDAO = new PaymentDAO();
        this.scanner = new Scanner(System.in);
    }


}
