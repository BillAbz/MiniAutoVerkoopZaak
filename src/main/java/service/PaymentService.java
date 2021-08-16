package service;

import DAO.PaymentDAO;
import Entities.Employee;
import Entities.Payment;

import java.sql.SQLException;
import java.util.Scanner;

public class PaymentService {


    private PaymentDAO paymentDAO;
    private Scanner scanner;

    public PaymentService() {
        paymentDAO = new PaymentDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllEmployees() throws SQLException {
        if (paymentDAO.getAllPayments() != null)
            paymentDAO.getAllPayments().forEach(System.out::println);
        else
            System.out.println("No Payments to show.");
    }

    public void showPaymentByOrderNumber() throws SQLException {
        System.out.println("What is the id of the payment you want to lookup?");
        int input = scanner.nextInt();
        Payment payment =  paymentDAO.getPaymentByCheckNumber(input);
        if (payment != null)
            System.out.println(payment);
        else
            System.out.println("Id does not match any of the payments.");
    }


    public Payment createAPayment() {
        return new Payment();
    }

    public void updateAPayment() {

    }

    public void deleteAPayment() {

    }

}
