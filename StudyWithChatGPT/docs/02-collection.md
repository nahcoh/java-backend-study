# Java 컬렉션 기초

## 핵심

Java 컬렉션은 여러 데이터를 저장하고 다루기 위한 자료구조다. 
- `List`: 순서가 있고 중복을 허용한다.
- `Set`: 중복을 허용하지 않는다. 
- `Map`: key-value 구조로 데이터를 저장한다.

## List
`List`는 순서가 있고 중복을 허용한다.

```java
List<String> names = new ArrayList<>();

names.add("kim");
names.add("lee");
names.add("kim");
```
결과
```text
kim
lee
kim 
```

## Set
`Set`은 중복을 허용하지 않는다.
```java
Set<String> names = new HashSet<>();

names.add("kim");
names.add("lee");
names.add("kim");
```
결과
```text
kim
lee
```
단, HashSet은 출력 순서를 보장하지 않는다. 

## Map
`Map`은 key-value 구조다.
```java
Map<String, String> users = new HashMap<>();

users.put("kim@test.com", "김박사");
users.put("lee@test.com", "이박사");
users.put("kim@test.com", "중복김");
```
같은 key로 다시 put()하면 기존 value가 덮어쓰기 된다.

결과
```text
kim@test.com -> 중복김
lee@test.com -> 이박사
```

## 실행 가능한 예제
```java
package collectionPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("kim");
        list.add("lee");
        list.add("kim");

        System.out.println("List 출력");
        for( String name : list) {
            System.out.println(name);
        }

        Set<String> set = new HashSet<>();

        set.add("kim");
        set.add("lee");
        set.add("kim");

        System.out.println("Set 출력");
        for(String name : set) {
            System.out.println(name);
        }

        Map<String, String> users = new HashMap<>();

        users.put("kim@test.com", "김박사");
        users.put("lee@test.com", "이박사");
        users.put("kim@test.com", "중복김");
        
        System.out.println("Map 출력");
        for(String email : users.keySet()) {
            System.out.println(email + " / " + users.get(email));
        }
    }
}
```

## 내가 이해한 것
- `List`는 순서가 있고 중복을 허용한다.
- `Set`은 중복을 허용하지 않는다. 
- `HashSet`은 출력 순서를 보장하지 않는다.
- `Map`은 key-value 구조다.
- `Map`에서 key는 중복될 수 없다. 같은 key로 다시 put( )하면 value가 덮어쓰기 된다.
- `keySet()`은 key목록을 꺼낸다.
- `values()`는 value목록을 꺼낸다.
- `entrySet()`은 key-value 한 쌍을 꺼낸다.

## 정리
- List = 순서 있음, 중복 가능
- Set = 중복 불가
- Map = key-value구조, key 중복 불가
