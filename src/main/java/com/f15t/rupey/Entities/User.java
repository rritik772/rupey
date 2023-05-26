package com.f15t.rupey.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    Long userId;

    @Column(unique = true)
    String username;

    String password;
    String fullName;
    String Currency;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transaction;
}
