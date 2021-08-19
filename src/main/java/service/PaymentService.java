package service;

import DAO.PaymentDAO;
import Entities.Employee;
import Entities.OrderDetail;
import Entities.Payment;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
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
        Payment payment = new Payment();

        System.out.println("Enter CustomerNumber:");
        int customerNumber = scanner.nextInt();

        System.out.println("Enter the date year,month,week after you entered one press enter for the next.");
        System.out.println("Year:");
        int year =scanner.nextInt();
        System.out.println("Month:");
        int month = scanner.nextInt();
        System.out.println("Week:");
        int week = scanner.nextInt();

        System.out.println("Enter the Pattern");
        String pattern = scanner.nextLine();


        LocalDate date = LocalDate.of(year,month,week);

        DecimalFormat priceEach = new DecimalFormat(pattern);
        payment.setPaymentDate(date);
        payment.setPattern(pattern);
        payment.setAmount(priceEach);
        payment.setCustomerNumber(customerNumber); //todo is het setCheckNumber of setCustomerId
        paymentDAO.addPayment(payment);
        return new Payment();
    }

    public void updateAPayment() {
        try {
            System.out.println("What is the checkNumber of the Payment you want to change?");

            int input = scanner.nextInt();
            Payment payment = paymentDAO.getPaymentByCheckNumber(input);
            if (payment != null) {
                System.out.println(payment);

                System.out.println("Enter CustomerNumber:");
                int customerNumber = scanner.nextInt();

                System.out.println("Enter the date year,month,week after you entered one press enter for the next.");
                System.out.println("Year:");
                int year =scanner.nextInt();
                System.out.println("Month:");
                int month = scanner.nextInt();
                System.out.println("Week:");
                int week = scanner.nextInt();

                System.out.println("Enter the Pattern");
                String pattern = scanner.nextLine();

                LocalDate date = LocalDate.of(year,month,week);
                DecimalFormat priceEach = new DecimalFormat(pattern);
                payment.setPaymentDate(date);
                payment.setPattern(pattern);
                payment.setAmount(priceEach);
                payment.setCustomerNumber(customerNumber); //todo is het setCheckNumber of setCustomerId

                paymentDAO.updatePayment(payment);
            } else
                System.out.println("Id does not match any of the employees.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAPayment() {
        try {
            System.out.println("Choose Payment you want to delete by id:");

            int input = scanner.nextInt();
            Payment payment = paymentDAO.getPaymentByCheckNumber(input);

            if (payment == null)
                System.err.println("Payment doesn't exist.");
            else
                paymentDAO.deletePayment(payment);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
