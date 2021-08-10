package service;

import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DAO.ProductLineDAO;
import Entities.Product;

import java.util.Scanner;
import java.util.Set;

public class ProductServiceImp implements ProductService {

    ProductDAO productDAO;
    ProductLineDAO productLineDAO;
    OrderDetailDAO orderDetailDAO;
    Scanner scanner;

    public ProductServiceImp() {
        this.productDAO = new ProductDAO();
        this.productLineDAO = new ProductLineDAO();
        this.orderDetailDAO = new OrderDetailDAO();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Set<Product> getAllProduct() {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
