import Entities.Customer;
import Entities.Employee;
import Entities.Product;
import service.CustomerServiceImp;
import service.EmployeeServiceImp;
import service.ProductServiceImp;

import java.util.Scanner;
import java.util.Set;

public class MainApp {

    private Scanner scanner;
    public static final String MENU = "What do you want to look at?\n1: Customers\n2: Products\n3: Employees\n4: Offices\n0: End";
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
                case 4:
                    officeMenu();
                case 0:
                    System.exit(0);
                    return;
                default:
                    break;
            }
        }
    }

    private void officeMenu() {
        System.out.printf(SUBMENU, "");
        int subMenuChoice = scanner.nextInt();
        switch (subMenuChoice) {
            case 1:
                seeAllOffices();
                break;
            case 2:
                printOfficeById();
                break;
            case 3:
                createOffice();
                break;
            case 4:
                updateOffice();
                break;
            case 5:
                deleteOffice();
                break;
            default:
                break;
        }
    }

    private void seeAllOffices() {
    }

    private void printOfficeById() {
    }

    private void createOffice() {
    }

    private void updateOffice() {
    }

    private void deleteOffice() {
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

    private void printCustomerId() {
        int id = scanner.nextInt();
        Customer customer = costumerService.getCustomerById(id);
        System.out.println(customer);
    }

    private void createCustomer() {
        Customer customer = new Customer();

        System.out.println("Enter Customer Details:");

        System.out.println("Customer Name:");
        String customerName = scanner.nextLine();
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("PhoneNumber (Only numbers):");
        String phone = scanner.nextLine();
        System.out.println("AddressLine1:");
        String addressLine1 = scanner.nextLine();
        System.out.println("AddressLine2:");
        String addressLine2 = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("State:");
        String state = scanner.nextLine();
        System.out.println("PostalCode:");
        String postalCode = scanner.nextLine();
        System.out.println("Country:");
        String country = scanner.nextLine();

        customer.setCustomerName(customerName);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setAddressLine1(addressLine1);
        customer.setAddressLine2(addressLine2);
        customer.setCity(city);
        customer.setState(state);
        customer.setPostalCode(postalCode);
        customer.setCountry(country);

        costumerService.addCustomer(customer);
    }

    private void updateCustomer() {
        int id = scanner.nextInt();
        Customer customer = costumerService.getCustomerById(id);

        if (customer == null) {
            System.err.println("Customer doesn't exist.");
        } else {
            System.out.println("Enter Customer Details:");

            System.out.println("Customer Name:");
            String customerName = scanner.nextLine();
            System.out.println("First Name:");
            String firstName = scanner.nextLine();
            System.out.println("Last Name:");
            String lastName = scanner.nextLine();
            System.out.println("PhoneNumber (Only numbers):");
            String phone = scanner.nextLine();
            System.out.println("AddressLine1:");
            String addressLine1 = scanner.nextLine();
            System.out.println("AddressLine2:");
            String addressLine2 = scanner.nextLine();
            System.out.println("City:");
            String city = scanner.nextLine();
            System.out.println("State:");
            String state = scanner.nextLine();
            System.out.println("PostalCode:");
            String postalCode = scanner.nextLine();
            System.out.println("Country:");
            String country = scanner.nextLine();

            customer.setCustomerName(customerName);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhone(phone);
            customer.setAddressLine1(addressLine1);
            customer.setAddressLine2(addressLine2);
            customer.setCity(city);
            customer.setState(state);
            customer.setPostalCode(postalCode);
            customer.setCountry(country);

            costumerService.updateCustomer(customer);
        }
    }

    private void deleteCustomer() {
        int id = scanner.nextInt();
        Customer customer = costumerService.getCustomerById(id);

        costumerService.deleteCustomer(customer);
    }

    private void productsMenu() {
        System.out.printf(SUBMENU, "");
        int subMenuChoice = scanner.nextInt();
        switch (subMenuChoice) {
            case 1:
                seeAllProducts();
                break;
            case 2:
                printProductById();
                break;
            case 3:
                createProduct();
                break;
            case 4:
                updateProduct();
                break;
            case 5:
                deleteProduct();
                break;
            default:
                break;
        }
    }

    private void printProductById() {

        int id = scanner.nextInt();
        Product product = productService.getProductById(id);
        System.out.println(product);

    }

    private void createProduct() {

    }

    private void updateProduct() {

    }

    private void deleteProduct() {

    }

    private void employeeMenu() {
        System.out.printf(SUBMENU, "");
        int subMenuChoice = scanner.nextInt();
        switch (subMenuChoice) {
            case 1:
                seeAllEmployees();
                break;
            case 2:
                printEmployeeById();
                break;
            case 3:
                createEmployee();
                break;
            case 4:
                updateEmployee();
                break;
            case 5:
                deleteEmployee();
                break;
//            case 6:
//                addEmployeeToOffice(); //todo extra van op de lijst / Trello voor de "Client" maar kan misschien bij CreateEmployee of Update gebeuren.
            default:
                break;
        }
    }

    private void seeAllEmployees() {
        Set<Employee> employeeSet = employeeService.getAllEmployees();
        employeeSet.stream().forEach(System.out::println);
    }

    private void printEmployeeById() {
        int id = scanner.nextInt();
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println(employee);

    }
    private void createEmployee() {
        Employee employee = new Employee();

        System.out.println("Enter Employee Details:");




    }
    private void updateEmployee() {

    }

    private void deleteEmployee() {

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


