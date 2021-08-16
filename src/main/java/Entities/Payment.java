package Entities;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    private int customerNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int checkNumber;
    private Date paymentDate;
    @Transient
    private String pattern = "#,###,###,###.00";
    private DecimalFormat amount = new DecimalFormat(pattern);

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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public DecimalFormat getAmount() {
        return amount;
    }

    public void setAmount(DecimalFormat amount) {
        this.amount = amount;
    }
}

