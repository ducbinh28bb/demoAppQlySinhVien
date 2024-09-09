package com.example.assignment.controller;

import com.example.assignment.entity.Account;
import com.example.assignment.service.AccountService;
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
@RequestMapping("/api/Account")
public class AccountController {
    @Autowired
    private AccountService service;
    @GetMapping
    public ResponseEntity<?>getAll(){

        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Account account){

        return ResponseEntity.ok(service.add(account));
    }
    @PutMapping("/update{ten}")
    public ResponseEntity<?> update (@PathVariable String ten, @RequestBody Account account){
        return ResponseEntity.ok(service.update(account, ten));
    }
    @DeleteMapping("/delete{ten}")
    public ResponseEntity<?> delete (@PathVariable String ten) {

        return ResponseEntity.ok(service.delete(ten));
    }



}
