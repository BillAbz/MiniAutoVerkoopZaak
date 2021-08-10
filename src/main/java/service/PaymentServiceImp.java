package service;

import DAO.CustomerDAO;
import DAO.PaymentDAO;
import Entities.Payment;

import java.util.Scanner;
import java.util.Set;

public class PaymentServiceImp implements PaymentService {

    PaymentDAO paymentDAO;
    CustomerDAO customerDAO;
    Scanner scanner;

    public PaymentServiceImp() {
        this.paymentDAO = new PaymentDAO();
        this.customerDAO = new CustomerDAO();
        this.scanner = new Scanner(System.in);

    }

    @Override
    public void addPayment(Payment payment) {

    }

    @Override
    public Payment getPaymentById(long id) {
        return null;
    }

    @Override
    public Set<Payment> getAllPayments() {
        return null;
    }

    @Override
    public void updatePayment(Payment payment) {

    }

    @Override
    public void deletePayment(Payment payment) {

    }
}
