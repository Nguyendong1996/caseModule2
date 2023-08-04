package model;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialUID = 12345678;
   private String city;
   private String District;
   private String ward;
   private String detail;

    public Address(String city, String district, String ward, String detail) {
        this.city = city;
        District = district;
        this.ward = ward;
        this.detail = detail;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", District='" + District + '\'' +
                ", ward='" + ward + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
