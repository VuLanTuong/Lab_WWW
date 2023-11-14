package com.example.week7_vulantuong.controller;

import com.example.week7_vulantuong.models.Customer;
import com.example.week7_vulantuong.models.Employee;
import com.example.week7_vulantuong.services.CustomerService;
import com.example.week7_vulantuong.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneralController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String login(){
        return "customer/login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request){
        HttpSession session = request.getSession();

        Customer customer = customerService.findByEmailAndPassword(email, password);

        Employee employee = employeeService.findByEmailAndPassword(email, password);


        if(customer != null){
            session.setAttribute("user", customer);
            return "redirect:customer/list";
        }
        if(employee != null){
            session.setAttribute("user", employee);
            return "redirect:admin/list";
        }
        return "customer/login";
    }

}
