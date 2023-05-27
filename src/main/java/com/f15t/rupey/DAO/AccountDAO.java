package com.f15t.rupey.DAO;

import com.f15t.rupey.DAO.Interface.AccountDaoInterface;
import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO implements AccountDaoInterface {

    AccountRepository accountRepository;

    @Autowired
    AccountDAO(AccountRepository accountRepository) {}

    public Account createAccount(Account account) {
        Account temp = accountRepository.save(account);
        return temp;
    }

    public Account getAccount(String username) {
        return accountRepository.getReferenceById(5L);
    }

    public Account updateAccount(Account account) {
        return createAccount(account);
    }

    public Account deleteAccount(Account account) {
        return null;
    }
}
