package com.example.week7_vulantuong.controller;

import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.models.ProductPrice;
import com.example.week7_vulantuong.services.ProductPriceService;
import com.example.week7_vulantuong.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPriceService productPriceService;


    @GetMapping("/list")
    public String findAll(Model model){
        List<Product> products = productService.findAll();

        List<ProductPriceMapping> mappings = new ArrayList<>();

        if(products != null){
            for(Product product : products){
                ProductPriceMapping productPriceMapping = handleMapping(product);
                    mappings.add(productPriceMapping);
                }
            }
        model.addAttribute("products", mappings);

//        System.out.println(mappings);

        return "customer/listing";


    }

    public ProductPriceMapping handleMapping(Product product) {
        if(product != null){
        Optional<ProductPrice> productPriceResult = productPriceService.findPriceByProductId(product.getProduct_id());
        if (productPriceResult.isPresent()) {
//                    System.out.print(productPriceResult.get() +" AND "+ product.getProduct_id());

            ProductPrice productPrice = productPriceResult.get();

            ProductPriceMapping productPriceMapping = new ProductPriceMapping();
            productPriceMapping.setPrice(productPrice.getPrice());


            productPriceMapping.setDescription(product.getDescription());
            productPriceMapping.setManufacturer(product.getManufacturer());
            productPriceMapping.setProduct_id(product.getProduct_id());
            productPriceMapping.setName(product.getName());
            productPriceMapping.setStatus(product.getStatus());
            productPriceMapping.setUnit(product.getUnit());

            return productPriceMapping;
        }
        }
        return null;
    }

    @GetMapping("cart")
    public String read(@RequestParam("id") long id, Model model){
        // Retrieve the product from the database
        Optional<Product> product = productService.findById(id);

        ProductPriceMapping productPriceMapping = handleMapping(product.get());
//
//        // Update the quantity of the product (e.g., increment by 1)
//        product.setQuantity(product.getQuantity() + 1);
//
//        // Save the updated product
//        productService.saveProduct(product);

        if(product.isPresent()){
            model.addAttribute("productPriceMapping", productPriceMapping);
            return "customer/cart";
        }

        return "customer/listing";
    }





}
