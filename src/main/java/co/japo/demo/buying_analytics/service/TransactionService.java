package co.japo.demo.buying_analytics.service;

import co.japo.demo.buying_analytics.domain.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
}
