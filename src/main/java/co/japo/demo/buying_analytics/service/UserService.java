package co.japo.demo.buying_analytics.service;

import co.japo.demo.buying_analytics.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getByName(String name);
}
