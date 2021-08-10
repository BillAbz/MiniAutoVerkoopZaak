package service;

import DAO.ProductDAO;
import DAO.ProductLineDAO;
import Entities.ProductLine;

import java.util.Scanner;
import java.util.Set;

public class ProductLineServiceImp implements ProductLineService {

    ProductLineDAO productLineDAO;
    ProductDAO productDAO;
    Scanner scanner;

    public ProductLineServiceImp() {
        this.productLineDAO = new ProductLineDAO();
        this.productDAO = new ProductDAO();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addProductLine(ProductLine payment) {

    }

    @Override
    public ProductLine getProductLineById(long id) {
        return null;
    }

    @Override
    public Set<ProductLine> getAllProductLines() {
        return null;
    }

    @Override
    public void updateProductLine(ProductLine payment) {

    }

    @Override
    public void deleteProductLine(ProductLine payment) {

    }
}
