package dev.codescreen.controller;

import dev.codescreen.models.TransactionEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.codescreen.service.TransactionEventService;

import java.util.List;

@RequestMapping("/transactions")
@RestController
public class TransactionEventController {
    private final TransactionEventService queryService;

    public TransactionEventController(TransactionEventService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public List<TransactionEntity> fetchAllTransactions(){
        return queryService.getTransactions();
    }

}
