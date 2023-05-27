package com.f15t.rupey.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    String bank;
    String account_holder;
    Float currentBalance;
    Float income;
    Float expense;
}
