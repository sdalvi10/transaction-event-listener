package dev.codescreen.repository;

import dev.codescreen.models.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, Long> {
    TransactionEntity findByUserId(String userId);
}
