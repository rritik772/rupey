package com.f15t.rupey.DAO;

import com.f15t.rupey.DAO.Interface.AccountDaoInterface;
import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao implements AccountDaoInterface {

    AccountRepository accountRepository;

    @Autowired
    AccountDao(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.getReferenceById(id);
    }

    public Account updateAccount(Account account) {
        return createAccount(account);
    }

    public Account deleteAccount(Account account) {
        accountRepository.delete(account);
        return account;
    }
}
