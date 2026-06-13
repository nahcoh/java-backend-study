package user;

import java.util.Map;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("이미 가입된 메일이 있음");
        }

        userRepository.save(user);
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException("회원을 찾을 수 없음");
        }
        return user;
    }

    public void deleteByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw new UserNotFoundException("회원을 찾을 수 없습니다");
        }

        userRepository.deleteByEmail(email);
    }

    public void changeUserName(String email, String newName) {
        User user = findByEmail(email);
        user.changeName(newName);
    }

    public void changeUserAge(String email, int newAge) {
        User user = findByEmail(email);
        user.changeAge(newAge);
    }

    public Map<String, User> findAllUsers() {
        return userRepository.findAll();
    }

    public int countUsers() {
        return userRepository.count();
    }

}
