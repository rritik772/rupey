package com.f15t.rupey.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private Long accountId;

    private String bank;
    private String account_holder;
    private Float currentBalance;
    private Float income;
    private Float expense;
    
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
