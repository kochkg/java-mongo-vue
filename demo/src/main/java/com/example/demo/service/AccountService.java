package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.demo.openapi.model.Account;
import com.example.demo.openapi.model.DepositRequest;
import com.example.demo.repository.AccountRepository;

@Component
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findAccountByNumber(String accountNumber) {
      return accountRepository.findByAccountNumber(accountNumber);
    }

    public void updateBalance(DepositRequest request) {
      Account account = accountRepository.findByAccountNumber(request.getAccountNumber());
      if (null == account) {
        account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setBalance(BigDecimal.ZERO);
      }
      account.setBalance(account.getBalance().add(request.getDepositAmount()));
      accountRepository.save(account);
    }
}
