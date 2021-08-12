import Entities.*;
import service.CustomerServiceImp;
import service.EmployeeServiceImp;
import service.ProductServiceImp;

import java.util.Scanner;
import java.util.Set;

public class MainApp {

    private Scanner scanner;
    public static final String MENU = "What do you want to look at?\n1: Customers\n2: Products\n3: Employees\n0: End";
    public static final String SUBMENU = "What do you want to look at? %n1: See all %n2: See id %n3: Add %n4: Update%n5: Delete %s %n0: End%n";

    private CustomerServiceImp costumerService;
    private EmployeeServiceImp employeeService;
    private ProductServiceImp productService;

    public static void main(String[] args) {

        MainApp mainApp = new MainApp();
        mainApp.run();
    }

    public MainApp() {
        this.scanner = new Scanner(System.in);
        this.costumerService = new CustomerServiceImp();
        this.productService = new ProductServiceImp();
        this.employeeService = new EmployeeServiceImp();
    }

    private void mainMenu() {
        while (true) {
            System.out.println(MENU);
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    productsMenu();
                    break;
                case 3:
                    employeeMenu();
                    break;
                case 0:
                    System.exit(0);
                    return;
                default:
                    break;
            }
        }
    }


    private void run() {
        try {
            mainMenu();
        } finally {
            scanner.close();
        }
    }

    private void customerMenu() {
        System.out.printf(SUBMENU, "");
        int subMenuChoice = scanner.nextInt();
        switch (subMenuChoice) {
            case 1:
                seeAllCustomers();
                break;
//            case 2:
//                printCustomerId();
//                break;
//            case 3:
//                createCustomer();
//                break;
//            case 4:
//                updateCustomer();
//                break;
//            case 5:
//                deleteCustomer();
//                break;
            default:
                break;
        }
    }

    private void productsMenu() {
        System.out.printf(SUBMENU, "");
        int subMenuChoice = scanner.nextInt();
        switch (subMenuChoice) {
            case 1:
                seeAllProducts();
                break;
            default:
                break;
        }
    }

    private void employeeMenu() {
        System.out.printf(SUBMENU, "");
        int subMenuChoice = scanner.nextInt();
        switch (subMenuChoice) {
            case 1:
                seeAllEmployees();
                break;
            default:
                break;
        }
    }

    private void seeAllEmployees() {
        Set<Employee> employeeSet = employeeService.getAllEmployees();
        employeeSet.stream().forEach(System.out::println);
    }

    private void seeAllCustomers() {
        Set<Customer> customerSet = costumerService.getAllCustomers();
        customerSet.stream().forEach(System.out::println);
    }

    private void seeAllProducts() {
        Set<Product> productSet = productService.getAllProduct();
        productSet.stream().forEach(System.out::println);
    }


}


