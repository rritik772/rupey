package com.f15t.rupey.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Category {
    
    @Id
    private Long categoryId;

    private String name;
    private String description;
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
