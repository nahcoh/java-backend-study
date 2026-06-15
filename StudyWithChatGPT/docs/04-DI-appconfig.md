# DI / Appconfig

## 핵심
DI는 의존성 주입이다. 

필드에서 직접 `new`로 객체를 만들지 않고, 필요한 객체를 생성자를 통해 외부에서 넣어주는 방식이다. 

### 기존 방식
```java
public class UserService {
    
    private final UserRepository userRepository = new MemoryUserRepository();
    private final NotificationSender notificationSender = new EmailSender();
}
```

### 기존 방식의 문제
`UserService`가 직접 구현체를 선택하고 있다. 

예를 들어 `EmailSender`를 `SmsSender`로 바꾸고 싶으면 `UserService`코드를 직접 수정해야 한다.
```java
private final NotificationSender notificationSender = new EmailSender();
```
이 구조는 `UserService`가 구체 구현체에 강하게 의존하는 구조다. 

## 생성자 주입
````java
public class UserService {
    
    private final UserRepository userRepository;
    private final NotificationSender notificationSender;

    public UserService(UserRepository userRepository, NotificationSender notificationSender) {
        this.userRepository = userRepository;
        this.notificationSender = notificationSender;
    }
}
````
### 생성자 주입의 의미
`UserService`는 더 이상 직접 `new`를 하지 않는다.

필요한 객체를 생성자로 외부에서 받는다. 
````java
new UserService(userRepository, new EmailSender);
````
또는 
````java
new UserService(userRepository, new SmsSender);
````
이렇게 하면 `UserService`코드는 그대로 두고, 외부에서 어떤 구현체를 넣을지 결정할 수 있다.

## AppConfig
`AppConfig`는 객체를 생성하고 조립하는 역할을 한다.
````java
public class AppConfig {
    
    private final UserRepository userRepository = new MemoryUserRepository();
    private final UserService emailUserService = new UserService(userRepository, new EmailSender());
    private final UserService smsUserService = new UserService(userRepository, new SmsSender());

    public UserService emailUserService() {
        return emailUserService;
    }

    public UserService smsUserService() {
        return smsUserService;
    }
}
````
### AppConfig의 역할
- 객체를 생성한다
- 필요한 의존성을 연결한다
- 같은 객체를 재사용하게 한다.
- `Main`이나 `Service`가 직접 구현체를 선택하지 않게 한다.

### Service와 Entity의 차이 
`UserService`는 회원 한 명을 의미하는 객체가 아니다. 

회원가입, 회원 조회, 회원 삭제 같은 업무를 처리하는 객체다.

그래서 한 번 만들어서 재사용해도 된다.

반면 `User`는 실제 회원 한 명의 데이터를 가진 객체다. 

회원이 새로 가입할 때마다 새로운 `User`객체가 필요하다.

### Repository를 공유하는 이유
`UserRepository`는 저장소 역할이다. 

여러개 만들면 저장소가 여러 개로 나뉘어 데이터가 흩어진다.
그래서 하나의 `UserRepository`를 여러 `UserService`가 공유할 수 있다.
```java
private final UserRepository userRepository = new MemoryUserRepository();
```

## 인터페이스 의존
````java
private final UserRepository userRepository;
private final NotificationSender notificationSender;
````
`UserService`는 구체 클래스가 아니라 인터페이스에 의존한다. 
실제 구현체는 `AppConfig`가 정한다.

### 예:
````java
private final UserRepository userRepository = new MemoryUserRepository();
private final UserService emailUserService = new UserService(userRepository, new EmailSender());
````

## 내가 이해한 것
- DI는 필요한 객체를 외부에서 넣어주는 방식이다. 
- 생성자 주입은 생성자를 통해 의존 객체를 받는 방식이다. 
- Service는 직접 구현체를 만들지 않는 것이 좋다.
- AppConfig는 객체 생성과 조립을 담당한다. 
- Service는 한 번 만들어 재사용할 수 있다.
- User나 Property같은 데이터 객체는 매번 새로 만들어야 한다.(DTO도 마찬가지)
- Repository는 저장소 역할이므로 하나를 공유하는 것이 자연스럽다. 
- Spring에서는 AppConfig역할을 Spring Container가 대신한다. 

## 정리
- `UserService` = 회원 업무 처리
- `UserRepository` = 회원 저장소 역할
- `NotificationSender` = 알림 발송 역할
- `EmailSender` / `SmsSender` = 알림 발송 구현체 
- `AppConfig` = 객체 생성과 조립 담당
- DI = 필요한 객체를 외부에서 주입받는 방식