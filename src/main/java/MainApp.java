import Entities.Costumer;
import service.CostumerService;
import service.EmployeeService;
import service.ProductService;

import java.util.Scanner;

public class MainApp {

    private Scanner scanner;
    public static final String MENU = "What do you want to look at?\n1: Customers\n2: Products\n3: Employees\n0: End";
    public static final String SUBMENU = "What do you want to look at? %n1: See all %n2: See id %n3: Add %n4: Update%n5: Delete %s %n0: End%n";

    private CostumerService costumerService;
    private EmployeeService employeeService;
    private ProductService productService;

    public static void main(String[] args) {

        MainApp mainApp = new MainApp();
        mainApp.run();
    }

    public MainApp() {
        this.scanner = new Scanner(System.in);
        this.costumerService = new CostumerService();
        this.productService = new ProductService();
        this.employeeService = new EmployeeService();
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
            case 2:
                printCustomerId();
                break;
            case 3:
                createCustomer();
                break;
            case 4:
                updateCustomer();
                break;
            case 5:
                deleteCustomer();
                break;
            default:
                break;
        }
    }

    private Costumer createCustomer() {
        Costumer customer = new Costumer();
        setCustomerInfo(customer);

        return customer;
    }

    private void printCustomerId() {
        Costumer customer = getCustomerById();
        System.out.println(customer);
    }

    private void updateCustomer() {
        Costumer customer = getCustomerById();

        if (customer == null) {
            System.err.println("Customer doesn't exist.");
        } else {
            setCustomerInfo(customer);
            costumerService.updateCustomer(customer); //todo updateCustomer is een methode die uit service komt
        }
    }

    private Costumer getCustomerById() {
        int id = scanner.nextInt();
        return costumerService.getCustomerById(id); //todo getCustomerById is de methode die uit service wordt gehaald
    }

    private void deleteCustomer() {
        Costumer customer = getCustomerById();
        costumerService.deleteCustomer(customer); //todo deleteCustomer is een methode die voorkomt uit de service
    }

    private void setCustomerInfo(Costumer customer) {
        System.out.println("Enter your first name:");
        String firstName = scanner.next();
        System.out.println("Enter your last name:");
        String lastName = scanner.next();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
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
//        Set<Employee> employeeSet = employeeService.getAllEmployees(); //todo: aanpassen van getAllEmployees naar het juiste
//        employeeSet.stream().forEach(System.out::println);
    }

    private void seeAllCustomers() {
//        Set<Costumer> customerSet = costumerService.getAllCustomers(); //todo: aanpassen van getAllCustomers naar het juiste
//        customerSet.stream().forEach(System.out::println);
    }

    private void seeAllProducts() {
//        Set<Product> productSet = productService.getAllProducts(); //todo: aanpassen van getAllProducts naar het juiste
//        productSet.stream().forEach(System.out::println);
    }


}


