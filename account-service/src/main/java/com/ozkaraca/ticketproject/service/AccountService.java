package com.ozkaraca.ticketproject.service;

import com.ozkaraca.ticketproject.contract.AccountDto;
import com.ozkaraca.ticketproject.entity.Account;
import com.ozkaraca.ticketproject.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    public AccountDto getAccount(String id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return modelMapper.map(account, AccountDto.class);
    }

    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> account = accountRepository.findById(id);
        Account accountToUpdate = account.map(it -> {
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        accountRepository.delete(account);
    }

    public Slice<AccountDto> findAllPageable(Pageable pageable) {
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
