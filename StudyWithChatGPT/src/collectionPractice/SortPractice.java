package collectionPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import property.Property;

public class SortPractice {

    public static void main(String[] args) {
        List<Property> properties = new ArrayList<>();

        properties.add(new Property("서울시 강남구", 50000, "원룸", "kim@test.com"));
        properties.add(new Property("서울시 마포구", 70000, "투룸", "kim@test.com"));
        properties.add(new Property("서울시 서초구", 30000, "오피스텔", "lee@test.com"));

        properties.sort(Comparator.comparingInt(Property::getPrice));

        for (Property property : properties) {
            System.out.println(property.getAddress() + " / " + property.getPrice());

        }

        System.out.println("가격 높은 순 정렬 ");

        properties.sort((p1, p2) -> p2.getPrice() - p1.getPrice());

        for (Property property : properties) {
            System.out.println(property.getAddress() + " / " + property.getPrice());

        }

    }

}
