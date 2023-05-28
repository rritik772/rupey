package com.f15t.rupey.DAO;

import com.f15t.rupey.DAO.Interface.TransactionDaoInterface;
import com.f15t.rupey.Entities.Transaction;
import com.f15t.rupey.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao implements TransactionDaoInterface {

    TransactionRepository transactionRepository;

    @Autowired
    TransactionDao(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.saveAndFlush(transaction);
    }

    public Transaction findTransaction(Long id) {
        return transactionRepository.getReferenceById(id);
    }

    public Transaction updateTransaction(Transaction transaction) {
        return createTransaction(transaction);
    }

    public Transaction deleteTransaction(Transaction transaction) {
        transactionRepository.delete(transaction);
        return transaction;
    }

}
