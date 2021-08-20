package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable{


    @Id
    private int orderNumber;
    @Column(length = 15)
    private String productCode;
    private int quantityOrdered;
    @Transient
    private String pattern = "#,###,###,###.00";
    private DecimalFormat priceEach = new DecimalFormat(pattern);
    private int orderLineNumber;

    public OrderDetail() {
    }

    public int getOderNumber() {
        return orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public DecimalFormat getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(DecimalFormat priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }


    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "oderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }
}
