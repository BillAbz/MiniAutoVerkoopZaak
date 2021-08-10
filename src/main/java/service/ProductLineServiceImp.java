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
    public void addProductLine(ProductLine productLine) {
        productLineDAO.addProductLines(productLine);
    }

    @Override
    public ProductLine getProductLineById(long id) {
        return null; //todo DAO has to be finished

    }

    @Override
    public Set<ProductLine> getAllProductLines() {
        return null; //todo DAO has to be finished

    }

    @Override
    public void updateProductLine(ProductLine productLine) {
        productLineDAO.updateProductLines(productLine);
    }

    @Override
    public void deleteProductLine(ProductLine productLine) {
        productLineDAO.deleteProductLines(productLine);
    }
}
