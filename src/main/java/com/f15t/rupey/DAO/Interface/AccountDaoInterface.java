package com.f15t.rupey.DAO.Interface;

import com.f15t.rupey.Entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDaoInterface {
    Account createAccount(Account account);
    Account getAccount(String username);
    Account updateAccount(Account account);
    Account deleteAccount(Account account);
}
