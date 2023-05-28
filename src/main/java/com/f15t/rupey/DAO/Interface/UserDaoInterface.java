package com.f15t.rupey.DAO.Interface;

import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Entities.Transaction;
import com.f15t.rupey.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInterface {
    List<Transaction> findTransactionByUsername(String username);
    List<Account> findAccountByUsername(String username);
    List<Category> findCategoryByUsername(String username);
    User findByUsername(String username);
    User createUser(User user);
    User updateUser(User user);
    User deleteUser(User user);
}
