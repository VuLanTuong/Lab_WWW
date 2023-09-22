package com.example.week2.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;
    private String description;
    private String unit;
    private String manufacturer_name;

    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus status;


    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList;


    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    public Product(){

    }

    public Product( String name, String description, String unit, String manufacturer_name, ProductStatus status, List<ProductImage> productImageList) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.productImageList = productImageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
