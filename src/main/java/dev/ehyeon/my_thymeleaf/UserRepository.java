package dev.ehyeon.my_thymeleaf;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class UserRepository {

    private static final Map<Long, User> map = new HashMap<>();
    private static long sequence = 0;

    public User save(String name) {
        User user = new User(++sequence, name, LocalDateTime.now());

        map.put(user.getId(), user);

        return user;
    }

    public Optional<User> findById(long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(map.values());
    }
}
