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
    private double priceEach;
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

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        String pattern = "#,###,###,###.00";
        DecimalFormat creditLimitFormat = new DecimalFormat(pattern);

        this.priceEach = Double.parseDouble(creditLimitFormat.format(priceEach));


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
