package service;

import DAO.EmployeeDAO;
import DAO.OrderDetailDAO;
import Entities.Employee;
import Entities.OrderDetail;

import java.sql.SQLException;
import java.util.Scanner;

public class OrderDetailService {


    private OrderDetailDAO orderDetailDAO;
    private Scanner scanner;

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

    public void showOrderDetailsByOrderNumber() throws SQLException { //TODO:: showOrder or showOrderDetails??
      /*  System.out.println("What is the id of the customer you want to lookup?");
        int input = scanner.nextInt();
        OrderDetail orderDetail =  orderDetailDAO.getProductByOrderNumber(input);
        if (employee != null)
            System.out.println(employee);
        else
            System.out.println("Id does not match any of the employees.");

       */
    }


    public OrderDetail createAnOrderDetail() {
        return new OrderDetail();
    }

    public void updateAnOrderDetail() {

    }

    public void deleteAnOrderDetail() {

    }

}
