package co.japo.demo.buying_analytics.service;

import co.japo.demo.buying_analytics.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getByName(String name);
}
