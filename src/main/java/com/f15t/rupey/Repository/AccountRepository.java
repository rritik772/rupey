package com.f15t.rupey.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f15t.rupey.Entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
