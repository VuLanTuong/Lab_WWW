package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.models.ProductPrice;
import com.example.week7_vulantuong.repositories.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPriceService {

    @Autowired
    private ProductPriceRepository productPriceRepository;


    public Optional<ProductPrice> findPriceByProductId(long id){
        return productPriceRepository.findProductPriceByProductId(id);
    }
}
