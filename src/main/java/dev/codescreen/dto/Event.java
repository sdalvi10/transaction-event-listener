package dev.codescreen.dto;

// Event.java

import dev.codescreen.models.TransactionEntity;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String type;
    private TransactionEntity transactionEntity;
}
