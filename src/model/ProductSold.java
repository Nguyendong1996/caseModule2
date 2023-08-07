package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductSold implements Serializable {
    private static final long serialVersionUID = 123456789L;
    String nameProduct;
    String price;
    String quantity;
    LocalDateTime localDateTime ;

    public ProductSold(String nameProduct, String price, String quantity, LocalDateTime localDateTime) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.localDateTime = localDateTime;
    }

    public String getPrice() {
        return price;
    }
    public String getQuantity() {
        return quantity;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    @Override
    public String toString() {
        return "ProductSold{" +
                "nameProduct='" + nameProduct + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
