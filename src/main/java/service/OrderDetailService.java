package service;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import Entities.Order;
import Entities.OrderDetail;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class OrderDetailService {


    private OrderDetailDAO orderDetailDAO;
    private Scanner scanner;
    private OrderDAO orderDAO;
    private Order order;

    public OrderDetailService() {
        orderDetailDAO = new OrderDetailDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllOrderDetails() throws SQLException {
        if (orderDetailDAO.getAllOrderDetails() != null)
            orderDetailDAO.getAllOrderDetails().forEach(System.out::println);
        else
            System.out.println("No Orderdetails to show.");
    }

    public void showOrderDetailsByOrderNumber() throws SQLException { //TODO:: showOrder or showOrderDetails?? for now it has to be shown with an Order id so it's both
        System.out.println("What is the id of the OrderDetail you want to lookup?");
        int input = scanner.nextInt();
        order = orderDAO.getOrderByOrderNumber(input);
        OrderDetail orderDetail = orderDetailDAO.getProductByOrderNumber(order);
        if (orderDetail != null)
            System.out.println(orderDetail);
        else
            System.out.println("Id does not match any of the employees.");
    }


    public OrderDetail createAnOrderDetail() {
        OrderDetail orderDetail = new OrderDetail();

        System.out.println("Enter the OrderLineNumber pls:");
        int orderLineNumber = scanner.nextInt();
        System.out.println("Enter the Pattern for example:  '#,###,###,###.00'");
        String pattern = scanner.next();
        System.out.println("Enter Quantity Ordered:");
        int quantityOrdered = scanner.nextInt();
        System.out.println("And enter the ProductCode:");
        String productCode = scanner.next();


        DecimalFormat priceEach = new DecimalFormat(pattern);
        orderDetail.setOrderLineNumber(orderLineNumber);
        orderDetail.setPattern(pattern);
        orderDetail.setQuantityOrdered(quantityOrdered);
        orderDetail.setProductCode(productCode);
        orderDetail.setPriceEach(priceEach);
        orderDetailDAO.addOrderDetail(orderDetail);
        return new OrderDetail();
    }

    public void updateAnOrderDetail() {
        try {
            System.out.println("What is the id of the Order you want to lookup?");
            int input = scanner.nextInt();
            order = orderDAO.getOrderByOrderNumber(input);


            OrderDetail orderDetail = orderDetailDAO.getProductByOrderNumber(order);

            if (orderDetail != null) {
                System.out.println(orderDetail);
                System.out.println("Please select an option: \n(1)New OrderLineNumber\n(2)Set QuantityOrdered\n(3)New Pattern\n(4)Product Code\n(5)Price Each");

                int selection = scanner.nextInt();

                while (selection > 5 || selection < 0) {
                    System.out.println("Please make a valid selection");
                    selection = scanner.nextInt();
                }
                switch (selection) {
                    default:
                        break;
                    case 1:
                        System.out.println("Enter the new OrderLineNumber pls:");
                        int orderLineNumber = scanner.nextInt();
                        orderDetail.setOrderLineNumber(orderLineNumber);
                        break;
                    case 2:
                        System.out.println("Enter the new Quantity Ordered:");
                        int quantityOrdered = scanner.nextInt();
                        orderDetail.setQuantityOrdered(quantityOrdered);
                        break;
                    case 3:
                        System.out.println("Enter the new Pattern for example:  '#,###,###,###.00'");
                        String pattern = scanner.next();
                        orderDetail.setPattern(pattern);
                        break;
                    case 4:
                        System.out.println("Enter the New ProductCode:");
                        String productCode = scanner.next();
                        orderDetail.setProductCode(productCode);
                        break;
                    case 5:
                        System.out.println("Enter the new Price Each:");
                        String priceEach = scanner.next();
                        DecimalFormat decimalFormat = new DecimalFormat(priceEach);
                        orderDetail.setPriceEach(decimalFormat);
                        break;
                }
            } else
                System.out.println("Id does not match any of the payments.");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAnOrderDetail() {
        try {
            System.out.println("Choose OrderDetail you want to delete by id:");

            int input = scanner.nextInt();
            order = orderDAO.getOrderByOrderNumber(input);

            OrderDetail orderDetail = orderDetailDAO.getProductByOrderNumber(order);

            if (orderDetail == null)
                System.err.println("Exam doesn't exist.");
            else
                orderDetailDAO.deleteOrderDetail(orderDetail);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
