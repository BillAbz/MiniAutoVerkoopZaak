package Entities;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int detailId;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private Order oderNumber;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private Product productCode;
    private int quantityOrdered;
    private String pattern = "#,###,###,###.00";
    private DecimalFormat priceEach = new DecimalFormat(pattern);
    private int orderLineNumber;

    public OrderDetail() {
    }

    public Order getOderNumber() {
        return oderNumber;
    }

    public Product getProductCode() {
        return productCode;
    }

    public void setProductCode(Product productCode) {
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

    @Override
    public String toString() {
        return "OrderDetail{" +
                "oderNumber=" + oderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }
}
