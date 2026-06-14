package collectionPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionPractice {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("kim");
        list.add("lee");
        list.add("kim");

        System.out.println("List 출력");
        for (String name : list) {
            System.out.println(name);
        }

        Set<String> set = new HashSet<>();

        set.add("kim");
        set.add("lee");
        set.add("kim");

        System.out.println("Set 출력");
        for (String name : set) {
            System.out.println(name);
        }

    }
}
