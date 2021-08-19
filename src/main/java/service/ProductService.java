package service;

import DAO.EmployeeDAO;
import DAO.ProductDAO;
import Entities.Employee;
import Entities.Product;

import java.io.File;
import java.io.FileInputStream;
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

    public void updateAProduct() throws SQLException {
        boolean done;
        productDAO.getAllProducts ();
        System.out.println ("Please enter the product code of the product you wish to update");
        String id = scanner.nextLine ();
        Product product = productDAO.getProductByProductCode (id);

        while (product == null){
            System.err.println ("Product doesn't exist. Please enter a valid id.");
            id = scanner.nextLine ();
            product = productDAO.getProductByProductCode (id);
        }
        System.out.println ("What would you like to update:\n");

        do {
            String updateMore;
            System.out.println ("Please select an option: \n(1)Product name\n(2)Product line\n(3)Product scale\n(4)Product vendor\n(5)Product description\n" +
                    "(6)Product buy price\n(7)Product MSRP\n(0)Cancel");
            int selection = scanner.nextInt ();

            while (selection > 7 || selection < 0) {
                System.out.println ("Please make a valid selection");
                selection = scanner.nextInt ();
            }

            switch (selection) {
                default:
                    break;
                case 1:
                    System.out.println ("Give the new name for the product name:");
                    product.setProductName (scanner.nextLine ());
                    System.out.println ("Done.");
                    break;
                case 2:
                    System.out.println ("What is the new Product line?");
                    product.setProductLine (scanner.nextLine ());
                    System.out.println ("Done.");
                    break;
                case 3:
                    System.out.println ("What is the new Product scale?");
                    product.setProductScale (scanner.nextLine ());
                    System.out.println ("Done.");
                    break;
                case 4:
                    System.out.println ("What is the new Product vendor?");
                    product.setProductVendor (scanner.nextLine ());
                    System.out.println ("Done.");
                    break;
                case 5:
                    System.out.println ("What is the new Product description?");
                    product.setProductDescription (scanner.nextLine ());
                    System.out.println ("Done.");
                    break;
                case 6:
                    System.out.println ("What is the new Product buy price?(###.##)");
                    product.setBuyPrice (scanner.nextBigDecimal ());
                    System.out.println ("Done.");
                    break;
                case 7:
                    System.out.println ("What is the new Product MSRP?(###.##)");
                    product.setMSRP (scanner.nextBigDecimal ());
                    System.out.println ("Done.");
                    break;
            }
            if (selection == 0)
                break;

            System.out.println("\nWould you like to update anything else?: Y/N");
            updateMore = scanner.next();
            while (!updateMore.equalsIgnoreCase("y") && !updateMore.equalsIgnoreCase("n")) {
                System.out.println("Would you like to update anything else?: ->Y/N<-");
                updateMore = scanner.next();
            }
            if (updateMore.equalsIgnoreCase("n")) {
                done = true;
            } else done = false;

        } while (!done);
        productDAO.updateProduct (product);

    }


    public void deleteAProduct() throws SQLException {
        showAllProducts ();
        System.out.println ("What product do you want delete? give the product code");
        String id = scanner.nextLine ();
        Product product = productDAO.getProductByProductCode (id);
        if (product == null) {
            System.err.println ("Product doesn't exist");
        } else {
            productDAO.deleteProduct (product);
            System.out.println (product.getProductName ()+ "is deleted.");
        }

    }


}
