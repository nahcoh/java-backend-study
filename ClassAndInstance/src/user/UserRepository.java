package user;

import java.util.HashMap;
import java.util.Map;

public interface UserRepository {

     void save(User user);

    User findByEmail(String email);

     boolean existsByEmail(String email);

     void deleteByEmail(String email);

     Map<String, User> findAll();

     int count();


}
