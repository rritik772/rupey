package com.f15t.rupey.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Category {
    
    @Id
    Long id;

    String name;
    String description;
    boolean isDeleted;
}
