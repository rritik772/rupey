package com.f15t.rupey.Service;

import com.f15t.rupey.DAO.Interface.AccountDaoInterface;
import com.f15t.rupey.DAO.Interface.UserDaoInterface;
import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Entities.User;
import com.f15t.rupey.Response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    AccountDaoInterface accountDao;
    UserDaoInterface userDao;

    @Autowired
    AccountService(AccountDaoInterface accountDaoInterface, UserDaoInterface userDaoInterface) {
        this.accountDao = accountDaoInterface;
        this.userDao = userDaoInterface;
    }

    public AccountResponse createAccount(AccountResponse accountRequest) {
        User user = userDao.findByUsername(accountRequest.getUsername());

        Account tmp = Account.builder()
                .bank(accountRequest.getBank())
                .accountHolder(accountRequest.getAccountHolder())
                .currentBalance(accountRequest.getCurrentBalance())
                .income(accountRequest.getIncome())
                .expense(accountRequest.getExpense())
                .user(user)
                .build();
        accountDao.createAccount(tmp);

        return accountRequest;
    }

    public List<AccountResponse> findAccountByUsername(String username) {
        List<Account> tmpAccounts = userDao.findAccountByUsername(username);

        List<AccountResponse> accountRes = tmpAccounts.stream().map(account -> AccountResponse.builder()
                        .bank(account.getBank())
                        .accountHolder(account.getAccountHolder())
                        .currentBalance(account.getCurrentBalance())
                        .income(account.getIncome())
                        .expense(account.getExpense())
                        .username(account.getUser().getUsername())
                        .accountId(Optional.of(account.getAccountId()))
                        .build())
                .toList();

        return accountRes;
    }

    public Optional<AccountResponse> updateAccount(AccountResponse response) {
        if (response.getAccountId().isEmpty()) {
            return Optional.empty();
        }

        Account tmp = Account.builder()
                .accountId(response.getAccountId().get())
                .bank(response.getBank())
                .accountHolder(response.getAccountHolder())
                .currentBalance(response.getCurrentBalance())
                .income(response.getIncome())
                .expense(response.getExpense())
                .build();
        accountDao.updateAccount(tmp);

        return Optional.of(response);
    }

    public Optional<AccountResponse> deleteAccount(AccountResponse response) {
        if (response.getAccountId().isEmpty()) {
            return Optional.empty();
        }

        Account tmp = Account.builder()
                .accountId(response.getAccountId().get())
                .build();
        accountDao.deleteAccount(tmp);

        return Optional.of(response);
    }

}
