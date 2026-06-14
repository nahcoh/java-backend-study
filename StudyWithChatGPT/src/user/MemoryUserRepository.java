package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.containsKey(email);
    }

    @Override
    public void deleteByEmail(String email) {
        users.remove(email);

    }

    @Override
    public Map<String, User> findAll() {
        return users;
    }

    @Override
    public int count() {
        return users.size();
    }
}
