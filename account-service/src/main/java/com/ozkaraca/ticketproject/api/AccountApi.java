package com.ozkaraca.ticketproject.api;

import com.ozkaraca.ticketproject.entity.Account;
import com.ozkaraca.ticketproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id") String id, @PathVariable("id") Account account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

}
