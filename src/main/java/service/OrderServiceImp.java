package service;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import Entities.Order;

import java.util.Scanner;
import java.util.Set;

public class OrderServiceImp implements OrderService {

    OrderDAO orderDAO;
    OrderDetailDAO orderDetailDAO;
    CustomerDAO customerDAO;
    Scanner scanner;

    public OrderServiceImp() {
        this.orderDAO = new OrderDAO();
        this.orderDetailDAO =new OrderDetailDAO();
        this.customerDAO = new CustomerDAO();
        this.scanner =  new Scanner(System.in);
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order getOrderById(long id) {
        return null;
    }

    @Override
    public Set<Order> getAllOrders() {
        return null;
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void deleteOrder(Order order) {

    }
}
