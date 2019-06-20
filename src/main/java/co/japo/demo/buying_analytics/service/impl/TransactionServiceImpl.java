package co.japo.demo.buying_analytics.service.impl;

import co.japo.demo.buying_analytics.domain.Product;
import co.japo.demo.buying_analytics.domain.Transaction;
import co.japo.demo.buying_analytics.domain.User;
import co.japo.demo.buying_analytics.kafka.TransactionEvent;
import co.japo.demo.buying_analytics.service.ProductService;
import co.japo.demo.buying_analytics.service.TransactionService;
import co.japo.demo.buying_analytics.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TransactionServiceImpl implements TransactionService {

    private UserService userService;
    private ProductService productService;
    private List<Transaction> transactions;

    public TransactionServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public void add(TransactionEvent event) {
        User tUser = userService.getByName(event.getUser()).orElse(null);
        Product tProduct = productService.getByName(event.getProduct()).orElse(null);
        Transaction transaction = Transaction.builder()
                .user(tUser)
                .product(tProduct)
                .buyCount(event.getCount())
                .build();
        this.transactions.add(transaction);
    }

    @Override
    public Transaction dummyTransaction() {
        User tUser = userService.getAll().get(new Random().nextInt(userService.getAll().size()));
        Product tProduct = productService.getAll().get(new Random().nextInt(productService.getAll().size()));
        return Transaction.builder()
                .user(tUser)
                .product(tProduct)
                .buyCount(new Random().nextInt(10))
                .build();
    }

    @Override
    public List<Transaction> getAll() {
        return this.transactions;
    }
}
