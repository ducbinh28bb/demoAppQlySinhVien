package com.example.assignment.controller;
import com.example.assignment.entity.Order;

import com.example.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Order")
public class OrderController {
    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Order order){
        return ResponseEntity.ok(service.add(order));
    }
    @PutMapping("/update{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody Order order){
        return ResponseEntity.ok(service.update(order, id));
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
