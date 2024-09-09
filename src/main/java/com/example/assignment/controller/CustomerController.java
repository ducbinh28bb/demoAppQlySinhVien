package com.example.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {



    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/view-product/{id}")
    public String viewProduct(@PathVariable int id) {
        return "product_detail";
    }

    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }

    @GetMapping("/check-out")
    public String checkOut(){
        return "checkout";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
