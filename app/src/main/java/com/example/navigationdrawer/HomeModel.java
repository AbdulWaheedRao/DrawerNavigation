package com.example.navigationdrawer;

public class HomeModel {
    String name;
    String imag_url;
    String type;

    public HomeModel() {
    }

    public HomeModel(String name, String imag_url, String type) {
        this.name = name;
        this.imag_url = imag_url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
