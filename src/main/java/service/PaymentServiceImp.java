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
        paymentDAO.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return null; //todo DAO has to be finished
    }

    @Override
    public Set<Payment> getAllPayments() {
        return null; //todo DAO has to be finished
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDAO.updatePayment(payment);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentDAO.deletePayment(payment);
    }
}
