package service;

import DAO.ProductDAO;
import DAO.ProductLineDAO;

import java.util.Scanner;

public class ProductLineService {

    ProductLineDAO productLineDAO;
    ProductDAO productDAO;
    Scanner scanner;

    public ProductLineService() {
        this.productLineDAO = new ProductLineDAO();
        this.productDAO = new ProductDAO();
        this.scanner = new Scanner(System.in);
    }
}
