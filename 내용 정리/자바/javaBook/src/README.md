# JAVA 연습 및 내용정리

## 목차
0. [메서드](#0-메서드)
1. [출력함수](#1-출력함수)
2. [자료형](#2-자료형)
3. [형변환](#3-형변환)
4. [Scanner](#4-scanner)
5. [연산자](#5-연산자)
6. [분기문](#6-분기문)
7. [반복문](#7-반복문)
8. [객체지향](#8-객체지향)
9. [정보은닉 / 캡슐화](#9-정보은닉-캡슐화)
10. [배열](#10-배열)
11. [static](#11-static)
12. [상속](#12-상속)
13. [추상화 / 인터페이스](#13-추상화-인터페이스)
14. [자바 기본 API](#14-자바-기본-API)
15. [예외처리](#15-예외처리)
16. [제네릭](#16-제네릭)
17. [컬렉션](#17-컬렉션)
18. [Swing](#18-Swing)

 - - -


## 0. 메서드
`메서드는 함수와 동일한 뜻을 가짐`

> 메서드의 종류

  + 라이브러리 메서드 : 미리만들어져 제공되는 메서드
  + 사용자정의 메서드 : 개발자에 의해 만들어지는 메서드
  + main 메서드 : 최초 실행 메서드

> 메서드의 반환타입
+ 메서드의 반환타입은 반환할 데이터의 유형을 지정하며, 반환값이 필요하지 않으면 void를 사용

**예시**
```
public class ch00HelloWorld {
	public static void main(String[] args) { // 메인메서드
		System.out.println("hello world"); // 라이브러리 메서드
	}

	public int add(int a, int b) {  // 반환값이 int인 메서드
    		return a + b;
	}

	public void printMessage(String message) {  // 반환값이 없는 메서드
    		System.out.println(message);
	}
}
```
- - -

## 1. 출력함수
> System.out.print()
+ \n : 줄바꿈
+ \b : 백스페이스
+ \t : 탭길이(만큼 커서 이동)

> System.out.printf()
+ %d : 10진수 정수 서식문자
+ %f : 10진수 실수 서식문자
+ %o : 8진수 서식문자
+ %x : 16진수 서식문자
+ %c : 한문자 서식문자
+ %s : 문자열 서식문자

> System.out.println()
+ \n(줄바꿈)이 기본적으로 들어가있는 형태

- - -

## 2. 자료형
> 변수
+ 개발자의 유지보수 측면에서 바뀔 예정이 큰 수

> 변수명
+ 저장되어있는 변수 공간에 접근하기위한 문자 형태의 주소

> 기본자료형
+ 정수 부호
1. byte : 1byte
2. short : 2byte | char - 2byte(양수만)
3. int : 4byte
4. long : 8byte

+ 실수 부호
1. float : 4byte(6~9자리)
2. double : 8byte(15~18자리), 기본자료형

> 클래스자료형

`클래스자료형으로 만든 변수를 '참조변수'라고 하고 메모리주소값이 저장된다`

+ String : 문자열

+ boolean : 논리형(true/false 저장)

> 상수
+ 리터럴 상수 : 이름부여 X, 상수 Pool에 저장, 단순한 값
   + 리터럴 접미사 : 리터럴 상수가 저장되는 자료형을 지정
    + L,l : long 자료형
    + F,f : float 자료형
+ 심볼릭 상수 : 이름부여 O, final 예약어 사용

  
## 3. 형변환
`형변환 : 연산시 일치하지않는 자료를 일치시키는 작업`

+ 자동형변환 : 컴파일러에 의해 자동 형변환

```
범위가 넓은 공간에 작은값이 대입되는 경우 자동형변환이 일어난다
ex ) byte a = 10;
     int b = a;
```

+ 강제형변환 : 프로그래머에 의해 강제 형변환
  
```
ex ) int intVal = 44032;
     char charVal = (char)intVal; // 강제형변환
     System.out.println((int)charVal); //44032
```

## 4. Scanner
+ Scanner : 데이터 입력 클래스
+ System.in : 표준입력 스트림 생성(요청)
+ System.out : 표준출력 스트림 생성(요청)
```
Scanner "변수명" = new Scanner(System.in);
sc.close(); // 불필요한 데이터 누수 차단
```

## 5. 연산자
> 기본 산술 연산자
```
int a = 10, b = 20
System.out.println("a+b="+ (a + b)); // 30
System.out.println("a-b="+ (a + b)); // -10
System.out.println("a*b="+ (a * b)); // 200
System.out.println("b/a="+ (b / a)); // 2(나누기 - 몫)
System.out.println("a%b="+ (a & b)); // 10(나누기 - 나머지)
```
> 대입 연산자
+ 공간 = 값(우선처리)

> 복합 대입 연산자
```
int a = 10;
a += 10; //a = a + 10;
a -= 5; // a = a-5;
a *= 3; // a = a*3;
```
> 비교 연산자
```
int a =10;
int b=20;
System.out.println("A == B : "+ (a == b)); // false
System.out.println("A > B : "+ (a > b)); // false 
System.out.println("A < B : "+ (a < b)); // true
System.out.println("A >= B : "+ (a >= b)); // false
System.out.println("A <= B : "+ (a <= b)); // true
System.out.println("A != B : "+ (a != b)); // true
```
> 논리 연산자
+ AND연산자 && : &&기호를 기준으로 왼/오른쪽 둘다 true여야 true값 배출
+ OR연산자 || : ||기호를 기준으로 왼/오른쪽 중 하나만 true여도 ture값 배출
+ !연산자 : ture이면 false, false이면 true 값 배출

> 증감 연산자
+ 전치연산자 ++a : 먼저 값을 1증가시킨후 다른 연산자 처리
+ 후치연산자 a++ : 다른 연산자 처리후 값1증가

> 삼항연산자
+ (조건식)? 참인경우의 실행코드 : 거짓인 경우의 실행코드;

## 6. 분기문
> if
+ 조건식을 걸어 조건이 참이면 실행 아니라면 실행을 하지않게하는 문법
  
> else
+ 조건식이 참이 아닌 예외경우에 실행시킬 코드를 작성하는 곳

> else if
+ 조건식에 추가 분기를 넣는 문법

```
ex) System.out.println("나이 : ");
    int age = sc.nextInt();
    if(age >= 8) {
      System.out.println("초등학교에 다닙니다");
    } // age의 값이 8이상이라면 문장출력
    else if(age >=14) {
      System.out.println("중학교에 다닙니다");
    } // age의 값이 14이상이라면 문장출력
    else {
      System.out.println("학교에 다니지 않습니다");
    } // 예외경우에 문장출력
    System.out.println("프로그램을 종료합니다");
```
> switch
+ case별로 실행될코드를 따로 지정하는 문법

```
ex) Scanner sc = new Scanner(System.in);
    int ranking = sc.nextInt();
    char medalColor;
    switch (ranking) {
    case 1:
      medalColor = 'g';
      System.out.println("매달색상 : g");
      break; // 멈춤역할
    case 2:
       medalColor = 's';
       System.out.println("매달색상 : s");
       break;
    case 3:
       medalColor = 'b';
       System.out.println("매달색상 : b");
       break;
     default: // 기본값
       medalColor = 'c';
       System.out.println("매달색상 : c");
      }
      System.out.println(ranking + "등 매달 색은 " + medalColor + "입니다");
```

## 7. 반복문
> for : 반복 횟수가 정해져 있을 때 사용, 반복할 횟수나 범위를 미리 알고 있을 때 주로 사용

```
for(int i=0, i<=5, i++){ //초기화, 조건, 증감
  System.out.printf("hello wolrd %d",i) 
};
```

> 개량 for문 : 컬렉션이나 배열을 반복하고싶을때 사용함

```
List<String> lists = new ArrayList(); // 배열생성
list.add("java");
~~~
list.add("oracle");

for(String subject : lists) { //타입 변수명 : 컬렉션이나 배열
   System.out.println(subject)
}
``` 

> while : 반복 횟수가 정해져 있지 않거나 반복 조건을 먼저 확인하고 실행할 때 사용

```
int i = 0;
while(true) { // 무한반복
  System.out.printf("hello wolrd %d",i)
  i++
};
```

## 8. 객체지향
> 객체란?

` 공간을 차지하는 사물(Object)을 지칭`

> 객체의 기본구조
+ 속성(Attribute) : 객체마다 구별되는 데이터(저장 - 변수처리)
+ 기능(Function) : 객체가 수행할 수 있는 공통 액션(기능 - 매서드처리)

> 객체 지향의 정의

`현실 세계의 여러 객체의 정보(속성/기능)중에 필요한 일부만 추출하여 문제 해결을 하기 위한 요소단위로 적재(저장)하기 위해 고안된 문법`

> 클래스
+ 동일한 종류의 객체에 필요한 메모리공간을 제공하기 위해 선언된 자료형
+ 클래싀 자료형에 의해 객체가 정의되는 순간 클래스에서 선언한 속상과 기능대로 메모리공간의 형성이 이루어진다

> 자바의 메모리 영역
1. 스택영역 : {}(중괄호) 내에서 생성되고 소멸되는 영역(int, double)
2. 클래스영역(메서드영역) : 공유메모리 영역(생성자, 일반메서드, static메서드, static변수)
3. 힙영역 : 객체 저장 영역(new 예약어 사용시 할당)

> *예시*
```
Scanner sc = new Scanner(System.in)
```
+ 힙 메모리 영역에 Scanner에 필요한 초기값이 담긴 객체 생성
+ 현위치(main stack)에 Scanner 자료형으로 만든 sc 참조변수에 Scanner객체의 시작메모리 주소 저장

> 클래스 변수
1. 맴버변수 : 클래스내부 ~ 메서드영역 바깥에서 생성, 생성된 객체의 개별 정보를 저장
2. static변수 : 동일 클래스로부터 만든 여러객체간을 공유하는 변수
3. 지역변수 : 메서드 영역 내(파라미터 포함)에서 혹은 {}(중괄호)범위에 생성되는 변수

```
ex) public class Test {
    int instanceVar = 10;  // 클래스 변수 (인스턴스 변수)

    public void method1() {
        int localVar = 5;  // 지역 변수
        System.out.println(instanceVar);
    }

    public void method2() {
        System.out.println(instanceVar);  // instanceVar 사용 가능
        // System.out.println(localVar); // 컴파일 에러, localVar는 method1에서만 유효
    }
}

```

> 오버로딩
+ 메서드의 이름은 같지만 파라미터가 다른(갯수,자료형) 메서드를 만드는것
+ 리턴타입만 다르고 파라미터가 같으면 오버로딩이 아님

> 가변인자
+ 자바에서 ...을 사용하면 메소드가 임의의 수의 인자를 받을 수 있게 된다(배열처럼 값을 받음)
```
ex) int sum(int... args) {
     System.out.println(args);
     int sum = 0;  
}
sum("n개의 숫자들");
```

> 생성자메서드
+ 객체 생성시 한번만 호출되는 메서드
+ 생성된 객체내에서는 사용 불가능
+ 겍체 생성시에 필요한 메모리공간 형성과 초기값 부여에 사용
+ 생성자 메서드 이름은 클래스 이름과 동일하며 반환자료형은 가지지 않는다

> this
+ 현재객체를 참조하는 키워드로 맴버변수와 지역변수를 구분한다

```
ex) class consturct {
	int n1;
	double n2;
	construct(){} // 기본생성자(없을경우 컴파일러가 생성)
	construct(int n1, double n2) {
		this.n1 = n1; // 맴버변수 n1과 지역변수 n1을 구분
		this.n2 = n2;
	}
}
```

## 9. 정보은닉-캡슐화
> 접근한정자
+ private - 현재 클래스에서만 사용가능
+ default - 같은 패키지에서만 사용가능
+ protected - 상속관계에 있거나 같은 패키지에서만 사용가능
+ public - 모든 객체에서 사용가능

> 캡슐화
+ 특정 목적을 가지는 기능을 구현하는데 필요한 세부 기능들을 묶어서 처리하는 방법
+ 각 과정의 일부나 전부가 외부로 노출되는 문제를 막기 위해 정보은닉(Private)을 수반한다

> getter, setter
+ getter: 객체의 필드 값을 반환하는 메서드
+ setter: 객체의 필드 값을 수정하는 메서드

```
ex) class Person {
	Private String name;
	Private int age;
	Private String addr;

	Person(){} // 기본생성자
	public person(String name, int age, String addr) { // 초기값 부여
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	//getter 함수(데이터를 외부로 반환)
	public String getName() {
		return name;
	}
	//setter 함수 (기존데이터를 수정)
	public void setAge(int age) {
		this.age = age;
	}
}
```

## 10. 배열
> 배열
+ 배열 선언 : 배열은 특정 타입의 변수 여러 개를 하나로 묶는 방식
+ 배열 크기 : 배열의 크기는 한 번 선언되면 변경할 수 없음(크기고정)
+ 배열 인덱스 : 배열의 요소는 0부터 시작하는 인덱스를 통해 접근할 수 있음

```
ex)
int[] arr = new int[5];  // 크기 5인 int형 배열 생성
int[] arr = {1, 2, 3, 4, 5};  // 배열 선언과 초기값을 동시에 할당
// 자바 배열의 길이는 한번정해지면 바꿀수없음
// 동적인 배열을 사용하기위해선 ArrayList를 사용

```
> 다차원 배열
`int[][] arr = new int[2][5]`

## 11. static
> static
+ static을 사용하게 되면 변수나 메소드를 객체생성 없이 사용이 가능하다
+ 클래스 이름으로만 static 맴버에 접근이 가능하다

> static 변수
+ 클래스의 모든 인스턴스가 공유하는 변수

```
class MyClass {
    static int count = 0;  // 클래스 변수

    MyClass() {
        count++;  // 객체 생성 시마다 count 증가
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        System.out.println(MyClass.count);  // 2
    }
}

```

> static 메서드
+ 클래스의 static 변수와만 상호작용할 수 있고, 인스턴스 변수나 인스턴스 메소드를 사용할 수 없음

```
ex)
class MyClass {
    static int add(int a, int b) {
        return a + b;
    }
}
public class Main {
    public static void main(String[] args) {
        int result = MyClass.add(5, 3);  // 객체 생성 없이 클래스 이름으로 호출
        System.out.println(result);  // 8
    }
}
```

## 12. 상속
> 상속이란?
+ 상위클래스의 속성과 기능을 하위 클래스에서 그대로 물려받는 문법
+ 상속을 받은 하위클래스는 상속받으 기능 및 속성을 고쳐쓰거나 그 외의 것들을 추가할수있다
+ 확장성이 뛰어나고 유지보수가 편하며 코드의 중복이 적어지기에 가독성이 좋아진다
```
ex) class point2D {
	int x;
	int y;
	point2D(){
		System.out.println("point2d default");
	}
  }
    class point3D extends point2D { // extends "상위클래스"
	int z;
	point3D(){
		super(); // 상위클래스 point2D() 생성자 호출
		System.out.println("point3d default");
	}
	@Override // toString 재정의
	public String toString() {
		return "point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
}
```
> 오버라이딩
+ 상속관계를 전제하에 상위클래스의 메서드를 하위클래스가 재정의 하는 것
+ 하위클래스에서 다른 기능 구현이 가능함
+ 오버로딩과의 차이점은 상속관계일때만 가능하고 함수의 로직(기능)만을 변경한다

```
ex) class Animal{
	void sound() {
		System.out.println("소리낸다");
	}
}
    class Dog extends Animal {
	@Override // 함수의 기능만을 재정의
	void sound() {
		System.out.println("멍멍");
	}
}
```
> UpCasting
+ 상위클래스 참조변수 = 하위클래스형 객체(자동형변환)
+ 상위클래스가 이해하는 범위내에서 사용가능
+ 상속관계로 연결된 모든 하위객체를 연결할 수 있다

> DownCasting
+ 하위클래스 참조변수 = 상위클래스형 객체(강제형변환)
+ UpCasting이 되어있는 객체만 사용가능

> Up,DownCasting 예시
```
ex)
class Super {
	int n1;
}
class Sub extends Super{
	int n2;
}
public class ch06upDownCasting {
	public static void main(String[] args) {
		// NoCasting (자료형의 일치)
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 10;
		ob2.n2 = 20;
		
		// UpCasting
		Super ob3 = new Sub();
		ob3.n1 = 100;
		Super ob4 = ob2;
		ob4.n1 = 110;
		
		// DownCasting
	        //Sub ob5 = (Sub)ob1; // ob1은 Super만을 가르키기 때문에 Sub클래스로 DownCasting이 불가능하다
		Sub ob6 = (Sub)ob3; // ob3의 자료형은 Super지만 Sub클래스를 가르키기때문에 DownCasting이 가능하다		
	}
}
```

## 13. 추상화-인터페이스
> 추상클래스, 추상메서드
+ 헤더만 구현되어있고 기능은 구현되어있지않은 메서드
+ 추상메서드가 있는 클래스는 추상클래스로 정의해야한다
+ 추상클래스는 인스턴스화 즉 객체생성에 사용될수없다
+ 추상클래스를 상속받는 일반클래스가 추상메서드를 오버라이딩해서 정의한다음 객체를 완성해야한다
+ 프로그램을 동일한 규격으로 만들 수 있도록 가이드를 제공하기 위해 사용

```
ex)
package ch13;

// 일반 클래스 상속관계
class Super1 {
	void func() {} // 이미 완성된 메서드기에 Sub1의 오버라이드된 메서드를 주석처리하여도 문제없음
}

class Sub1 extends Super1 {
//	@Override
//	void func() {
//		System.out.println("override sub1.func() call");
//	}
}

// 추상클래스 상속관계
abstract class Super2{
	abstract void func(); // 추상메서드기 때문에 Sub2의 오버라이드된 메서드를 정의해야함
}

class Sub2 extends Super2{
	@Override
	void func() {
		System.out.println("override sub2.func() call");
	}
}

public class ch01abstract {

	public static void main(String[] args) {
		Super1 s1 = new Sub1();
		s1.func();
		
//		Super2 s2 = new Super2(); // 추상클래스여서 객체생성 불가능
//		Sub2 s2 = new Sub2(); // 하위클래스로 객체생성은 가능하지만 추상메서드를 정의해야함
		Super2 s2 = new Sub2();
		s2.func();
	}

}

```
	
> 인터페이스
+ 메서드 : 일반 메서드없이 전부 추상메서드로만 구성
+ 속성 : 일반 맴버 필드는 없고 public static final로 선언된 상수만 있음
+ 객체생성이 불가하고 implements키워드를 이용하여 다른 클래스로 구현할때 객체 생성이 가능
+ 구현된 클래스에서는 반드시 추상메서드를 재정의해야함

```
ex)
interface Remote { // 인터페이스 설정
	Scanner sc = new Scanner(System.in);
	int MAX_VOL=100; //public static final
	int MIN_VOL=1;
	void setVolumn(int vol);
	void PowerOn(); //abstract
	void PowerOff();
}
class TV implements Remote {
	@Override
	public void PowerOn() { // 추상메서드 재정의
		System.out.println("TV를 켭니다");
	}

	@Override
	public void PowerOff() { // 추상메서드 재정의
		System.out.println("TV를 끕니다");
	}
	
	@Override
	public void setVolumn(int vol) {
		if(vol>MAX_VOL) {
			vol = MAX_VOL;
			System.out.printf("티비볼륨을 %d으로 설정합니다",vol);
		} else if(vol<MIN_VOL) {
			vol = MIN_VOL;
			System.out.printf("티비볼륨을 %d으로 설정합니다",vol);
		} else {
			System.out.printf("티비의 현재 볼륨은 %d입니다",vol);
		}
	}
}
```

## 14. 자바 기본 API

> 자바 API
+ 자바 API(Java API)는 자바 플랫폼에서 제공하는 다양한 클래스, 인터페이스, 메서드의 모음이다
+ 자바 API는 매우 방대하기 때문에 자바 공식 문서 사이트에서 최신 자바 API 문서를 찾아봐야한다
+ [자바 공식 사이트](https://docs.oracle.com/javase/8/docs/api/)

> 자바 API의 구조
자바 API는 패키지(package)로 구성되며 각 패키지는 관련된 클래스와 인터페이스의 집합이다

1. java.lang : 자바 프로그램의 기본적인 클래스들이 포함되어 있는 패키지, 이 패키지에는 자바의 가장 중요한 클래스들이 포함됨
2. java.util : 유틸리티 클래스를 제공하는 패키지, 컬렉션 프레임워크, 날짜와 시간, 랜덤 숫자 생성 등을 다룸
3. java.io : 입력/출력과 관련된 클래스들을 포함한 패키지, 파일 입출력, 스트림, 버퍼링, 직렬화 등을 처리함
4. java.net : 네트워크 관련 클래스를 제공하는 패키지, URL, 소켓, 서버와 클라이언트 통신 등을 다룰 수 있음
5. java.awt와 javax.swing : GUI를 위한 클래스를 제공하는 패키지
6. java.sql : 데이터베이스와의 연동을 위한 클래스를 제공하는 패키지, JDBC를 사용하여 SQL 데이터베이스와 통신가능

> 기본 API 클래스
1. Object.class
   + 모든 클래스의 부모 클래스
   + extends 키워드로 다른 클래스를 상속하지 않으면 java.lang.Object 클래스를 상속
   + 자바의 모든 클래스는 Object 클래스의 자식,자손 클래스이다
2. toString()
   + 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
   + 일반적으로 그 객체가 설명하는 문자열을 리턴
3. equals()
   + 두 객체가 동일객체인지 동등비교시 사용(boolean형 배출)
4. hashcode()
   + hashcode : 객체를 식별하는 하나의 정수값
   + hcashCode() : JVM이 객체를 식별하기 위해 부여한 정수형태의 위치값을 반환하는 함수
5. clone()
   + 객체를 복제하는데 사용되는 메서드
6. System.class
   + 운영체제의 일부 기능을 이용할 수 있도록 설계된 클래스

> java.lang
1. String
   + 문자열 처리를 위한 클래스, 자바에서 문자열은 자료형이 아닌 객체타입이다
2. StringBuffer
   + 성능에 영향을 받지않고 문자열 처리를 하는 클래스, 긴 문자열을 사용할때 쓰는것이 좋다
3. Wrapper
   + 기본 데이터 타입을 객체타입으로 처리 할 수 있게 해주는 클래스
     
     
   | 기본데이터 타입 | Wrapper 클래스 |
   |---|---|
   | byte | Byte |
   | short | Short |
   | int | Integer |
   | long | Long |
   | float | Float |
   | double | Double |
   | char | Character |
   | boolean | Boolean |

   + Autoboxing과 Unboxing 기능을 제공하는데 자동 박싱은 기본 타입을 자동으로 해당 Wrapper 객체로 변환하고, 자동 언박싱은 Wrapper 
     객체를 기본 타입으로 자동으로 변환함

   + 사용법
   ```
   int num1 = 10;
   Integer numWrapper = Integer.valueOf(num1);  // int를 Integer로 감쌈

   Integer num = 10;  // int가 자동으로 Integer 객체로 변환됨
   Integer numWrapper = 10;  // Integer 객체가 자동으로 기본 int로 변환됨
   int num = numWrapper;  // 자동으로 int로 변환됨
   
   ```

   + Integer 클래스의 주요 필드/메서드
   
     | 필드/메서드 | 설명 |
     |---|---|
     | static int MAX_VALUE | int로 표현가능한 최대 크기의 수 |
     | static int MIN_VALUE | int로 표현가능한 최소 크기의 수 |
     | static SIZE | 2의 보수 형태로 표현된 정수형의 비트 수 |
     | double doubleValue() | int를 double로 변환 |
     | static int parseInt(String s) | 문자열 숫자를 int로 리턴 |
     | static Integer valueOf(String s) | 문자열값을 Integer로 변환 |

> java.util
1. 날짜 관련 클래스
   + Date : 인스턴스 생성 후 메서드를 호출하여 원하는 기능을 사용하는 방식으로 사용
   + Calendar : 특정 날짜 설정, 날짜 연산, 타임존이 필요한 경우 사용
2. Scanner 클래스
   + 입력 스트림으로 부터 데이터를 입력받는 클래스
   + 객체를 생성할 때 입력 스트림을 변경하면 키보드외에 파일, 네트워크 등에서도 데이터를 입력 받을 수 있다.

> java.text
1. SimpleDateFormat
+ 날짜와 시간을 포맷팅하고 파싱하는 데 사용됨
+ 주로 문자열을 날짜 객체로 변환하거나 날짜 객체를 문자열로 변환할 때 사용됨

2. LocalDateTime
+ Java 8에서 새롭게 도입된 Java 8 날짜/시간 API다
+ java.time 패키지에 속하는 클래스다
+ 날짜와 시간을 모두 포함하는 불변 객체이다

> 사용법

```
// SimpleDateFormat
public static void main(String[] args) throws ParseException {
	Scanner sc = new Scanner(System.in);
	System.out.println("YYYY/MM/DD 입력 : ");
	String ymd = sc.next();
		
	//포매터 객체 생성(입력용)
	SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd");
	System.out.println(ymd);
	Date date = fmtin.parse(ymd);
	System.out.println(date);
		
	//포매터 객체 생성(출력용)
	SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd");
	System.out.println(fmtout.format(date));
}

// LocalDateTimeFormat
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("YYYY/MM/DD 입력 : ");
	String ymd = sc.next();
		
	// 입력용 포매터
	DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
	// 문자열을 LocalDate로 변환
	LocalDate date = LocalDate.parse(ymd, inputFormatter);
	System.out.println("입력된 날짜" + date);
		
	// 출력용 포매터
	DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy~MM~dd");
		
	// 포맷 변경 후 출력
	System.out.println("변환된 날짜" + date.format(outputFormatter));
		
	sc.close();
}
```

## 15. 예외처리
> 에러
+ Compile time 에러 : 컴파일시에 발생하는 에러
+ Run time 에러 : 작동시에 발생하는 에러

> 예외 클래스
+ Throwable : 에러와 예외를 모두 나타내기위한 클래스
+ exception : 예외의 최상위 클래스
+ error : 에러의 최상위 클래스

> try,catch
+ 컴파일러가 try구문에서 예외가 발생하는지 검사하고 만약 있다면 catch구문에서 예외발생시 작동하는 코드를 실행한다

```
ex)
try {
	String str = null; //NullPointException 발생
	Syetem.out.println(str.toString());
}
catch(NullPointerException e) { // 해당 예외 클래스
	System.out.println("예외 발생 : " + e);
	System.out.println(e.getCause()); // 예외 이유 출력
	System.out.println(e.toString()); // 예외 메시지 출력
	e.printStackTrace(); // 예외 정보 출력
} finally{
	System.out.println("Hello wolrd") // 무조건 실행
}
```

## 16. 제네릭
> 제네릭

## 17. 컬렉션
> List
+ 자료를 일렬로 나열하여 저장하는 방식
+ 배열과 유사하나 데이터 저장시 필요한만큼 공간이 자동 증가
>> ArrayList
```
List<String> list = new ArrayList();

//추가
list.add("HTML/CSS/JS");
list.add("JQUERY");
list.add("NODEJS");

//조회
System.out.println("갯수 확인 : " + list.size());
System.out.println("idx로 조회 : " + list.get(2));
System.out.println("value로 idx확인 : " + list.indexOf("JQUERY"));
list.forEach(System.out::println);

//삭제
list.remove(1);
list.remove("NODEJS");

//전체 삭제
list.clear();
```
> Set
+ 저장 순서가 유지되지 않는 형태의 저장
+ 순서와 상관없고 중복이 허용되지않는다

```
Set<Generic> set = new HashSet();
```

> Map
+ key값과 value값으로 구성
+ key는 중복 저장될 수 없지만 value는 중복저장 가능
+ 기존의 key와 동일한 key로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체

```
Map<String,Integer> map = new HashMap();
	// 추가
	map.put("aaa", 123);
	map.put("bbb", 456);
	map.put("ccc", 789);
	map.put("ccc", 999); // 중복key(나중에 put된 값을 덮어씀)
		
	//삭제
	map.remove("bbb");
		
	// 확인
	System.out.println(map.size());
	System.out.println(map.get("bbb"));
	System.out.println("---------------");
	for(String key : map.keySet()) {
		System.out.println(key + " : " + map.get(key));
	}
}
``` 

## 18. Swing
> Swing
