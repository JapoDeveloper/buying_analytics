package co.japo.demo.buying_analytics.web;

import co.japo.demo.buying_analytics.domain.Transaction;
import co.japo.demo.buying_analytics.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsController {
    private TransactionService transactionService;

    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAll();
    }
}
