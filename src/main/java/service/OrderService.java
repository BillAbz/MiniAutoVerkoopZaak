package service;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;

import java.util.Scanner;

public class OrderService {

    OrderDAO orderDAO;
    OrderDetailDAO orderDetailDAO;
    CustomerDAO customerDAO;
    Scanner scanner;

    public OrderService() {
        this.orderDAO = new OrderDAO();
        this.orderDetailDAO =new OrderDetailDAO();
        this.customerDAO = new CustomerDAO();
        this.scanner =  new Scanner(System.in);
    }
}
