package com.f15t.rupey.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    Optional<Long> accountId;

    String bank;
    String accountHolder;
    Float currentBalance;
    Float income;
    Float expense;
    String username;
}
