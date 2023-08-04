package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductSold implements Serializable {
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

    public ProductSold() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
