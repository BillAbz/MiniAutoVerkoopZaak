package service;

import DAO.CustomerDAO;
import DAO.PaymentDAO;

import java.util.Scanner;

public class PaymentService {

    PaymentDAO paymentDAO;
    CustomerDAO customerDAO;
    Scanner scanner;

    public PaymentService() {
        this.paymentDAO = new PaymentDAO();
        this.customerDAO = new CustomerDAO();
        this.scanner = new Scanner(System.in);

    }
}
