# Comparator / Comparable 

## 핵심

Comparator와 Comparable은 모두 정렬 기준을 정의하기 위한 인터페이스다.

정렬을 하려면 객체끼리 어떤 기준으로 비교할지 정해야 한다.


### Comparable 
`Comparable`은 객체의 **기본 정렬 기준**을 정할 때 사용한다.


대표 메서드:
```java
int compareTo(T o);
```
예를 들어 `String`, `Integer`같은 클래스는 이미 `Comparable`을 구현하고 있다. 
```java
Arrays.sort(strArr);
```
위 코드는 `String`이 가지고 있는 기본 정렬 기준을 사용한다. 


### Comparator
`Comparator`는 기본 정렬 기준이 아닌 **다른 정렬 기준**을 만들 때 사용한다.

대표 메서드:
````java
int compare(T o1, T o2);
````
`compare()`는 `Comparator`에서 사용하는 메서드다.  
객체 클래스 내부에 기본 정렬 기준을 넣는 것이 아니라, 정렬할 때 외부에서 별도의 비교 기준을 만들어 전달할 때 사용한다.

예를 들어 문자열을 내림차순으로 정렬하고 싶을 때 사용할 수 있다. 
```java
class Descending implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
```
사용: 
````java
Arrays.sort(strArr, new Descending());
````

### compare / compareTo 반환값
정렬 기준 메서드는 보통 다음 규칙을 따른다.

음수: 앞의 값이 먼저 온다. 
0: 두 값이 같다. 
양수: 뒤의 값이 먼저 온다. 

예: p1 - p2
- 음수: p1이 더 작으므로 p1이 앞
- 양수: p1이 더 크므로 p2가 앞
- 결과적으로 오름차순

예:
o1.compareTo(o2):

기본 오름차순 정렬이다.

o2.compareTo(o1):

순서를 반대로 비교하므로 내림차순 정렬이 된다.

```java
import java.util.Arrays;

public class ComparatorEx {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println("기본 정렬 = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("대소문자 구분 없는 정렬 = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("내림차순 정렬 = " + Arrays.toString(strArr));
        
    }
}

class Descending implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
```

### 결과
````text
기본 정렬 = [Dog, cat, lion, tiger]
대소문자 구분 없는 정렬 = [cat, Dog, lion, tiger]
내림차순 정렬 = [tiger, lion, cat, Dog]
````


## 내가 이해한 것
- `Comparable`은 객체가 가진 기본 정렬 기준이다.
- `Comparator`는 외부에서 새로운 정렬 기준을 정할 때 사용한다.
- `Arrays.sort(strArr)`는 `String`의 기본 정렬 기준을 사용한다.
- `Arrays.sort(strArr, new Descending())`은 내가 만든 정렬 기준을 사용한다.
- `compare()`나`compareTo()`는 음수, 0, 양수를 반환해서 정렬 순서를 결정한다.

## 정리
- `Comparable` = 기본 정렬 기준
- `Comparator` = 별도의 정렬 기준
- `compareTo()` = 자기 자신과 다른 객체 비교
- `compare()` = 두 객체를 별도의 정렬 기준으로 비교

