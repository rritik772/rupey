package com.f15t.rupey.Response;

import com.f15t.rupey.Entities.Account;
import com.f15t.rupey.Entities.Category;
import com.f15t.rupey.Entities.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    Optional<Long> userId;

    private String username;
    private String password;
    private String fullName;
    private String currency;
}
