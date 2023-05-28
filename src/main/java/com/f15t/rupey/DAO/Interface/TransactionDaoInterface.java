package com.f15t.rupey.DAO.Interface;

import com.f15t.rupey.Entities.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDaoInterface {
    Transaction createTransaction(Transaction transaction);
    Transaction findTransaction(Long id);
    Transaction updateTransaction(Transaction transaction);
    Transaction deleteTransaction(Transaction transaction);
}
