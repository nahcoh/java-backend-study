# Java 객체와 캡슐화

## 핵심

클래스는 객체를 만들기 위한 설계도이고, 객체는 클래스로부터 실제 생성된 인스턴스다. 

객체는 필드와 메서드를 가진다.

- 필드: 객체의 상태
- 메서드: 객체의 행동

## 예시

```java
public class User {
    private final String email;
    private String name;
    private int age;

    public User(String email, String name, int age) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("이메일은 필수입니다.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
        }

        this.email = email;
        this.name = name;
        this.age = age;
    }

    public void changeName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        this.name = name;
    }

    public void changeAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
        }

        this.age = age;
    }
}
```

## 내가 이해한 것

- `private`은 외부에서 필드를 직접 바꾸지 못하게 한다.
- `final`은 한 번 초기화하면 다시 바꿀 수 없게한다.
- 생성자는 객체가 만들어질 때 필요한 값을 넣고 검증하는 역할을 한다. 
- `changeName()`, `changeAge()`같은 메서드로 객체의 상태를 안전하게 바꾼다.  
- 객체는 자기 자신의 상태를 스스로 검증하는 것이 좋다. 


## 정리 
`User`는 회원 한 명을 표현하는 객체다. 

`User`는 `email`,`name`,`age`를 가지고 있고, 이름과 나이를 바꿀 때 자기 내부에서 검증한다. 
