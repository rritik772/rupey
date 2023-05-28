package com.f15t.rupey.Service;

import com.f15t.rupey.DAO.Interface.AccountDaoInterface;
import com.f15t.rupey.DAO.Interface.CategoryDaoInterface;
import com.f15t.rupey.DAO.Interface.TransactionDaoInterface;
import com.f15t.rupey.DAO.Interface.UserDaoInterface;
import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Entities.Transaction;
import com.f15t.rupey.Entities.User;
import com.f15t.rupey.Response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    UserDaoInterface userDao;
    AccountDaoInterface accountDao;
    CategoryDaoInterface categoryDao;
    TransactionDaoInterface transactionDao;

    @Autowired
    TransactionService(
            AccountDaoInterface accountDao,
            CategoryDaoInterface categoryDao,
            TransactionDaoInterface transactionDao,
            UserDaoInterface userDaoInterface
    ) {
        this.userDao = userDaoInterface;
        this.accountDao = accountDao;
        this.categoryDao = categoryDao;
        this.transactionDao = transactionDao;
    }

    public TransactionResponse createTransaction(TransactionResponse response) {
        User user = userDao.findByUsername(response.getUsername());
        Account account = accountDao.getAccount(response.getAccountId());
        Category category = categoryDao.getCategory(response.getCategoryId());

        Transaction tmp = Transaction.builder()
                .name(response.getName())
                .description(response.getDescription())
                .date(response.getDate())
                .amount(response.getAmount())
                .user(user)
                .category(category)
                .account(account)
                .build();
        transactionDao.createTransaction(tmp);

        return response;
    }

    public List<TransactionResponse> findTransactionByUsername(String username) {
        List<Transaction> tmp = userDao.findTransactionByUsername(username);
        return tmp.stream().map(transaction -> TransactionResponse
                        .builder()
                        .name(transaction.getName())
                        .description(transaction.getDescription())
                        .description(transaction.getDescription())
                        .amount(transaction.getAmount())
                        .date(transaction.getDate())
                        .categoryId(transaction.getCategory().getCategoryId())
                        .accountId(transaction.getAccount().getAccountId())
                        .username(transaction.getUser().getUsername())
                        .build())
                .toList();
    }

    public Optional<TransactionResponse> updateTransaction(TransactionResponse response) {
        if (response.getTransactionId().isEmpty())
            return Optional.empty();

        User user = userDao.findByUsername(response.getUsername());
        Account account = accountDao.getAccount(response.getAccountId());
        Category category = categoryDao.getCategory(response.getCategoryId());

        Transaction tmp = Transaction.builder()
                .name(response.getName())
                .description(response.getDescription())
                .amount(response.getAmount())
                .date(response.getDate())
                .user(user)
                .account(account)
                .category(category)
                .build();
        transactionDao.updateTransaction(tmp);

        return Optional.of(response);
    }

    public Optional<TransactionResponse> deleteTransaction(TransactionResponse response) {
        if (response.getTransactionId().isEmpty())
            return Optional.empty();

        transactionDao.deleteTransaction(
                Transaction.builder()
                        .transactionId(response.getTransactionId().get())
                        .build()
        );
        return Optional.of(response);
    }
}
