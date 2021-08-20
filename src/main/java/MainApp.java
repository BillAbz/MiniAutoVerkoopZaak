import service.*;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class MainApp {
    private static int choiceOne = 9;
    private static int choiceTwo = 9;
    private static boolean continueThis = true;

    public static void main(String[] args) {


        while (continueThis) {
            getChoice();
            choices();
        }
    }

        public static void getChoice() {
            Scanner scanner = new Scanner(System.in);

            while (choiceOne == 9) {
                System.out.println("What do you want to look at? \n (1)Customer\n (2)Employee\n (3)Office\n (4)Order\n " +
                        " (5)Order details\n (6)Payment\n (7)Product\n (8)Product line\n (0)Cancel");
                choiceOne = scanner.nextInt();
                if (choiceOne == 0) break;
                if (choiceOne < 1 || choiceOne > 8) {
                    choiceOne = 9;
                    System.out.println("Invalid choice.");
                } else {
                    while (choiceTwo == 9) {
                        System.out.println("What do you want to look at? \n1: See All \n2: See One \n3: Add \n4: Edit \n5: Delete\n0: End");
                        choiceTwo = scanner.nextInt();
                        if (choiceTwo == 0) break;
                        if (choiceTwo < 1 || choiceTwo > 5) {
                            choiceTwo = 9;
                            System.out.println("Invalid choice.");
                        }
                    }
                }
            }

        }


        private static void choices() throws SQLException {
            Scanner scanner = new Scanner(System.in);
            CustomerService customerService = new CustomerService();
            EmployeeService employeeService = new EmployeeService();
            OfficeService officeService = new OfficeService();
            OrderService orderService = new OrderService();
            OrderDetailService orderDetailService = new OrderDetailService();
            PaymentService paymentService = new PaymentService();
            ProductService productService = new ProductService();
            ProductLineService productLineService = new ProductLineService();
            if (choiceTwo != 0)
                if (choiceOne == 1) {

                    switch (choiceTwo) {
                        case 1:
                            customerService.showAllCustomers();
                            break;
                        case 2:
                            customerService.showCustomerByCustomerNumber();
                            break;
                        case 3:
                            customerService.createACustomer();
                            break;
                        case 4:
                            customerService.updateACustomer();
                            break;
                        case 5:
                            customerService.deleteACustomer();
                            break;
                    }
                }
            else if (choiceOne == 2) {

                switch (choiceTwo) {
                    case 1:
                        employeeService.showAllEmployees();
                        break;
                    case 2:
                        employeeService.showEmployeeByEmployeeNumber();
                        break;
                    case 3:
                        employeeService.createAnEmployee();
                        break;
                    case 4:
                        employeeService.updateAnEmployee();
                        break;
                    case 5:
                        employeeService.deleteAnEmployee();
                        break;
                }
            } else if (choiceOne == 3) {

                switch (choiceTwo) {
                    case 1:
                        officeService.showAllOffices();
                        break;
                    case 2:
                        officeService.showOfficeByOfficeCode();
                        break;
                    case 3:
                        officeService.createAnOffice();
                        break;
                    case 4:
                        officeService.updateAnOffice();
                        break;
                    case 5:
                        officeService.deleteAnOffice();
                        break;
                }
            }
                else if (choiceOne == 4) {

                    switch (choiceTwo) {
                        case 1:
                            orderService.showAllOrders();
                            break;
                        case 2:
                            orderService.showOrderByOrderNumber();
                            break;
                        case 3:
                            orderService.createAnOrder();
                            break;
                        case 4:
                            orderService.updateAnOrder();
                            break;
                        case 5:
                            orderService.deleteAnOrder();
                            break;
                    }
                } else if (choiceOne == 5) {
                    switch (choiceTwo) {
                        case 1:
                            orderDetailService.showAllOrderDetails();
                            break;
                        case 2:
                            orderDetailService.showOrderDetailsByOrderNumber();
                            break;
                        case 3:
                            orderDetailService.createAnOrderDetail();
                            break;
                        case 4:
                            orderDetailService.updateAnOrderDetail();
                            break;
                        case 5:
                            orderDetailService.deleteAnOrderDetail();
                            break;
                    }
                }else if (choiceOne == 6) {

                    switch (choiceTwo) {
                        case 1:
                            paymentService.showAllPayments();
                            break;//see All Countries
                        case 2:
                            paymentService.showPaymentByOrderNumber();
                            break;//see One Country By Id
                        case 3:
                            countryService.addCountryWithoutCheck();
                            break;//add One new Country
                        case 4:
                            countryService.updateCountryWithoutCheck();
                            break;//edit One Country
                        case 5:
                            countryService.deleteACountry();
                            break;//delete One Country
                    }
                    System.out.println("We did a country thing!");


                } else if (choiceOne == 7) {
                    System.out.println("choise1value3");
                    switch (choiceTwo) {
                        case 1:
                            continentService.showAllContinents();
                            break;//see All Continents
                        case 2:
                            continentService.showContinentById();
                            break;//see One Continent By Id
                        case 3:
                            System.out.println("incase3");
                            continentService.insertAContinent();
                            break;//add One new Continent
                        case 4:
                            continentService.updateAContinent();
                            break;//edit One Continent
                        case 5:
                            continentService.deleteAContinent();
                            break;//delete One Continent
                    }
                    System.out.println("We did a continent thing!");
                }
            choiceOne = 9;
            choiceTwo = 9;

            boolean goodAnswer;
            do {
                System.out.println("Do you want to Try again? Y/N");
                String answer = scanner.next();
                if (answer.toUpperCase(Locale.ROOT).equals("N")) {
                    System.out.println("Bye!");
                    continueThis = false;
                    break;
                }
                if (!answer.toUpperCase(Locale.ROOT).equals("Y")) {
                    goodAnswer = false;
                    System.out.println(answer + " is not a good answer.");
                } else goodAnswer = true;
            } while (!goodAnswer);


        }






    boolean done;
        do {
            System.out.println("What do you want to do something with?\n (1)Customer\n (2)Employee\n (3)Office\n (4)Order\n " +
                    "(5)Order details\n (6)Payment\n (7)Product\n (8)Product line\n (0)Cancel\n");
            int choise = scanner.nextInt();
                    switch (choise){
                        case 0:
                            break;
                        case 1:

                    }
        }while (!done);

    }
