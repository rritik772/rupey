package com.f15t.rupey.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    Long id;

    @Column(unique = true)
    String username;

    String password;
    String fullName;
    String Currency;
}
