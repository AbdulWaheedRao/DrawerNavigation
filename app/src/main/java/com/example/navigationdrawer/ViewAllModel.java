package com.example.navigationdrawer;

public class ViewAllModel {

    private String name;
    private String description;
    private long price;
    private String rating;
    private String imag_url;
    private String type;

    public ViewAllModel() {
    }

    public ViewAllModel(String name, String description, long price, String rating, String imag_url, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.imag_url = imag_url;
        this.type = type;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImag_url() {
        return imag_url;
    }

    public void setImag_url(String imag_url) {
        this.imag_url = imag_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
