package model;

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialUID = 12345678;
    String nameCategory;

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "nameCategory='" + nameCategory + '\'';
    }
}
