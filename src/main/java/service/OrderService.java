package service;

import DAO.EmployeeDAO;
import DAO.OrderDAO;
import Entities.Employee;
import Entities.Order;
import Entities.Product;
import Entities.ShippingStatus;
import net.bytebuddy.asm.Advice;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class OrderService {

    private OrderDAO orderDAO;
    private Scanner scanner;

    public OrderService() {
        orderDAO = new OrderDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllOrders() throws SQLException {
        if (orderDAO.getAllOrders() != null)
            orderDAO.getAllOrders().forEach(System.out::println);
        else
            System.out.println("No orders to show.");
    }

    public void showOrderByOrderNumber() throws SQLException {
        System.out.println("What is the id of the customer you want to lookup?");
        int input = scanner.nextInt();
        Order order =  orderDAO.getOrderByOrderNumber(input);
        if (order != null)
            System.out.println(order);
        else
            System.out.println("Id does not match any of the orders.");
    }


    public Order createAnOrder() {
        Order order = new Order();

        order.setOrderDate(LocalDate.now());

        System.out.println("please give the required date of delivering , xxxx-xx-xx");
        String requiredDate = scanner.nextLine();
        LocalDate requiredLocalDate = LocalDate.parse(requiredDate);

        boolean reqDateBeforeToday = true;
        while (reqDateBeforeToday) {
                if (requiredLocalDate.isBefore(LocalDate.now())) {
                     System.out.println("please enter a date that is after the current date");
                 } else {
                order.setRequiredDate(requiredLocalDate);
                reqDateBeforeToday = false;
                 }
        }

        order.setShippedDate(LocalDate.now());

        System.out.println("do you got any comments?");
        order.setComments(scanner.nextLine());

        System.out.println("please give your customernumber");
        order.setCustomerNumber(scanner.nextInt());

        order.setStatus(ShippingStatus.SHIPPED);

           return order;
      }


    public void updateAnOrder() {
        orderDAO.getAllOrders();

        System.out.println("Please enter the number of the order you wish to update");
        int orderNumber = scanner.nextInt();
        Order order = orderDAO.getOrderByOrderNumber(orderNumber);

        while (order == null) {
            System.err.println("Product doesn't exist. Please enter a valid id.");
            orderNumber = scanner.nextInt();
            order = orderDAO.getOrderByOrderNumber(orderNumber);
        }

        System.out.println("Please select an option: \n(1)required date of delivery\n(2)comments\n(3)customer number");
        int selection = scanner.nextInt();

        while (selection > 3 || selection < 0) {
            System.out.println("Please make a valid selection");
            selection = scanner.nextInt();
        }
        switch (selection) {
            default:
                break;
            case 1:
                System.out.println("please give the new required date of delivering , xxxx-xx-xx");
                String requiredDate = scanner.nextLine();
                LocalDate requiredLocalDate = LocalDate.parse(requiredDate);

                boolean reqDateBeforeToday = true;
                while (reqDateBeforeToday) {
                    if (requiredLocalDate.isBefore(LocalDate.now())) {
                        System.out.println("please enter a date that is after the current date");
                    } else {
                        order.setRequiredDate(requiredLocalDate);
                        reqDateBeforeToday = false;
                    }
                }
                System.out.println("Done.");
                break;
            case 2:
                System.out.println("please enter your comments");
                order.setComments(scanner.nextLine());
                System.out.println("Done.");
                break;
            case 3:
                System.out.println("please enter the new customer number");
                order.setCustomerNumber(scanner.nextInt());
                System.out.println("Done.");
                break;
        }
    }

    public void deleteAnOrder() {

    }

}
