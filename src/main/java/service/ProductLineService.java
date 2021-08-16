package service;

import DAO.ProductLineDAO;
import Entities.ProductLine;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductLineService {

    private ProductLineDAO productLineDAO;
    private Scanner scanner;

    public ProductLineService() {
        productLineDAO = new ProductLineDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllProducts() throws SQLException {
        if (productLineDAO.getAllProducts() != null)
            productLineDAO.getAllProducts().forEach(System.out::println);
        else
            System.out.println("No products to show.");
    }

    public void showProductByProductCode() throws SQLException {
        System.out.println("What is the id of the product you want to lookup?");
        String input = scanner.nextLine();
        ProductLine productLine =  productLineDAO.getProductByProductCode(input);
        if (productLine != null)
            System.out.println(productLine);
        else
            System.out.println("Id does not match any of the Products.");
    }


    public ProductLine createAProductLine() {
        return new ProductLine();
    }

    public void updateAProductLine() {

    }

    public void deleteAProductLine() {

    }


}
