package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

    private final AuditService auditService;
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository, AuditService auditService) {
        this.accountRepository = accountRepository;
        this.auditService = auditService;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }
       @Transactional
    public void transferMoney(Long fromId, Long toId, double amount){

        auditService.saveAudit("Transfer started");

        Account from = accountRepository.findById(fromId).orElseThrow();
        Account to = accountRepository.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        accountRepository.save(from);

        if(amount > 5000){
            throw new RuntimeException("Transfer failed");
        }

        to.setBalance(to.getBalance() + amount);
        accountRepository.save(to);

        auditService.saveAudit("Transfer completed");
    }
}
