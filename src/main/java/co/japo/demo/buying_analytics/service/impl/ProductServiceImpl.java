package co.japo.demo.buying_analytics.service.impl;

import co.japo.demo.buying_analytics.domain.Product;
import co.japo.demo.buying_analytics.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAll() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Product.builder()
                        .name("Product " + i)
                        .price((i % 2) + (i * 3 / 2))
                        .build()
                )
                .collect(Collectors.toList());
    }
}
