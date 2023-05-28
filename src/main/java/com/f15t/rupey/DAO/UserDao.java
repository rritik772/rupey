package com.f15t.rupey.DAO;

import com.f15t.rupey.DAO.Interface.UserDaoInterface;
import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Entities.Transaction;
import com.f15t.rupey.Entities.User;
import com.f15t.rupey.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserDaoInterface {

    EntityManager entityManager;
    UserRepository userRepository;

    @Autowired
    UserDao(EntityManager entityManager, UserRepository userRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    public List<Transaction> findTransactionByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);

        Root<Transaction> transaction = cq.from(Transaction.class);
        Predicate transactionsUsername = cb.equal(transaction.get("user").get("username"), username);
        cq.where(transactionsUsername);

        TypedQuery<Transaction> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public List<Account> findAccountByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);

        Root<Account> account = cq.from(Account.class);
        Predicate accountUsername = cb.equal(account.get("user").get("username"), username);
        cq.where(accountUsername);

        TypedQuery<Account> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public List<Category> findCategoryByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);

        Root<Category> account = cq.from(Category.class);
        Predicate accountUsername = cb.equal(account.get("user").get("username"), username);
        cq.where(accountUsername);

        TypedQuery<Category> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(User user) {
        return createUser(user);
    }

    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }

}
