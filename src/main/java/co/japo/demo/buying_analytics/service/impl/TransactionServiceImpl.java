package co.japo.demo.buying_analytics.service.impl;

import co.japo.demo.buying_analytics.domain.Product;
import co.japo.demo.buying_analytics.domain.Transaction;
import co.japo.demo.buying_analytics.domain.User;
import co.japo.demo.buying_analytics.service.ProductService;
import co.japo.demo.buying_analytics.service.TransactionService;
import co.japo.demo.buying_analytics.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TransactionServiceImpl implements TransactionService {

    private UserService userService;
    private ProductService productService;

    public TransactionServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public List<Transaction> getAll() {
        return IntStream.range(0, 9)
                .mapToObj(i -> {
                    User tUser = userService.getAll().get(new Random().nextInt(userService.getAll().size()));
                    Product tProduct = productService.getAll().get(new Random().nextInt(productService.getAll().size()));
                    return Transaction.builder()
                            .user(tUser)
                            .product(tProduct)
                            .buyCount(new Random().nextInt(10))
                            .build();
                })
                .collect(Collectors.toList());
    }
}
