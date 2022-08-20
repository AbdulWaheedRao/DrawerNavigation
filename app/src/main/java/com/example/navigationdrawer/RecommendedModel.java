package com.example.navigationdrawer;

public class RecommendedModel {
    String name;
    String description;
    String rating;
    String imag_url;

    public RecommendedModel() {
    }

    public RecommendedModel(String name, String description, String rating, String imag_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
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
}
