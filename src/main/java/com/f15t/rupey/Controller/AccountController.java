package com.f15t.rupey.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f15t.rupey.Response.AccountResponse;
import com.f15t.rupey.Service.AccountService;

@RestController
@RequestMapping("/apiV1/account")
public class AccountController {

    AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse createAccount(@RequestBody AccountResponse accountResponse) {
        return accountService.createAccount(accountResponse);
    }

    @GetMapping("/{username}")
    public List<AccountResponse> findAccountByUsername(@PathVariable String username) {
        return accountService.findAccountByUsername(username);
    }

    @PutMapping
    public Optional<AccountResponse> updateAccount(@RequestBody AccountResponse accountResponse) {
        return accountService.updateAccount(accountResponse);
    }

    @DeleteMapping
    public Optional<AccountResponse> deleteAccount(@RequestBody AccountResponse accountResponse) {
        return accountService.deleteAccount(accountResponse);
    }

}
