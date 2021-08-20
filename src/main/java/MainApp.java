import service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class MainApp {
    private static int choiceOne = 9;
    private static int choiceTwo = 9;
    private static boolean continueThis = true;

    public static void main(String[] args) throws SQLException, IOException {


        while (continueThis) {
            getChoice();
            choices();
        }
    }

    public static void getChoice() {
        Scanner scanner = new Scanner(System.in);

        while (choiceOne == 9) {
            System.out.println("What do you want to look at? \n (1)Customer\n (2)Employee\n (3)Office\n (4)Order\n " +
                    "(5)Order details\n (6)Payment\n (7)Product\n (8)Product line\n (0)Cancel");
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


    private static void choices() throws SQLException, IOException {
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
            } else if (choiceOne == 2) {

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
            } else if (choiceOne == 4) {

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
            } else if (choiceOne == 6) {

                switch (choiceTwo) {
                    case 1:
                        paymentService.showAllPayments();
                        break;
                    case 2:
                        paymentService.showPaymentByOrderNumber();
                        break;
                    case 3:
                        paymentService.createAPayment();
                        break;
                    case 4:
                        paymentService.updateAPayment();
                        break;
                    case 5:
                        paymentService.deleteAPayment();
                        break;
                }
            } else if (choiceOne == 7) {
                switch (choiceTwo) {
                    case 1:
                        productService.showAllProducts();
                        break;
                    case 2:
                        productService.showProductByProductNumber();
                        break;
                    case 3:
                        productService.createAProduct();
                        break;
                    case 4:
                        productService.updateAProduct();
                        break;
                    case 5:
                        productService.deleteAProduct();
                        break;
                }
            } else if (choiceOne == 8) {
                switch (choiceTwo) {
                    case 1:
                        productLineService.showAllProductlines();
                        break;
                    case 2:
                        productLineService.showProductByProductCode();
                        break;
                    case 3:
                        productLineService.createAProductLine();
                        break;
                    case 4:
                        productLineService.updateAProductLine();
                        break;
                    case 5:
                        productLineService.deleteAProductLine();
                        break;
                }
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
}






