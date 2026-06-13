package Ex12_1;

import java.util.ArrayList;

class Fruit {
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit {
    public String toString() {
        return "Grape";
    }
}
class Toy {
    public String toString() {
        return "Toy";
    }
}

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Toy> toyBox = new Box<Toy>();
//        Ex12_1.Box<Ex12_1.Grape> grapeBox = new Ex12_1.Box<Ex12_1.Apple>(); // 에러. 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());

        appleBox.add(new Apple());
        appleBox.add(new Apple());
//        appleBox.add(new Ex12_1.Toy());    //에러. Ex12_1.Box<Ex12_1.Apple>에는 Apple타입만 담을 수 있음

        toyBox.add(new Toy());
//        toyBox.add(new Ex12_1.Apple());    //에러. Ex12_1.Box<Ex12_1.Toy>에는 Toy만 담을 수 있음

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("toyBox = " + toyBox);
    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add (T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}
