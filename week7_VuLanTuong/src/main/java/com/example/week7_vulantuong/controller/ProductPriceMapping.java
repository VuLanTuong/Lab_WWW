package com.example.week7_vulantuong.controller;

import com.example.week7_vulantuong.enums.ProductStatus;
import com.example.week7_vulantuong.models.OrderDetail;
import com.example.week7_vulantuong.models.ProductImage;
import com.example.week7_vulantuong.models.ProductPrice;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ProductPriceMapping {
    private long product_id;
    private String name;
    private String description;
    private String unit;
    private String manufacturer;
    private ProductStatus status;
    private double price;

    private int quantity;

    public ProductPriceMapping() {
    }

    public ProductPriceMapping(long product_id, String name, String description, String unit, String manufacturer, ProductStatus status, double price) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
        this.price = price;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductPriceMapping{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
