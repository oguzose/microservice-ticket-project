package com.ozkaraca.ticketproject.api;

import com.ozkaraca.ticketproject.contract.AccountDto;
import com.ozkaraca.ticketproject.entity.Account;
import com.ozkaraca.ticketproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @PathVariable("id") AccountDto accountDto) {
        return null;
                //ResponseEntity.ok(accountService.update(id, accountDto));
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(accountService.findAllPageable(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

}
