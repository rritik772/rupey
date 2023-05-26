package com.f15t.rupey.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Category {
    
    @Id
    Long categoryId;

    String name;
    String description;
    boolean isDeleted;

    @OneToOne
    User user;
}
