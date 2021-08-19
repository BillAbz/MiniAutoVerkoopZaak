package service;

import DAO.EmployeeDAO;
import DAO.ProductDAO;
import Entities.Employee;
import Entities.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
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



    public Product createAProduct() throws SQLException {
        Product product = new Product ();
        System.out.println ("Enter Product Details:");
        String productName;
        boolean isUnique;
        do {
            isUnique = true;
            System.out.println ("Product name;");
            productName = scanner.nextLine ();
            for (Product product1 : productDAO.getAllProducts ()){
                if (product1.getProductName ().contentEquals (productName)) {
                    System.out.println ("Product name already exists.");
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        System.out.println ("Product line:");
        String productLine = scanner.nextLine ();
        product.setProductLine (productLine);
        System.out.println ("Product Scale:");
        String productScale = scanner.nextLine ();
        product.setProductScale (productScale);
        System.out.println ("Product Vendor:");
        String productVendor = scanner.nextLine ();
        product.setProductVendor (productVendor);
        System.out.println ("Product Description");
        String productDescription = scanner.nextLine ();
        product.setProductDescription (productDescription);
        System.out.println ("Quantity in Stock:");
        Integer quantityInStock = scanner.nextInt ();
        product.setQuantityInStock (quantityInStock);
        System.out.println ("Buy Price(###.##):");
        BigDecimal buyPrice = scanner.nextBigDecimal ();
        product.setBuyPrice (buyPrice);
        System.out.println ("MSRP(###.##)");
        BigDecimal msrp = scanner.nextBigDecimal ();
        product.setMSRP (msrp);

        productDAO.addProduct (product);


        return product;
    }

    public void updateAProduct() {

    }

    public void deleteAProduct() {

    }


}
