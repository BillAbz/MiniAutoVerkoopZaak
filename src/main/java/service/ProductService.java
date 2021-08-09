package service;

import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DAO.ProductLineDAO;

import java.util.Scanner;

public class ProductService {

    ProductDAO productDAO;
    ProductLineDAO productLineDAO;
    OrderDetailDAO orderDetailDAO;
    Scanner scanner;

    public ProductService() {
        this.productDAO = new ProductDAO();
        this.productLineDAO = new ProductLineDAO();
        this.orderDetailDAO = new OrderDetailDAO();
        this.scanner = new Scanner(System.in);
    }
}
