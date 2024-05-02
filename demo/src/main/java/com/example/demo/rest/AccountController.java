package com.example.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.openapi.api.AccountApiDelegate;
import com.example.demo.openapi.model.Account;
import com.example.demo.openapi.model.DepositRequest;
import com.example.demo.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController implements AccountApiDelegate {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<Void> depositToAccount(@Valid DepositRequest depositRequest) {
        // TODO Auto-generated method stub
        accountService.updateBalance(depositRequest);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Account> getAccount(String accountNumber) {
        // TODO Auto-generated method stub
        //return AccountApi.super.getAccount();
        Account account = accountService.findAccountByNumber(accountNumber);

        return ResponseEntity.ok().body(account);
    }
    
}
