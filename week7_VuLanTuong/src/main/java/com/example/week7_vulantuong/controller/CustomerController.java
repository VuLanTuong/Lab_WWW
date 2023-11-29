package com.example.week7_vulantuong.controller;

import com.example.week7_vulantuong.models.*;
import com.example.week7_vulantuong.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
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

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CartDetailService cartDetailService;
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
            return "customer/newcart";
        }

        return "customer/listing";
    }

    @GetMapping("/myCart")
    public String getMyCart(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");
        Cart cart = cartService.findByCustomerId(customer.getId());
         List<CartDetail> cartDetails = cart.getDetails();

         List<ProductPrice> prices = new ArrayList<>();

        double total = 0;

        for(CartDetail cartDetail : cartDetails){
             Product product = cartDetail.getProduct();
             Optional<ProductPrice> price = productPriceService.findPriceByProductId(product.getProduct_id());

             if(price.isPresent())
                 prices.add(price.get());
             total += cartDetail.getQuantity() * cartDetail.getPrice().getPrice();
         }

        session.setAttribute("details", cartDetails);
        model.addAttribute("prices", prices);
        model.addAttribute("total", total);





        model.addAttribute("details", cartDetails);

        return "customer/newcart";
    }


    @PostMapping("/addToCart")
    public String handleAddToCart(@RequestParam("quantity") String quantity,
                                  @RequestParam("productId") String productId,
                                  @RequestParam("price") String price,
                                  HttpServletRequest request){

        HttpSession session = request.getSession();
        Optional<Product> product = productService.findById(Long.valueOf(productId));
        if(product.isPresent()){
            Product product1 = product.get();
            ProductPriceMapping productPriceMapping = handleMapping(product1);

            request.setAttribute("product", product1);

            Customer customer = (Customer) session.getAttribute("user");

            CartDetail cartDetail = new CartDetail();

            Cart cart = cartService.findByCustomerId(customer.getId());

            cartDetail.setCart(cart);
            cartDetail.setQuantity(Integer.parseInt(quantity));
            cartDetail.setProduct(product1);

            Optional<ProductPrice> productPrice = productPriceService.findPriceByProductId(product1.getProduct_id());
            System.out.println(productPrice.get());
            productPrice.ifPresent(cartDetail::setPrice);


            System.out.println("CArtDEtail");
            System.out.println(cartDetail);

            cartDetailService.insert(cartDetail);

            return "redirect:/customer/list";


        }


        return null;

    }

    @PostMapping("/deleteCartDetail")
    public String deleteCartDetail(@RequestParam("productId") String productId){
            Optional<Product>  optionalProduct = productService.findById(Long.valueOf(productId));

            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                cartDetailService.deleteByProduct(product);
                return "redirect:/customer/myCart";
            }

        return "redirect:/customer/myCart";
    }


    @PostMapping("/checkout")
    public String handleCheckout(HttpServletRequest request){

        Employee employee = employeeService.findById(6);
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");
        Order order = new Order();

        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        List<OrderDetail> orderDetails = new ArrayList<>();

        Cart cart = cartService.findByCustomerId(customer.getId());
        List<CartDetail> cartDetails = cart.getDetails();


        for(CartDetail cartDetail : cartDetails){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setNote("");
            orderDetail.setProduct(cartDetail.getProduct());
            orderDetail.setPrice(cartDetail.getPrice().getPrice());
            orderDetail.setQuantity(cartDetail.getQuantity());

            orderDetails.add(orderDetail);
            cartDetailService.deleteByProduct(cartDetail.getProduct());

            System.out.println("DELETEEEEEEEEEEEE");
        }

        order.setOrderDetails(orderDetails);
        order.setEmployee(employee);



        orderService.insert(order);

        return "redirect:/customer/list";
    }

    @GetMapping("/myOrder")
    public String myOrder(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");

        List<Order> orders = orderService.findByCustomerId(customer.getId());
        model.addAttribute("orders", orders);
        return "customer/listOrder";
    }

}
