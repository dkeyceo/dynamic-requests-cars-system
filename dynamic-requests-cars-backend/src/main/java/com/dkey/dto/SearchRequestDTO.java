package com.dkey.dto;

public class SearchRequestDTO {
    private String brand;
    private String model;
    private String version;
    private String changed;
    private String color;
    private Integer kmFrom;
    private Integer kmTo;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getKmFrom() {
        return kmFrom;
    }

    public void setKmFrom(Integer kmFrom) {
        this.kmFrom = kmFrom;
    }

    public Integer getKmTo() {
        return kmTo;
    }

    public void setKmTo(Integer kmTo) {
        this.kmTo = kmTo;
    }
}
