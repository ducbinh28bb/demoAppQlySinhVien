package com.example.assignment.service;

import com.example.assignment.entity.Account;
import com.example.assignment.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public List<Account> getAll(){

        return repository.findAll();
    }

    public Account add(Account account){

        return repository.save(account);
    }
    public Account update (Account account, String ten){
        Optional<Account> optional = repository.findById(ten);
        return optional.map(o-> {
            o.setTen(account.getTen());
            o.setMa(account.getMa());
            o.setHoTen(account.getHoTen());
            o.setEmail(account.getEmail());
            return repository.save(o);
        }).orElse(null);
    }
    public Account delete (String ten){
        Optional<Account> optional = repository.findById(ten);
        return optional.map(o-> {
            repository.delete(o);
            return o;
        }).orElse(null);
    }

}