/*
    private Scanner scanner;
    public static final String MENU = "What do you want to look at?\n1: Customers\n2: Products\n3: Employees\n4: Offices\n0: End";
    public static final String SUBMENU = "What do you want to look at? %n1: See all %n2: See id %n3: Add %n4: Update%n5: Delete %s %n0: End%n";

    private CustomerServiceImp costumerService;
    private EmployeeServiceImp employeeService;
    private ProductServiceImp productService;
    private OfficeService officeService;

    public static void main(String[] args) {

        MainApp mainApp = new MainApp();
        mainApp.run();
    }

    public MainApp() {
        this.scanner = new Scanner(System.in);
        this.costumerService = new CustomerServiceImp();
        this.productService = new ProductServiceImp();
        this.employeeService = new EmployeeServiceImp();
        this.officeService = new OfficeServiceImp();
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

        System.out.println("Employee first name:");
        String firstName = scanner.nextLine();
        System.out.println("Employee last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Extension:");
        String extension = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Office code:");
        int officeCode = scanner.nextInt();


        officeService.getOfficeById(officeCode);
        System.out.println("Reports to this Employee number:");

        int reportsTo = scanner.nextInt();


        Employee bossMan = new Employee();//todo ik denk dat we best al een vaste bossMan maken zodat we geen nieuwe moeten maken

        System.out.println("Job title:");
        String jobTitle = scanner.nextLine();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setExtension(extension);
        employee.setEmail(email);
//        employee.setReportsTo(bossMan.getEmployeeNumber());
        employee.setJobTitle(jobTitle);
        employeeService.addEmployee(employee);
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
*/

}


