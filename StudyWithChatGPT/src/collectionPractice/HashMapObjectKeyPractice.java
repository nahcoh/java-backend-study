package collectionPractice;

import java.util.HashMap;
import java.util.Map;
import user.User;

public class HashMapObjectKeyPractice {

    public static void main(String[] args) {
        Map<User, String> map = new HashMap<>();

        User user1 = new User("kim@test.com", "김호찬", 31);
        User user2 = new User("kim@test.com", "중복김", 20);

        map.put(user1, "첫 번쨰 회원");
        map.put(user2, "두 번째 회원");

        System.out.println("map.size() = " + map.size());

        for (User user : map.keySet()) {
            System.out.println(user.getEmail() + " / " + user.getName() + " / " + map.get(user));

        }
    }

}
