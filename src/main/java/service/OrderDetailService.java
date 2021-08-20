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

        System.out.println("Enter the OrderLineNumber pls: ");
        int orderLineNumber = scanner.nextInt();
        System.out.println("Enter a price for each: ");
        double priceEach = scanner.nextDouble();
        System.out.println("Enter Quantity Ordered: ");
        int quantityOrdered = scanner.nextInt();
        System.out.println("And enter the ProductCode: ");
        String productCode = scanner.next();



        orderDetail.setOrderLineNumber(orderLineNumber);
        orderDetail.setPriceEach(priceEach);
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
            orderDetail.setOrderNumber(order.getOrderNumber());
            if (orderDetail != null) {
                System.out.println(orderDetail);
                System.out.println("Please select an option: \n(1)New OrderLineNumber\n(2)Set QuantityOrdered\n(3)Product Code\n(4)Price Each");

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
                        System.out.println("Enter the New ProductCode:");
                        String productCode = scanner.next();
                        orderDetail.setProductCode(productCode);
                        break;
                    case 4:
                        System.out.println("Enter the new Price Each:");
                        double priceEach = scanner.nextDouble();
                        orderDetail.setPriceEach(priceEach);
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
