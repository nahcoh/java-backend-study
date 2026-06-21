## customer
- email
- name
- phone

## Methods
- 고객 등록
- email로 조회
- 이름 변경
- 전화번호 변경
- 삭제 
- 전체 조회
- count
- 중복 등록 예외
- 없는 고객 예외


## TIL

### Entity, Repository, Service의 역할 분리
Customer CRUD를 구현하면서 중요한 점은 각 클래스의 책임을 나누는 것이다.

#### 1. Customer
`Customer`는 고객 한 명의 데이터를 표현하는 도메인 객체다.
Customer가 책임지는 것: 
- email
- name
- phone
- 자신의 이름 변경
- 자신의 전화번호 변경
- 자신의 필드 검증

Customer는 자기 자신의 값만 관리한다. 
Customer가 하면 안 되는 것:
- 전체 고객 목록 조회
- email로 고객 찾기
- Repository 접근
- Map 접근 


#### 2. Repository의 역할 
Repository는 저장소 역할만 한다.
- 저장
- 조회 
- 삭제
- 전체 조회
- 개수 조회

Repository는 고객이 없을 때 예외를 던지기 보다 `null`을 반환해도 된다.

없는 고객인지 판단하고 예외를 던지는 것은 Service의 역할이다. 

#### 3. Service의 역할
Service는 비즈니스 규칙을 담당한다. 
Service가 책임지는 것:
- 중복 고객 등록 방지
- 없는 고객 조회 시 예외 처리
- 없는 고객 수정 시 예외 처리
- Repository에서 찾은 Customer에게 변경 요청

이름 변경은 Service가 고객을 먼저 찾고, 찾은 Customer객체에게 변경을 맡긴다. 

핵심 흐름:
Service가 email을 받음

1. Repository에서 Customer를 찾음
2. 없으면 Service가 예외 발생
3. 있으면 Customer.changeName() 호출
4. Customer 자기 이름을 검증하고 변경

#### 4. 생성자 주입은 Customer가 아니라 Service에 적용한다.
Repository를 필드로 가지는 것은 Customer가 아니라 Service다. 

### 정리 
Customer = 자기 상태 관리
Repository = 저장소 접근
Service = 흐름 제어와 예외 처리

## 5. `Map.values()`는 무엇을 반환하는가? 
`Map.values()`는 `List`가 아니라 `Collection`을 반환한다.

Map 구조: 
key             value
a@test.com      customer1
b@test.com      customer2

여기서 `map.values()`를 호출하면 value만 꺼내진다.
`[customer1, customer2]`

하지만 반환 타입은 `List<Customer>`가 아니라 `Collection<Customer>`다.

그래서 아래 코드는 안 된다.

List<Customer> list = map.values(); //불가능
타입이 다르기 때문이다.

map.values() 반환 타입 => Collection<Customer>
받으려는 타입 List<Customer>

### 6. 왜 `new ArrayList<>(map.values())`를 사용하는가?
`ArrayList`는 `Map`을 구현한 것이 아니다.
`ArrayList`는 `List`의 구현체이고, `List`는 `Collection`의 하위 타입이다.

구조:

Collection

↑

List

↑

ArrayList

`map.values()`는 `Collection<Customer>`를 반환한다.
그리고 `ArrayList`는 `Collection`을 받아서 새로운 리스트를 만들 수 있다.

List<Customer> list = new ArrayList<>(map.values());

즉, map.values()가 Collection을 반환하고, ArrayList 생성자가 Collection을 받을 수 있기 때문에 가능한 것이다.





