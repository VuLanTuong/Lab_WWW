package com.example.week7_vulantuong.controller;

import com.example.week7_vulantuong.models.Order;
import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.models.ProductPrice;
import com.example.week7_vulantuong.services.OrderService;
import com.example.week7_vulantuong.services.ProductPriceService;
import com.example.week7_vulantuong.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPriceService productPriceService;

    @Autowired
    private OrderService orderService;

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

        return "admin/listAdmin";


    }
    @GetMapping("update")
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
        }



        return "admin/update";
    }

    @PostMapping ("/submit")
    public String update(Model model, @ModelAttribute ProductPriceMapping productPrice){
        // Retrieve the product from the database
//        Optional<Product> product = productService.findById(id);

//        ProductPriceMapping productPriceMapping = handleMapping(product.get());


//
//        // Update the quantity of the product (e.g., increment by 1)
//        product.setQuantity(product.getQuantity() + 1);
//
//        // Save the updated product
//        productService.saveProduct(product);

//        if(product.isPresent()){
//            model.addAttribute("productPriceMapping", productPriceMapping);
//        }
        System.out.println(productPrice);

        Optional<Product> product = productService.findById(productPrice.getProduct_id());

        if(product.isPresent()){
           Product product1 = product.get();

           ProductPrice price = new ProductPrice(product1, LocalDateTime.now(), productPrice.getPrice(), "update");
           List<ProductPrice> prices = product1.getProductPrices();

           prices.add(price);
           product1.setName(productPrice.getName());
            product1.setDescription(productPrice.getDescription());
            product1.setStatus(productPrice.getStatus());
            product1.setManufacturer(productPrice.getManufacturer());
            product1.setUnit(productPrice.getUnit());
            product1.setProductPrices(prices);

            productService.save(product1);

        }

        return "redirect:/admin/list";
    }


    @GetMapping("/thongKeTheoNgay")
    public String thongKe(){

        return "admin/thongKeOrderTheoNgay";
    }


    @PostMapping ("/thongKeTheoNgay")
    public String thongKeTheoNgay(@RequestParam("date") String date, Model model){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate dt = LocalDate.parse(date,dateFormatter);


        List<Order> orders = orderService.findByOrderDate(dt.atStartOfDay());

        System.out.println("Orders" + orders);
        model.addAttribute("orders", orders);
        return "admin/thongKeOrderTheoNgay";

    }




    @GetMapping("/thongKeTheoNhanVien")
    public String thongKeTheoNhanVien(){

        return "admin/thongKeOrderTheoNhanVien";
    }

    @PostMapping ("/thongKeTheoNhanVien")
    public String thongKeNhanVien(@RequestParam("id") String id, Model model){
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        final LocalDate dt = LocalDate.parse(date,dateFormatter);


        List<Order> orders = orderService.findByEmployeeId(Long.parseLong(id));

        System.out.println("Orders" + orders);
        model.addAttribute("orders", orders);
        return "admin/thongKeOrderTheoNhanVien";

    }


}
