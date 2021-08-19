package service;

import DAO.ProductLineDAO;
import Entities.ProductLine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductLineService {

    private ProductLineDAO productLineDAO;
    private Scanner scanner;

    public ProductLineService() {
        productLineDAO = new ProductLineDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllProductlines() throws SQLException {
        if (productLineDAO.getAllProducts() != null)
            productLineDAO.getAllProducts().forEach(System.out::println);
        else
            System.out.println("No products to show.");

    }

    public void showProductByProductCode() throws SQLException {
        System.out.println("What is the id of the product you want to lookup?");
        String input = scanner.nextLine();
        ProductLine productLine = productLineDAO.getProductByProductCode(input);
        if (productLine != null)
            System.out.println(productLine);
        else
            System.out.println("Id does not match any of the Products.");
    }


    public ProductLine createAProductLine() throws IOException {
        ProductLine productLine = new ProductLine();
        String input;
        System.out.println("What is the productline called? ");
        input = scanner.nextLine();
        productLine.setProductLine(input);
        System.out.println("What is the HTML Description?");
        input = scanner.nextLine();
        productLine.setHtmlDescription(input);
        System.out.println("What is the Text Description?");
        input = scanner.nextLine();
        productLine.setTextDescription(input);
        System.out.println("What is the path of the image? Leave blank if you want to skip this.");
        String path = scanner.nextLine();
        if (path.length() > 3) {
            File file = new File(path);
            byte[] picInBytes = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
            productLine.setImage(picInBytes);
        }
        productLineDAO.addProductLines(productLine);
        return productLine;
    }

    public void updateAProductLine() throws IOException, SQLException {
        boolean done;
        showAllProductlines();
        System.out.println("What productline do you want to update? give the product line name:");
        String id = scanner.nextLine();
        ProductLine productLine = productLineDAO.getProductLinesByLine(id);
        if (productLine == null) {
            System.err.println("Productline doesn't exist.");
        } else {
            System.out.println("What would you like to update:\n");


            do {
                String updateMore;
                System.out.println("Please select an option: \n(1)Product line name\n(2)Text description\n(3)HTML Description\n(4)image\n(0)Cancel");
                int selection = scanner.nextInt();

                while (selection > 4 || selection < 0) {
                    System.out.println("Please make a valid selection");
                    selection = scanner.nextInt();
                }

                switch (selection) {
                    default:
                        break;
                    case 1:
                        System.out.println("Give the new name for the product line:");
                        productLine.setProductLine(scanner.nextLine());
                        System.out.println("Done.");
                        break;
                    case 2:
                        System.out.println("What is the new text description?");
                        productLine.setTextDescription(scanner.nextLine());
                        System.out.println("Done.");
                        break;
                    case 3:
                        System.out.println("What is the new HTML description?");
                        productLine.setHtmlDescription(scanner.nextLine());
                        System.out.println("Done.");
                        break;
                    case 4:
                        System.out.println("What is the path of the image? Leave blank if you want to skip this.");
                        String path = scanner.nextLine();
                        if (path.length() > 3) {
                            File file = new File(path);
                            byte[] picInBytes = new byte[(int) file.length()];
                            FileInputStream fileInputStream = new FileInputStream(file);
                            fileInputStream.read(picInBytes);
                            fileInputStream.close();
                            productLine.setImage(picInBytes);
                        }
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
            productLineDAO.updateProductLines(productLine);
        }
    }

    public void deleteAProductLine() throws SQLException {
        showAllProductlines();
        System.out.println("What productline do you want to update? give the product line name:");
        String id = scanner.nextLine();
        ProductLine productLine = productLineDAO.getProductLinesByLine(id);
        if (productLine == null) {
            System.err.println("Productline doesn't exist.");
        } else {
            productLineDAO.deleteProductLines(productLine);
        }
    }


}
