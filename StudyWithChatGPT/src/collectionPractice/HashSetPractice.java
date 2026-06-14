package collectionPractice;

import java.util.HashSet;
import java.util.Set;
import property.Property;
import user.User;

public class HashSetPractice {

    public static void main(String[] args) {

        Set<String> emails = new HashSet<>();

        emails.add("kim@test.com");
        emails.add("lee@test.com");
        emails.add("park@test.com");
        emails.add("kim@test.com");

        System.out.println("emails.size() = " + emails.size());

        for (String email : emails) {
            System.out.println(email);
        }

        Set<User> users = new HashSet<>();

        users.add(new User("kim@test.com", "김호찬", 31));
        users.add(new User("kim@test.com", "중복김", 20));

        System.out.println("users.size() = " + users.size());

        for (User sure : users) {
            System.out.println(sure.getEmail() + " / " + sure.getName());

        }

        Set<Property> properties = new HashSet<>();

        properties.add(new Property("서울시 강남구", 50000, "원룸", "kim@test.com"));
        properties.add(new Property("서울시 강남구", 100000, "중복 매물", "lee@test.com"));

        System.out.println("properties.size() = " + properties.size());

        for (Property property : properties) {
            System.out.println(property.getAddress() + " / " + property.getPrice());
            System.out.println("property.hashCode() = " + property.hashCode());
        }    }

}
