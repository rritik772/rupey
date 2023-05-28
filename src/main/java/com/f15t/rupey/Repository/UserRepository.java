package com.f15t.rupey.Repository;

import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Entities.Transaction;
import com.f15t.rupey.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
