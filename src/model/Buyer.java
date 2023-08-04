package model;

import java.io.Serializable;

public class Buyer implements Serializable {
    private static final long serialUID = 12345678;
   private String name;
   private String numberPhone;
   private Address address;
   private String nameProduct;
   private String quantity;
   private String price;


    public Buyer(String name, String numberPhone, Address address, String nameProduct, String quantity, String price) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public Buyer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", address=" + address +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
