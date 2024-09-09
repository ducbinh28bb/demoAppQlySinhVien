package com.example.assignment.service;

import com.example.assignment.entity.Account;
import com.example.assignment.entity.Category;
import com.example.assignment.repo.AccountRepository;
import com.example.assignment.repo.CategoryReposityry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryReposityry repository;

    public List<Category> getAll(){
        return repository.findAll();
    }
    public Category add(Category category){
        return repository.save(category);
    }
    public Category update (Category category, String id){
        Optional<Category> optional = repository.findById(id);
        return optional.map(o-> {
            o.setId(category.getId());
            o.setTen(category.getTen());
            return repository.save(o);
        }).orElse(null);
    }
    public Category delete (String id){
        Optional<Category> optional = repository.findById(id);
        return optional.map(o-> {
            repository.delete(o);
            return o;
        }).orElse(null);
    }
}
