package com.example.week7_vulantuong;

import com.example.week7_vulantuong.enums.ProductStatus;
import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.models.ProductPrice;
import com.example.week7_vulantuong.repositories.ProductRepository;
import com.example.week7_vulantuong.services.ProductService;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Week7VuLanTuongApplication {
    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Week7VuLanTuongApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            Faker faker = new Faker();
//            Random rnd = new Random();
//            Device device = faker.device();
//            for (int i = 0; i < 19; i++) {
//                Product product = new Product(
//                        ((Device) device).modelName(),
//                        faker.lorem().paragraph(3),
//                        "piece",
//                        device.manufacturer(),
//                        ProductStatus.ACTIVE
//                );
//                productService.save(product);
//            }
//        };
//
//    }
}
