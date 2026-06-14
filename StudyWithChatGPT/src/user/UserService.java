package user;

import java.util.Map;
import notification.EmailSender;
import notification.NotificationSender;

public class UserService {

    private final UserRepository userRepository;
    private final NotificationSender notificationSender;

    public UserService(UserRepository userRepository, NotificationSender notificationSender) {
        this.userRepository = userRepository;
        this.notificationSender = notificationSender;
    }



    public void register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("이미 가입된 메일이 있음");
        }

        userRepository.save(user);
        notificationSender.send(user.getName() + "님 회원가입을 환영합니다.");

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
