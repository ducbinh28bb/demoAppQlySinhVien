package com.example.assignment.repo;

import com.example.assignment.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReposityry extends JpaRepository<Category, String> {
}
