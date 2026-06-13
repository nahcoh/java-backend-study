import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    public User findByEmail(String email) {
        return users.get(email);
    }

    public boolean existsByEmail(String email) {
        return users.containsKey(email);
    }

    public void deleteByEmail(String email) {
        users.remove(email);
    }

    public Map<String, User> findAll() {
        return users;
    }

    public int count() {
        return users.size();
    }


}
