package Entities;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "payments")
@Table(name = "payments")
public class Payment {

    private int customerNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int checkNumber;
    private LocalDate paymentDate;
    @Transient
    private double amount;


    public Payment() {
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        String pattern = "#,###,###,###.00";
        DecimalFormat creditLimitFormat = new DecimalFormat(pattern);

        this.amount = Double.parseDouble(creditLimitFormat.format(amount));

    }
}

