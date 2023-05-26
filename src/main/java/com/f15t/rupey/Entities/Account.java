package com.f15t.rupey.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    Long id;

    String bank;
    String account_holder;
    Float currentBalance;
    Float income;
    Float expense;
}
