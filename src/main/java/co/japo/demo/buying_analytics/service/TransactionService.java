package co.japo.demo.buying_analytics.service;

import co.japo.demo.buying_analytics.domain.Transaction;
import co.japo.demo.buying_analytics.kafka.TransactionEvent;

import java.util.List;

public interface TransactionService {
    void add(Transaction transaction);
    void add(TransactionEvent event);
    Transaction dummyTransaction();
    List<Transaction> getAll();
}
