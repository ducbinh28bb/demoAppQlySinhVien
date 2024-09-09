package com.example.assignment.controller;
import com.example.assignment.entity.Category;
import com.example.assignment.service.CategoryService;
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
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category){

        return ResponseEntity.ok(service.add(category));
    }
    @PutMapping("/update{id}")
    public ResponseEntity<?> update (@PathVariable String id, @RequestBody Category category){
        return ResponseEntity.ok(service.update(category, id));
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> delete (@PathVariable String id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
