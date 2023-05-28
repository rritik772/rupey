package com.f15t.rupey.Controller;

import com.f15t.rupey.Response.TransactionResponse;
import com.f15t.rupey.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiV1/transaction")
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    TransactionResponse createTransaction(@RequestBody TransactionResponse response) {
        return transactionService.createTransaction(response);
    }

    @GetMapping("/{username}")
    List<TransactionResponse> findTransactionByUsername(@PathVariable String username) {
        return transactionService.findTransactionByUsername(username);
    }

    @PutMapping
    Optional<TransactionResponse> updateTransaction(@RequestBody TransactionResponse response) {
        return transactionService.updateTransaction(response);
    }

    @DeleteMapping
    Optional<TransactionResponse> deleteTransaction(@RequestBody TransactionResponse response) {
        return transactionService.deleteTransaction(response);
    }
}
