package model;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 123456789L;
    public static int INDEX = 0;
   private int id;
   private String nameProduct;
   private String price;
   private String quantity;
   private String color;
    private Category category;
    public Product( String nameProduct, String price, String quantity, String color,Category category) {
        this.id = ++INDEX;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category =category;
    }
    public int getId() {
        return id;
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

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", color='" + color + '\'' +
                ", Category='" + category + '\'' +
                '}';
//        return String.format("%-15d%-30s%-25s%-20s%-15s",this.id,this.nameProduct,this.price,this.quantity,this.category);
        }
}
