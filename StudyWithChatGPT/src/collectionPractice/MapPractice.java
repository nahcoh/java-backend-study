package collectionPractice;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {

    public static void main(String[] args) {

        Map<String, String> users = new HashMap<>();

        users.put("kim@test.com", "김호찬");
        users.put("lee@test.com", "이백원");
        users.put("kim@test.com", "중복킴");

        System.out.println(users.get("kim@test.com"));
        System.out.println(users.get("lee@test.com"));
        System.out.println(users.size());

        for (String email : users.keySet()) {
            System.out.println(email + " / " + users.get(email));
        }

        for (String name : users.values()) {
            System.out.println(name);

        }

        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
    }

}
