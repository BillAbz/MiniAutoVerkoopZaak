package service;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import Entities.Order;

import java.util.Scanner;
import java.util.Set;

public class OrderDetailServiceImp implements OrderService {

    OrderDetailDAO orderDetailDAO;
    OrderDAO orderDAO;
    ProductDAO productDAO;
    Scanner scanner;

    public OrderDetailServiceImp() {
        this.orderDetailDAO = new OrderDetailDAO();
        this.orderDAO = new OrderDAO();
        this.productDAO = new ProductDAO();
        this.scanner = new Scanner(System.in);
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
