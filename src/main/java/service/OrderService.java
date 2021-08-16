package service;

import DAO.EmployeeDAO;
import DAO.OrderDAO;
import Entities.Employee;
import Entities.Order;

import java.sql.SQLException;
import java.util.Scanner;

public class OrderService {

    private OrderDAO orderDAO;
    private Scanner scanner;

    public OrderService() {
        orderDAO = new OrderDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllOrders() throws SQLException {
        if (orderDAO.getAllOrders() != null)
            orderDAO.getAllOrders().forEach(System.out::println);
        else
            System.out.println("No orders to show.");
    }

    public void showOrderByOrderNumber() throws SQLException {
        System.out.println("What is the id of the customer you want to lookup?");
        int input = scanner.nextInt();
        Order order =  orderDAO.getOrderByOrderNumber(input);
        if (order != null)
            System.out.println(order);
        else
            System.out.println("Id does not match any of the orders.");
    }


    public Order createAnOrder() {
        return new Order();
    }

    public void updateAnOrder() {

    }

    public void deleteAnOrder() {

    }

}
