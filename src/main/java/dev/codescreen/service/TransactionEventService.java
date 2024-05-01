package dev.codescreen.service;

import dev.codescreen.dto.Event;
import dev.codescreen.models.TransactionEntity;
import dev.codescreen.repository.TransactionEntityRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionEventService {
    TransactionEntityRepository transactionEntityRepository;

    public TransactionEventService(TransactionEntityRepository transactionEntityRepository) {
        this.transactionEntityRepository = transactionEntityRepository;
    }

    public List<TransactionEntity> getTransactions() {
        return (List<TransactionEntity>) transactionEntityRepository.findAll();
    }

    @KafkaListener(topics = "transaction-event-topic",groupId = "transaction-event-group")
    public void processAmountEvents(Event event) {
        TransactionEntity transactionEntity = event.getTransactionEntity();
        transactionEntityRepository.save(transactionEntity);
    }
}
