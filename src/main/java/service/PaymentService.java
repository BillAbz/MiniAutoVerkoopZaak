package service;

import Entities.Order;
import Entities.Payment;

import java.util.Set;

public interface PaymentService {

    void addPayment(Payment payment);

    Payment getPaymentById(long id);

    Set<Payment> getAllPayments();

    void updatePayment(Payment payment);

    void deletePayment(Payment payment);
}
