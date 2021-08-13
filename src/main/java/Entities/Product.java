package Entities;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.List;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productCode;
    private String productName;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private ProductLine productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private String pattern = "#,###,###,###.00";
    private DecimalFormat buyPrice = new DecimalFormat(pattern);
    private DecimalFormat MSRP = new DecimalFormat(pattern);

    public Product() {
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLine  getProductLine() {
        return productLine;
    }


    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public DecimalFormat getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(DecimalFormat buyPrice) {
        this.buyPrice = buyPrice;
    }

    public DecimalFormat getMSRP() {
        return MSRP;
    }

    public void setMSRP(DecimalFormat MSRP) {
        this.MSRP = MSRP;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLines='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                '}';
    }
}
