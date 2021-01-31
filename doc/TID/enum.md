자바의 열거형
===
학습요약
---
+ [enum 정의하는 방법](#enum-정의하는-방법)
+ [enum이 제공하는 메소드](#enum이-제공하는-메소드)
+ [java.lang.Enum](#javalangenum)
+ [EnumSet](#enumset)

### enum이란
열거형(enum)은 자바 데이터 타입 중 참조타입의 한 종류이다.  
서로 관련된 상수를 편리하게 선언하기 위한 것으로 여러 상수를 정의할 때 사용하면 유리하다.  
처음엔 자바에 열거형이라는 것이 존재하지 않았으나 JDK1.5부터 새롭게 추가되었다.  
자바의 열거형은 열거형이 가지는 값만 관리하는 것이 아니라 타입까지 관리하기 때문에 논리적인 오류를 줄일 수 있다.

### enum 정의하는 방법

```java
class Card {
    static final int CLOVER = 0;
    static final int HEART = 1;  
    static final int DIAMOND = 2;
    static final int SPADE = 3;

    static final int ACE = 0;
    static final int TWO = 1;
    static final int THREE = 2;
}
```
위 코드를 열거형으로 바꾸면 아래와 같이 된다.
```java
class Card {
    enum Kind { CLOVER, HEART, DIAMOND, SPADE }
    enum Value { ACE, TWO, THREE }
}
```

자바의 열거형은 <b>타입에 안전한 열거형(typesafe enum)</b>이라서 실제 값이 같아도 타입이  
다르면 컴파일 에러가 발생한다. 값 뿐만 아니라 타입까지 체크하기 때문에 타입에 안전하다고 한다.

```java
    if(Card.CLOVER == Card.TWO)             // true이지만 false이어야 의미상 맞음
    if(Card.Kind.CLOVER == Card.Value.TWO)  // 컴파일 에러. 값은 같지만 타입이 다름
```

<img src="/assets/img/study/enum01.png" width="70%" align="center"><br/>
<img src="/assets/img/study/enum02.png" width="70%" align="center"><br/>

열거형 상수는 상수의 값이 바뀌어도 기존의 소스를 다시 컴파일하지 않아도 된다는 장점이 있다.

### 열거형의 정의
기본적으로 상수명은 대문자로 작성하고, 여러 단어일 경우 언더바로 이어주는 것이 관례이다.

&#9654; 기본적인 열거형의 정의

```java
    enum 열거형이름 { 상수명1, 상수명2, ... }

    enum JuSik { SAMSUNG, APPLE, TESLA, AMD, ... }
```
```java
    public enum 열거형이름 {
        상수명1,
        상수명2,
         ...
        상수명N;
    }

    public enum Week {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }
```
또는 열거형 상수에 괄호를 붙여서 값을 부여할 수 있다. 값을 부여하는 경우, 이에 해당하는 생성자도 함께 정의해줘야 한다.

&#9654; 데이터와 메소드가 있는 열거형의 정의

```java
    public enum JuSik {
        SAMSUNG(85600, -1.27),
        APPLE(158450, 0.17),
        TESLA(977313, -1.74),
        AMD(104817, -3.48),
        INTEL(61102, -0.91);

        private final double closingPrice;
        private final double fluctuationRate;

        JuSik(double closingPrice, double fluctuationRate) {
            this.closingPrice = closingPrice;
            this.fluctuationRate = fluctuationRate;
        }

        public double getCP() {
            return closingPrice;
        }
        public double getFR() {
            return fluctuationRate;
        }
    }
```
switch문의 조건식으로 열거형을 사용할 수 있다. 이 때 주의할 점은 case문에 열거형의 이름은 적지 않고 상수의 이름만 적어야 한다는 제약이 있다.


### 열거형의 사용

&#9654; App.java

```java
package me.gracenam.study.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============== HTS START ===============");
        Krx krx;
        Nasdaq nas;
        System.out.println("============ 거래소를 선택해주세요 ============");
        System.out.println("========== 1. KRX / 2. NASDAQ ===========");
        int n = sc.nextInt();

        if(n == 1) {
            System.out.println("============ KRX를 선택하셨습니다. ============");1
            System.out.println("========== 원하시는 회사를 입력해주세요 ==========");
            String stock_name1 = sc.next();
            Krx krx_1 = Krx.valueOf(stock_name1);
            System.out.println(krx_1 + "의 종가는 " + krx_1.getCP() + "원 입니다.");
            System.out.println("변동은 전일 대비 " + krx_1.getFR() + "% 입니다.");
        } else if(n == 2) {
            System.out.println("=========== NASDAQ을 선택하셨습니다. ==========");
            System.out.println("========== 원하시는 회사를 입력해주세요 ==========");
            String stock_name2 = sc.next();
            Nasdaq nas_1 = Nasdaq.valueOf(stock_name2);
            System.out.println(nas_1 + "의 종가는 " + nas_1.getCP() + "달러 입니다.");
            System.out.println("변동은 전일 대비 " + nas_1.getFR() + "% 입니다.");
        }

        System.out.println("================ HTS END ================");
    }
}
```

&#9654; Krx.java

```java
package me.gracenam.study.app;

public enum Krx {
    SAMSUNG(85600, -1.27),
    NAVER(355500, 4.10),
    KAKAO(461500, -0.75);

    private final double closingPrice;
    private final double fluctuationRate;

    Krx(double closingPrice, double fluctuationRate) {
        this.closingPrice = closingPrice;
        this.fluctuationRate = fluctuationRate;
    }

    public double getCP() {
        return closingPrice;
    }
    public double getFR() {
        return fluctuationRate;
    }
}
```

&#9654; Nasdaq.java

```java
package me.gracenam.study.app;

public enum Nasdaq {
    APPLE(142.06, -0.77),
    TESLA(864.16, -2.14),
    AMD(88.84, -6.20),
    INTEL(53.59, -2.93);

    private final double closingPrice;
    private final double fluctuationRate;

    Nasdaq(double closingPrice, double fluctuationRate) {
        this.closingPrice = closingPrice;
        this.fluctuationRate = fluctuationRate;
    }

    public double getCP() {
        return closingPrice;
    }
    public double getFR() {
        return fluctuationRate;
    }
}
```

<img src="/assets/img/study/enum03.png" width="70%" align="center"><br/>

### enum이 제공하는 메소드

```java
public final String name()
public final int ordinal()
public String toString()
public final boolean equals(Object obj)
public final int hashCode()
public int compareTo(E obj)
public static <T extends Enum> T valueOf(Class enumType,String name)
public final Class <E> getDeclaringClass() // enum 객체의 타입 반환
public final Object clone() throws CloneNotSupportedException
protected final void finalize()
```

`toString()`과 `name()`은 사실 같은 역할을 하는데 둘의 차이는 Override가 가능한가 불가능한가의 차이이다. 이는 final에 의해 발생하는 차이이다.

+ <b>name( )</b>
열거형 상수의 이름을 문자열로 반환한다.
+ <b>ordinal( )</b>
열거형 상수가 정의된 순서(0부터 시작)를 정수로 반환한다.
+ <b>toString( )</b>
열거형 상수의 이름을 문자열로 반환한다.
+ <b>compareTo( )</b>
정렬의 기준을 위한 메서드로 비교 대상보다 순서가 빠르면 -1, 같으면 0, 느리면 1을 반환한다.
+ <b>valueOf(enumType, name)</b>
지정된 열거형에서 name과 일치하는 열거형 상수를 반환한다.
+ <b>getDeclaringClass( )</b>
열거형의 Class 객체를 반환한다.
+ <b>values( )</b>
열거형의 모든 상수를 배열에 담아 반환한다.

### java.lang.Enum
&nbsp;&nbsp;&nbsp;모든 열거 타입은 컴파일 시 java.lang.Enum 클래스를 상속받는다.  
따라서 단일 상속만 허용되는 자바이기 때문에 enum은 별도의 상속을 받을 수 없다.

java.lang.Enum 클래스도 최고조상인 Object클래스를 상속받는데, 대부분은 final이어서  
Override할 수 없지만 toString 메소드는 final이 아니어서 사용할 수 있다.

```java
package java.lang;

import java.io.Serializable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {

    private final String name;

    public final String name() { return name; }

    private final int ordinal;

    public final int ordinal() { return ordinal; }

    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String toString() { return name; }

    public final boolean equals(Object other) {return this==other;}

    public final int hashCode() { return super.hashCode();}

    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final int compareTo(E o) {
        Enum<?> other = (Enum<?>)o;
        Enum<E> self = this;
        if (self.getClass() != other.getClass() && // optimization
            self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }

    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> clazz = getClass();
        Class<?> zuper = clazz.getSuperclass();
        return (zuper == Enum.class) ? (Class<E>)clazz : (Class<E>)zuper;
    }

    public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
        T result = enumType.enumConstantDirectory().get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException(
            "No enum constant " + enumType.getCanonicalName() + "." + name);
    }

    protected final void finalize() { }

    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}
```

### EnumSet
&nbsp;&nbsp;&nbsp;EnumSet은 Set 인터페이스를 기반으로 열거형 타입으로 지정해놓은  
요소들을 보다 빠르게 배열처럼 다룰수 있는 기능을 제공한다.

EnumSet은 모든 메소드가 static 키워드를 사용하여 정의되어 있기 때문에 별도의 객체 생성없이  
사용할 수 있다고 하는데 사실은 객체를 생성할 수 없는 것이다.  
[API 문서](https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html)를 보면  
알 수 있듯이 이 클래스는 abstract 키워드를 사용한 추상 클래스이기 때문이다.

+ <b>allOf(Class<E> elementType)</b>
지정한 Type의 모든 원소를 포함하는 EnumSet을 만든다.
+ <b>clone()</b>
이 집합의 복사본을 반환한다.
+ <b>complementOf(EnumSet<E> s)</b>
지정한 EnumSet에 포함되지 않은 원소만 갖는 동일한 Type의 EnumSet을 만든다.
+ <b>copyOf(Collection<E> c)</b>
지정한 Collection에서 초기화된 EnumSet을 만든다.
+ <b>copyOf(EnumSet<E> s)</b>
지정한 EnumSet과 동일한 Type을 가진 EnumSet을 만든다. 이 때, 처음과 동일한 원소(원소가 있는 경우)를 포함한다.
+ <b>noneOf(Class<E> elementType)</b>
지정한 Type을 가지는 빈 EnumSet을 만든다.
+ <b>of(E e)</b>, of(E first, E... rest), of(E e1, E e2)
지정한 원소(또는 원소들)를 포함하는 EnumSet을 만든다.
+ <b>range(E from, E to)</b>
지정된 두 원소 사이에 있는 모든 원소를 포함하는 EnumSet을 만든다.

&#9654; EnumSet 예제

```java
package me.gracenam.study.week11;

import java.util.EnumSet;

public class EnumSetEx {
    public static void main(String[] args) {
        EnumSet<Champ> enumSet = EnumSet.allOf(Champ.class);

        System.out.println("> 전부 출력");
        System.out.println(enumSet);
        System.out.println();

        EnumSet<Champ> fureAd = EnumSet.of(Champ.VAYNE, Champ.CAITLYN);

        System.out.println("> 특정 원소만 출력(퓨어AD)");
        System.out.println(fureAd);
        System.out.println();

        System.out.println("> 퓨어AD를 제외하고 출력");
        System.out.println(EnumSet.complementOf(fureAd));
        System.out.println();

        System.out.println("> 범위 출력(초창기 원딜)");
        System.out.println(EnumSet.range(Champ.MISSFORTUNE, Champ.VAYNE));
        System.out.println();
    }
}

enum Champ {
    MISSFORTUNE, ASH, CAITLYN, VAYNE, KAISA, SENNA
}

```

<img src="/assets/img/study/enum04.png" width="70%" align="center"><br/>

---
**Reference**
+ [자바의 정석 3/e](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788994492032)
+ [Java in a Nutshell](https://www.amazon.com/Java-Nutshell-Desktop-Quick-Reference/dp/1492037257/ref=sr_1_1?dchild=1&keywords=Java+in+a+Nutshell&qid=1605393888&s=books&sr=1-1)
+ [오라클 공식 가이드](https://docs.oracle.com/javase/tutorial/java/TOC.html)
+ <https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html>
+ [java language specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.9)
