package com.example.navigationdrawer;

public class CategoryModel {
    String name;
    String description;
    String discount;
    String imag_url;

    public CategoryModel() {
    }

    public CategoryModel(String name, String description, String discount, String imag_url) {
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.imag_url = imag_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImag_url() {
        return imag_url;
    }

    public void setImag_url(String imag_url) {
        this.imag_url = imag_url;
    }
}
