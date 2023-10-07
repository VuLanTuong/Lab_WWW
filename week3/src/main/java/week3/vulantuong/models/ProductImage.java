package com.example.week2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productImage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private String path;
    private String alternative;


    public ProductImage( String path, String alternative) {
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage() {

    }
}
