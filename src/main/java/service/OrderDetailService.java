package service;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;

import java.util.Scanner;

public class OrderDetailService {

    OrderDetailDAO orderDetailDAO;
    OrderDAO orderDAO;
    ProductDAO productDAO;
    Scanner scanner;

    public OrderDetailService() {
        this.orderDetailDAO = new OrderDetailDAO();
        this.orderDAO = new OrderDAO();
        this.productDAO = new ProductDAO();
        this.scanner = new Scanner(System.in);
    }
}
