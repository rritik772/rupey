package com.f15t.rupey.Entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    
    @Id
    Long transactionId;

    String name;
    String description;
    Float amount;
    Date date;

    @OneToOne
    Category category;

    @OneToOne
    Account account;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
