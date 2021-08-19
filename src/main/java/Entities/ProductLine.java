package Entities;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;

@Entity
@Table(name = "product_lines")
public class ProductLine {
    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    @Lob
    private byte[] image;

    public ProductLine() {
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
