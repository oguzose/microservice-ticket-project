package com.ozkaraca.ticketproject.service;

import com.ozkaraca.ticketproject.entity.Account;
import com.ozkaraca.ticketproject.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalStateException());
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account update(String id, Account account) {
        Assert.isNull(id, "Id can not be null");
        Account account1 = getAccount(id);
        return accountRepository.save(account);
    }

    public void delete(String id) {

    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
