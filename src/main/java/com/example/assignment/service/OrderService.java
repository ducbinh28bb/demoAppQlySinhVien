package com.example.assignment.service;

import com.example.assignment.entity.Category;
import com.example.assignment.entity.Order;
import com.example.assignment.repo.CategoryReposityry;
import com.example.assignment.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getAll(){
        return repository.findAll();
    }
    public Order add(Order order){
        return repository.save(order);
    }
    public Order update (Order order, Long id){
        Optional<Order> optional = repository.findById(id);
        return optional.map(o-> {
            o.setId(order.getId());
            o.setDiaChi(order.getDiaChi());
            o.setTenNguoiDung(order.getTenNguoiDung());
            return repository.save(o);
        }).orElse(null);
    }
    public Order delete (Long id){
        Optional<Order> optional = repository.findById(id);
        return optional.map(o-> {
            repository.delete(o);
            return o;
        }).orElse(null);
    }
}
