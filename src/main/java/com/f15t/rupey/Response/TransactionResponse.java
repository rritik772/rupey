package com.f15t.rupey.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Optional<Long> transactionId;
    private String name;
    private String description;
    private Float amount;
    private Date date;

    private Long categoryId;
    private Long accountId;
    private String username;
}
