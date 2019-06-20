package co.japo.demo.buying_analytics.service.impl;

import co.japo.demo.buying_analytics.domain.User;
import co.japo.demo.buying_analytics.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users;

    public UserServiceImpl() {
        this.users = IntStream.range(0, 9)
                .mapToObj(i -> User.builder().name("User " + i).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public Optional<User> getByName(String name) {
        return this.users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
