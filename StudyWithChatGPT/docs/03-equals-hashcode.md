# equals / hashCode

## 핵심

`HashSet`과 `HashMap`은 객체의 중복 여부를 판단할 때 `hashCode()`와 `equals()`를 사용한다.

### 순서
1. `hashCode()`로 같은 그룹인지 확인한다. 
2. `equals()`로 진짜 같은 객체인지 확인한다. 

## 문제 상황
```java
Set<User> users = new HashSet<>();

    users.add(new User("kim@test.com", "김박사" , 31));
    users.add(new User("kim@test.com", "중복김" , 20));

    System.out.println(users.size());
```
`User`에 `equals()`와 `hashCode()`를 구현하지 않으면 결과가 `2`가 나올 수 있다. 

### 이유:
new User(...) 를 두 번 했기 때문에 서로 다른 객체로 판단하기 때문이다. 

## 해결 방법
`User`는 `email`이 같으면 같은 회원으로 보기로 한다.

```java
@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }

    if (!(o instanceof User user)) {
        return false;
    }

    return email.equals(user.email);
}

@Override
public int hashCode() {
    return email.hashCode();
}
```
### 결과
`1`

이메일이 같기 때문에 같은 `User`로 판단되고, `HashSet`에는 하나만 저장된다.

## Property 예시

`Property`는 `address`가 같으면 같은 매물로 보기로 한다. 

```java
@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }

    if (!(o instanceof Property property)) {
        return false;
    }

    return address.equals(property.address);
}

@Override
public int hashCode() {
    return address.hashCode();
}
```
## HashMap에서 객체를 Key로 쓰는 경우
```java
Map<User, String> map = new HashMap<>();

User user1 = new User("kim@test.com", "김박사", 31);
User user2 = new User("kim@test.com", "중복김", 20);

map.put(user1, "첫 번째 회원");
map.put(user2, "두 번째 회원");

System.out.println(map.size());
```
### 결과
`1`

`user1`과 `user2`는 `email`이 같기 때문에 같은 Key로 판단된다.

이때 기존 Key 객체는 유지되고, value만 덮어쓰기 된다. 

### 예:
```text
key = user1, name =김박사
value = 두 번째 회원
```
그래서 출력하면 약간 섞인 것처럼 보일 수 있다. 

## 주의점
`HashMap`의 key로 쓰는 값은 중간에 바뀌면 안된다.

예를 들어 `User`의 `email`을 기준으로 `equals()`와 `hashCode()`를 만들었다면, `email`은 바뀌면 안된다. 
그래서 `email`은 `final`로 두는 것이 좋다.
```java
private final String email;
```
## 내가 이해한 것
- `equals()`는 같은 객체로 볼 기준을 정한다.
- `hashCode()`는 `HashSet`과 `HashMap`이 객체를 찾을 때 쓰는 해시 기준이다.
- `equals()`와 `hashCode()`는 같은 기준으로 만들어야 한다.
- `User`는 `email`기준으로 같은 회원인지 판단한다.
- `Property`는 `address`기준으로 같은 매물인지 판단한다.
- `HashMap`에서 같은 key로 판단되면 value가 덮어쓰기 된다. 
- 객체를 key로 쓸 때는 기준값이 바뀌지 않게 해야한다.

## 정리
- `HashSet` = `equals()` + `hashCode()`로 중복 판단
- `HashMap` = key의 `equals()` + `hashCode()`로 같은 key인지 판단
- `User` = `email` 기준
- `Property` = `address` 기준
