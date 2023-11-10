package com.example.week2.controller;

import com.example.week2.models.*;
import com.example.week2.repositories.*;
import com.example.week2.services.CustomerService;
import com.example.week2.services.EmployeeService;
import com.example.week2.services.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@WebServlet(name="week2",value = "/week2")
public class ControlServlet extends HttpServlet {

    private CustomerService customerService;
    private ProductService productService;

    private ProductPriceRepository productPriceRepository;

    private CartRepository cartRepository;

    private CartDetailRepository cartDetailRepository;

    private OrderRepository orderRepository;

    private EmployeeService employeeService;


    public ControlServlet() {
        customerService = new CustomerService();
        productService = new ProductService();
        productPriceRepository = new ProductPriceRepository();
        cartDetailRepository = new CartDetailRepository();
        orderRepository = new OrderRepository();
        employeeService = new EmployeeService();
    }

    @Override
    public void init() throws ServletException {
        log.info("init() called");
        customerService = new CustomerService();
        productService = new ProductService();
        productPriceRepository = new ProductPriceRepository();
        cartRepository = new CartRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action")  ;
        switch (action){
            case "dashboard":
                handleDashboard(request, response);
            case "myCart":
                handleMyCart(request, response);
        }

    }

    private void handleMyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = cartRepository.findById(customer.getId());

        List<CartDetail> details = cart.getDetails();
        List<ProductPrice> productPrices = new ArrayList<>();
        for(CartDetail cartDetail : details){
            Product product = cartDetail.getProduct();
            Optional<ProductPrice> price = productPriceRepository.findByProduct(product.getProduct_id());

            if(price.isPresent()){
                productPrices.add(price.get());
            }

        }

        session.setAttribute("details", details);
        request.setAttribute("details", details);
        request.setAttribute("prices", productPrices);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
            requestDispatcher.forward(request, response);




    }

    private void handleDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.getAll();

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = cartRepository.findById(customer.getId());

        List<CartDetail> details = cart.getDetails();

        session.setAttribute("details", details);
        List<ProductPriceMapping> mappings = new ArrayList<>();

        for(Product product : list){
            ProductPriceMapping productPriceMapping = handleMapping(product);
            mappings.add(productPriceMapping);
        }


        request.setAttribute("products", mappings);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
        requestDispatcher.forward(request, response);
    }

    public ProductPriceMapping handleMapping(Product product) {
        if(product != null){
            Optional<ProductPrice> productPriceResult = productPriceRepository.findByProduct(product.getProduct_id());
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                handleLogin(request, response);
            case "addToCart":
                handleAddToCart(request, response);
            case "insert":
                handleInsertCart(request, response);
    }}

    private void handleInsertCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
            HttpSession session = request.getSession();
            List<Product> products = (List<Product>) session.getAttribute("products");
            Customer customer = (Customer) session.getAttribute("customer");
            List<CartDetail> details = (List<CartDetail>) session.getAttribute("details");
            List<OrderDetail> orderDetails = new ArrayList<>();
            Optional<Employee> employee = employeeService.findById(1L);
            Employee employee1 = new Employee();
            System.out.println("DETAIL" + details);
            if(employee.isPresent()){
                employee1 = employee.get();
            }

        Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();
        if(details != null) {
            for (CartDetail cartDetail : details) {
                ProductPriceRepository productPriceRepository = new ProductPriceRepository();
                Optional<ProductPrice> price = productPriceRepository.findByProduct(cartDetail
                        .getProduct().getProduct_id());
                ProductPrice productPrice = new ProductPrice();

                if (price.isPresent()) {
                    productPrice = price
                            .get();
                }
                orderDetail.setNote("");
                orderDetail.setOrder(order);
                orderDetail.setPrice(productPrice.getPrice());
                orderDetail.setQuantity(cartDetail.getQuantity());
                orderDetail.setProduct(cartDetail.getProduct());
                orderDetails.add(orderDetail);
            }
            order.setCustomer(customer);
            order.setOrderDate(LocalDateTime.now());
            order.setOrderDetails(orderDetails);
            order.setEmployee(employee1);

            orderRepository.insert(order);
            System.out.println("insert");
            response.sendRedirect("/week2?action=dashboard");

        }



    }

    private void handleAddToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String quantity = request.getParameter("quantity");
        System.out.println(productId);
        System.out.println(quantity);

        HttpSession session = request.getSession();
        if(productId != null && quantity != null ) {
            System.out.println("hi");

            Product product = productService.findById(Long.parseLong(productId));

            ProductPriceMapping mapping = handleMapping(product);

            request.setAttribute("product", product);
            Customer customer = (Customer) session.getAttribute("customer");

            CartDetail cartDetail = new CartDetail();

            Cart cart = cartRepository.findById(customer.getId());

            cartDetail.setCart(cart);
            cartDetail.setQuantity(Integer.parseInt(quantity));
            cartDetail.setProduct(product);

            cartDetailRepository.insert(cartDetail);

//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
//            requestDispatcher.forward(request, response);
                response.sendRedirect("/week2?action=dashboard");

        }

    }


    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Optional<Customer> customer = customerService.findAccount(email, password);

        if(customer.isPresent()){
            Customer customer1 = customer.get();
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer1 );
            response.sendRedirect("/week2?action=dashboard");
            return;
        }


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    public void destroy() {
        log.info("destroy() called");
    }
}


