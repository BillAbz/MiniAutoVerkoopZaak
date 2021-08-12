package Entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.text.DecimalFormat;
import java.util.Date;

@Entity

public class Payment {
    @ManyToOne
    private Customer customerNumber;
    private int checkNumber;
    private Date paymentDate;
    private String pattern="#,###,###,###.00";
    private DecimalFormat amount = new DecimalFormat(pattern);

    public Payment() {
    }

    public Customer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Customer customerNumber) {
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

