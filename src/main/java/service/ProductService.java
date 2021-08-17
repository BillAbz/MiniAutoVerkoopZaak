package service;

import DAO.EmployeeDAO;
import DAO.ProductDAO;
import Entities.Employee;
import Entities.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {

    private ProductDAO productDAO;
    private Scanner scanner;

    public ProductService() {
        productDAO = new ProductDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllProducts() throws SQLException {
        if (productDAO.getAllProducts() != null)
            productDAO.getAllProducts().forEach(System.out::println);
        else
            System.out.println("No products to show.");
    }

    public void showProductByProductNumber() throws SQLException {
        System.out.println("What is the id of the product you want to lookup?");
        String input = scanner.nextLine();
        Product product =  productDAO.getProductByProductCode(input);
        if (product != null)
            System.out.println(product);
        else
            System.out.println("Id does not match any of the products.");
    }



    public Product createAProduct() {
        return new Product();
    }

    public void updateAProduct() {

    }

    public void deleteAProduct() {

    }


}
