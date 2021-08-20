package service;

import DAO.PaymentDAO;
import Entities.Employee;
import Entities.Order;
import Entities.OrderDetail;
import Entities.Payment;

import java.io.File;
import java.io.FileInputStream;
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

    public void showAllPayments() throws SQLException {
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

        System.out.println("Enter the amount");
        double amount = scanner.nextDouble();


        LocalDate date = LocalDate.of(year,month,week);

        payment.setAmount(amount);
        payment.setPaymentDate(date);

        payment.setCustomerNumber(customerNumber); //todo is het setCheckNumber of setCustomerId
        paymentDAO.addPayment(payment);
        return new Payment();
    }

    public void updateAPayment() {
        System.out.println("What is the id of the payment you want to lookup?");
        int input = scanner.nextInt();
            Payment payment = null;
            try {
                payment = paymentDAO.getPaymentByCheckNumber(input);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (payment != null){
                System.out.println(payment);

                System.out.println("Please select an option: \n(1)New Date\n(2)Set Amount\n(3)Customer number");

                int selection = scanner.nextInt();

                while (selection > 3 || selection < 0) {
                    System.out.println("Please make a valid selection");
                    selection = scanner.nextInt();
                }

                switch (selection) {
                    default:
                        break;
                    case 1:
                        System.out.println("What is the new date?");
                        System.out.println("Enter the date year,month,week after you entered one press enter for the next.");
                        System.out.println("Year:");
                        int year =scanner.nextInt();
                        System.out.println("Month:");
                        int month = scanner.nextInt();
                        System.out.println("Week:");
                        int week = scanner.nextInt();
                        LocalDate date = LocalDate.of(year,month,week);
                        payment.setPaymentDate(date);
                        System.out.println("Done.");
                        break;
                    case 2:
                        System.out.println("What is the new Amount?");
                        double priceEach = scanner.nextDouble();
                        payment.setAmount(priceEach);
                        System.out.println("Done.");

                        break;

                    case 3:
                        System.out.println("What is the new CustomerNumber?");
                        int customerNumber = scanner.nextInt();
                        payment.setCustomerNumber(customerNumber);
                }
                paymentDAO.updatePayment(payment);

            }
        else
            System.out.println("Id does not match any of the payments.");
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
