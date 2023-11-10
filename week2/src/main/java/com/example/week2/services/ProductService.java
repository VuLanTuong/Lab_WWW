package com.example.week2.services;

import com.example.week2.models.Product;
import com.example.week2.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService() {
        repository = new ProductRepository();
    }

    public List<Product> getAll(){
        return repository.getAll();
    }

    public Product findById(long id){
        return repository.findById(id);
    }
}
