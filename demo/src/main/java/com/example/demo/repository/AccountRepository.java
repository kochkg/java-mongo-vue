package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.openapi.model.Account;


public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByAccountNumber(String accountNumber);
    
}