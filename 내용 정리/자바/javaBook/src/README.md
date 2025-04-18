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
19. [Java I/O](#19-java-io)
20. [보조입출력](#20-보조입출력)
21. [JDBC](#21-JDBC)
22. [소켓](#22-소켓)
23. [쓰레드](#23-쓰레드)
24. [Reflect](#24-Reflect)
25. [디자인패턴](#25-디자인패턴)
26. [람다스트림](#26-람다스트림)
27. [함수형 인터페이스](#27-함수형-인터페이스)
28. [클래스 다이어그램](#28-클래스-다이어그램)

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
+ 클래스 내부에서 데이터타입을 외부에서 지정하는 방법
+ 미지정된 데이터타입이기에 여러 데이터타입의 자료형을 적용가능하다
```
ex)
class Person<T> {
	public T info;
}
Person<String> p1 = new Person(); // 같은 제네릭 타입이면 생략이 가능하다
```

> 메서드 제네릭
+ 리턴 타입 앞에 <> 기호를 추가한다

> 제한
+ 상속을 사용하여 데이터타입을 특정 클래스의 자식으로 제한이 가능하다
```
ex)
class 호빵<T extends 호빵재료> {
	private T meterial;

	호빵(T meterial) {
		this.meterial = meterial;
	}

	@Override
	public String toString() {
		return "호빵 [meterial=" + meterial + "]";
	};
}

class 호빵재료 {
	
}

class 팥 extends 호빵재료{
	@Override
	public String toString() {
		return "팥";
	}
}

class 슈크림 extends 호빵재료{
	@Override
	public String toString() {
		return "슈크림";
	}
}

class 야채 extends 호빵재료{
	@Override
	public String toString() {
		return "야채";
	}
}

class 민트초코 { // 현재 민트초코는 호빵재료 클래스를 상속받지 않기때문에 사용할 수 없다
	@Override
	public String toString() {
		return "민트초코";
	}
}

public class ch01Generic {

	public static void main(String[] args) {
		호빵<팥> ob1 = new 호빵<팥>(new 팥());
		System.out.println(ob1);
		호빵<슈크림> ob2 = new 호빵<슈크림>(new 슈크림());
		System.out.println(ob2);
		호빵<야채> ob3 = new 호빵<야채>(new 야채());
		System.out.println(ob3);
//		호빵<민트초코> ob4 = new 호빵<민트초코>(new 민트초코());
//		System.out.println(ob4);
	}
}
```

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
+ Java에서 GUI 를 구축하기 위한 라이브러리

> 주요 특징
1. 플랫폼 독립성 : Swing은 완전히 Java로 작성되어 있기 때문에, 특정 운영 체제에 종속되지 않음 이를 통해, 작성한 GUI는 어떤 OS에서도 동일한 방식으로 동작가능
2. 모든 GUI 컴포넌트 제공 : 버튼, 텍스트 필드, 레이블, 체크박스, 콤보 박스, 메뉴 등 다양한 UI 컴포넌트를 제공
3. 기능 확장 가능 : Swing은 JComponent라는 기본 클래스를 상속하여 자신만의 새로운 UI 컴포넌트를 만들 수 있음
4. 플러그인 및 테마 지원 : 다양한 테마와 스타일을 적용할 수 있어, 사용자에게 보다 직관적이고 예쁜 UI를 제공할 수 있음

> 기본적인 Swing 구성 요소
+ JFrame : 기본적인 윈도우를 제공하는 컴포넌트
+ JPanel : 다양한 컴포넌트를 그룹화하는 데 사용되는 컨테이너
+ JButton : 버튼을 생성하는 클래스
+ JLabel : 텍스트나 이미지를 화면에 표시하는 클래스
+ JTextField : 사용자로부터 텍스트 입력을 받는 클래스


## 19. Java I/O
> JAVA I/O
+ 데이터를 읽고 쓰는 행위를 추상화시킨것

> Stream
+ 스트림은 데이터의 흐름을 나타내는 추상적인 개념
+ 데이터를 읽거나 쓸 때 발생하는 연속적인 바이트나 문자의 흐름을 나타냄
+ 스트림은 크게 바이트 스트림과 문자 스트림으로 나뉨

> Input
+ 바이트 단위로 데이터를 읽어들이는 클래스
```
InputStream fin = new FileInputStream("C:\\IOtest\\data.xlsx");
		StringBuffer stringBuffer = new StringBuffer(); // 버퍼 추가
		
		// read([])
		byte[] buf = new byte[4096];
		long sTime = System.currentTimeMillis();
		while(true) {
			int data = fin.read(buf);
			if(data == -1) break;
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요시간 : " + (eTime-sTime) + "ms");
		fin.close();
```

> Output
+ 바이트 단위로 데이터를 출력하는 클래스
```
OutputStream out = new FileOutputStream("C:\\IOtest\\test4.txt");
	out.write("가".getBytes(StandardCharsets.UTF_8));
	out.write('a');
	out.write('b');
	out.write('c');
	out.flush(); // 저장된내용 출력
	out.close(); // 리소스 해제
```

> Writer
+ 문자 단위로 데이터를 출력하는 클래스
```
import java.io.FileWriter;

Writer fout = new FileWriter("C:\\IOtest\\test1.txt",true); 
	fout.write("test1\n");
	fout.write("test2\n");
	fout.write("test3\n");
	fout.write("test4\n");
	fout.flush(); // 저장된내용 출력
	fout.close(); // 리소스해제
```

> Reader
+ 문자 단위로 데이터를 읽는 클래스
```
import java.io.FileReader;

Reader rd = new FileReader("C:\\IOtest\\test1.txt");
	int data = 0;
	StringBuffer buffer = new StringBuffer();
	while((data = rd.read())!=-1) {
		buffer.append(data);
	}
	System.out.println();
	System.out.println(buffer);
	rd.close();
	}
```

## 20. 보조입출력
> 버퍼 스트림
+ 데이터를 직접 파일에서 읽고 쓸 때, 버퍼라는 메모리 공간을 사용하여 성능을 향상시킴

> 데이터 변환 스트림
+ 기본적인 데이터 유형을 바이너리 형식으로 읽고 쓸 수 있도록 함

> 객체 스트림
+ 자바 객체를 직렬화하여 파일이나 네트워크로 전송할 수 있도록 함

## 21. JDBC
> JDBC
+ 자바와 데이터베이스간 연동을 해주는 API

> 사용법
```
String id = "root"; // 사용자 id
String pw = "1234"; // 사용자 pw
String url = "jdbc:mysql://포트번호/db명" // url


//JDBC참조변수
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Loading Success...");
	conn = DriverManager.getConnection(url,id,pw);
	System.out.println("DB CONNECTED...");
	}catch(Exception e) {
	e.printStackTrace();
	}finally {	
		try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
	}
```

> 트랜잭션
+ 데이터베이스에서의 연산을 하나의 단위로 묶어서 처리하는 것을 의미함
+ 트랜잭션은 여러 연산을 포함할 수 있지만, 모든 연산이 성공적으로 완료되거나, 어떤 문제가 생기면 모든 연산을 되돌리는 방식으로 관리됨

> 트랜잭션 ACID
1. 원자성
+ 트랜잭션은 "모두 또는 전혀 없음"의 원칙을 따름
+ 트랜잭션 내의 모든 작업이 성공적으로 수행되거나, 하나라도 실패하면 모든 작업이 롤백되어 초기 상태로 돌아감.

2. 일관성
+ 트랜잭션이 시작되기 전과 끝난 후 데이터베이스가 일관된 상태를 유지해야 함
+ 트랜잭션이 실행되기 전의 상태와 트랜잭션 후의 상태 모두 유효해야 함

3. 격리성
+ 트랜잭션은 다른 트랜잭션의 중간 결과를 볼 수 없음
+ 각 트랜잭션은 다른 트랜잭션과 독립적으로 실행되어야 하며, 여러 트랜잭션이 동시에 실행될 때도 서로 영향을 주지 않음

4. 지속성
+ 트랜잭션이 성공적으로 완료되면 그 결과는 영구적으로 저장됨
+ 시스템 장애가 발생하더라도, 이미 커밋된 트랜잭션의 변경 사항은 손실되지 않음

## 22. 소켓
> 소켓
+ 네트워크 통신을 위한 인터페이스
+ 두 시스템 간에 데이터를 주고받을 수 있도록 연결을 설정하는 역할

### 서버
```
public class ch02SocketServer {

	public static void main(String[] args) throws IOException {
		// 서버소켓 생성
		ServerSocket server = new ServerSocket(7000); // 서버 소켓생성 (포트번호)
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		Socket client = server.accept();
		
		System.out.println("server start");
		
		System.out.println(client.getInetAddress());
		
		OutputStream out = client.getOutputStream(); // 출력 스트림 생성
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream(); // 입력 스트림 생성
		DataInputStream din = new DataInputStream(in);
		
		// 내용교환(q:종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		
		while(true) {
			// 서버 -> 클라이언트 송신
			System.out.print("[Server(q:종료)] : ");
			send = sc.nextLine();
			if(send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
			
			// 클라이언트 -> 서버 수신
			recv = din.readUTF();
			if(recv.equals("q")) {
				break;
			}
			System.out.println("[Client ] : " + recv);
		}
		// 자원해제
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[Server] 연결 종료 합니다");
	}
```

### 클라이언트
```
public class ch02SocketClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("192.168.16.50", 7000); // 서버주소에 접속 ("주소",포트번호)

		System.out.println("client start");
		
		OutputStream out = client.getOutputStream(); // 출력스트림 생성
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream(); // 입력 스트림 생성
		DataInputStream din = new DataInputStream(in); 

		// 내용교환(q:종료)
		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;

		while (true) {
			// 클라이언트 -> 서버 수신
			recv = din.readUTF();
			if (recv.equals("q")) {
				break;
			}
			System.out.println("[Server ] : " + recv);

			// 서버 -> 클라이언트 송신
			System.out.print("[Client(q:종료)] : ");
			send = sc.nextLine();
			if (send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
		}
		// 자원 해제
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		System.out.println("[Client] 연결 종료 합니다");
	}
```

## 23. 쓰레드
> 쓰레드
+ 하나의 프로세스 내에서 독립적으로 실행되는 실행 흐름
+ 멀티스레딩을 통해 여러 작업을 동시에 처리가능
+ 소켓으로 네트워크를 연결 후 각 클라이언트의 별도 쓰레드를 생성해서 클라이언트들의 요청들을 처리 가능

### 메인쓰레드
```
public static void main(String[] args) {
		// Runnable Interface 스레드 분할
		
		// 객체 생성
		ch02Worker1 w1 = new ch02Worker1();
		ch02Worker2 w2 = new ch02Worker2();
		
		// 메인 스레드에서 분리
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		
		// 스레드 실행
		th1.start();
		th2.start();
		
		// Thread class 스레드 분할
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("task 3");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("main task");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
```

### 쓰레드 분할
```
public class ch02Worker1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("task 1");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
public class ch02Worker2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("task 2");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
```

## 24. Reflect
> Reflect
+ 실행 중인 프로그램의 클래스, 인터페이스, 메서드, 필드 등의 정보를 동적으로 얻고 조작할 수 있는 기능을 제공하는 API
+ 리플렉션을 사용하면 컴파일 시간에 알려지지 않은 클래스에 대한 정보를 얻거나, 클래스의 메서드와 필드에 접근하고 호출할 수 있음
+ 리플렉션을 사용하기 위해 java.lang.reflect 패키지에 있는 클래스와 인터페이스를 활용함 

> 주요 메서드, 클래스
+ Class
	+ 클래스의 메타데이터를 나타내는 클래스
	+ 객체를 통해 클래스의 이름, 필드, 메서드, 생성자 등의 정보를 얻을 수 있음
+ Field
	+ 클래스의 필드를 나타내는 클래스
	+ 객체를 통해 필드의 정보를 얻을 수 있으며, 필드의 값을 읽거나 수정할 수도 있음
+ Method
	+ 클래스의 메서드를 나타내는 클래스
 	+ 객체를 통해 메서드 정보를 얻을 수 있으며, 메서드를 호출할 수도 있음
+ Constructor
 	+ 클래스의 생성자를 나타내는 클래스
 	+ 객체를 통해 생성자의 여러정보를 얻을 수 있으며, 생성자를 호출하여 객체를 인스턴스화할 수도 있음
```
리플렉션은 일반적인 자바 개발에서는 자주 사용되지 않지만, 프레임워크, 라이브러리
테스트 도구 등에서 동적인 환경에서의 프로그래밍이 필요한 경우 유용하게 사용될 수 있음 
```
` 그러나 리플렉션은 성능 상의 이슈가 있으므로, 가능한 경우에는 정적인 방법으로 코드를 작성하는 것이 좋다 `

## 25. 디자인패턴
1. 생성 패턴 (Creational Patterns)
생성 패턴은 객체를 생성하는 방법을 캡슐화하여 코드의 유연성과 확장성을 높임

+ 싱글톤 패턴 (Singleton Pattern)
	+ 애플리케이션에서 특정 클래스의 인스턴스를 하나만 생성하도록 보장하는 패턴 
	+ 전역 변수를 사용하지 않고도 객체에 접근할 수 있으며, 인스턴스가 필요한 경우 항상 동일한 인스턴스를 반환

+ 팩토리 메서드 패턴 (Factory Method Pattern)
	+ 객체의 인스턴스화를 서브 클래스로 분리하여 처리하는 패턴
 	+ 슈퍼 클래스에서는 인스턴스를 생성하는 추상 메서드를 정의하고, 서브 클래스에서는 이 추상 메서드를 구현하여 객체를 생성

+ 추상 팩토리 패턴 (Abstract Factory Pattern)
 	+ 관련된 객체들의 집합을 생성하기 위한 인터페이스를 제공하는 패턴
 	+ 서로 다른 구체적인 팩토리 클래스를 사용하여 다른 종류의 객체를 생성할 수 있으며, 클라이언트는 팩토리 인터페이스를 통해 객체를 생성하고 사용

+ 빌더 패턴 (Builder Pattern)
 	+ 복잡한 객체의 생성 과정을 추상화하여 표현하는 패턴입니다.
 	+ 객체의 구성 요소를 단계적으로 추가하거나 변경하여 객체를 생성할 수 있으며, 객체의 생성 과정을 사용자에게 노출시키지 않음

+ 프로토 타입 패턴 (Prototype Pattern)
	 + 기존 객체를 복제하여 새로운 객체를 생성하는 패턴
 	+ 복잡한 초기화 과정이 필요한 객체를 쉽게 생성할 수 있으며, 객체 간의 참조 문제를 피할 수 있음

2. 구조 패턴 (Structural Patterns)
구조 패턴은 객체와 클래스 간의 관계를 정의함

+ 어댑터 패턴 (Adapter Pattern):
	 + 호환되지 않는 인터페이스를 가진 클래스들을 함께 동작하도록 만드는 패턴
 	+ 어댑터 클래스를 사용하여 서로 다른 인터페이스를 가진 클래스들이 함께 작동할 수 있도록 중개 역할함

3. 행위 패턴 (Behavioral Patterns)
행위 패턴은 객체 간의 상호작용과 책임 분배를 정의함

+ 옵저버 패턴 (Observer Pattern):
 	+ 한 객체의 상태 변화를 관찰하는 다른 객체들에게 자동으로 알림을 전달하는 패턴 
	 + 주체(Subject)와 관찰자(Observer)로 구성되며, 상태 변화가 발생하면 관찰자들에게 알림이 전달됨

+ 전략 패턴 (Strategy Pattern):
 	+ 실행 중에 알고리즘을 선택할 수 있도록 하는 패턴
	 + 알고리즘을 캡슐화하여 각각의 전략을 독립적으로 변경할 수 있으며, 클라이언트는 전략을 선택하여 사용

## 26. 람다스트림
> 람다스트림
+ 함수를 단순하게 표현하는 기법

```
interface Calculator {
	int calculate(int num1, int num2);
}

public class ch03Lambda {

	public static void main(String[] args) {
		Calculator add = (num1, num2) -> num1 + num2;
		System.out.println(add.calculate(10, 20)); // 덧셈
	}
}

```
> 자바스트림의 함수
+ 중개 연산(Intermediate operations)
1. filter : 주어진 조건에 맞는 요소를 선택
2. map : 요소를 다른 형태로 변환
3. flatMap : 각 요소를 변환하고, 이를 하나의 스트림으로 평면화시킴
4. distinct : 중복된 요소를 제거
5. sorted : 요소를 정렬
6. limit : 주어진 개수만큼 요소를 제한
7. skip : 처음 몇 개의 요소를 제외하고 반환

+ 최종 연산(Terminal operations):
1. forEach : 각 요소를 반복적으로 처리
2. collect : 요소를 수집하여 새로운 컬렉션을 생성
3. reduce : 요소를 하나로 줄여서 결과를 반환
4. min : 최소값을 반환
5. max : 최대값을 반환
6. count : 요소의 개수를 반환
7. anyMatch : 하나 이상의 요소가 주어진 조건과 일치하는지 검사
8. allMatch : 모든 요소가 주어진 조건과 일치하는지 검사
9. noneMatch : 모든 요소가 주어진 조건과 일치하지 않는지 검사
10. findFirst : 첫 번째 요소를 반환
11. findAny : 임의의 요소를 반환

### 예시코드
```
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);

		// filter
		List<Integer> list2 = list.stream().filter((item) -> { // item의 요소 필터링
			return item % 2 == 0;
		}).collect(Collectors.toList()); // 결과 수집
		System.out.println(list2);

		List<Integer> list3 = list.stream().filter((item) -> {
			return item % 2 == 0;
		}).map((item) -> { // item 재구성
			return item * item;
		}).collect(Collectors.toList()); // 결과 수집
		System.out.println(list3);

		List<Person> list4 = Arrays.asList(
				new Person("홍길동", 11), 
				new Person("박혁거세", 21), 
				new Person("이근", 31),
				new Person("유재석", 41)
			);
		List<Integer> list5 =
		list4.stream()
//			 .map(person->person.getAge())
			 .map(Person::getAge) // 메서드 참조
			 .sorted((a,b)->b-a)
			 .collect(Collectors.toList());
		System.out.println(list5);
```

## 27. 함수형 인터페이스

## 28. 클래스 다이어그램
> 클래스 다이어그램의 관계

![Image](https://github.com/user-attachments/assets/cdfabc93-0580-4d84-89a1-01a42b20e5c0)

1. 연관 관계
+ 연관 관계는 일반적으로 클래스 간의 참조 관계를 의미하며, 다이어그램에서는 두 클래스를 직접 연결하는 화살표로 표시됨
+ 방향이 있는 실선과 방향이 없는 실선 두 가지로 연관 관계를 나타낼 수 있음

+ A → B 와 같이 방향이 있는 실선의 경우, A가 B를 참조한다는 의미
+ A - B는 A가 B를, B가 A를 참조할 수도 있고 둘 다 참조 이거나 둘 다 참조가 아니거나 라는 의미

![Image](https://github.com/user-attachments/assets/e23ef98a-d618-4787-a34f-cac5817fb0f5)

2. 상속 관계
+ 상속관계는 한 클래스가 다른 클래스의 속성과 메서드를 상속받는 관계를 나타냄
+ UML 다이어그램에서는 상속 받는 클래스와 상속하는 클래스를 화살표로 연결하며, 화살표 끝에는 빈 삼각형이 위치함
+ Generalization - 일반화라고도 많이 부름

![Image](https://github.com/user-attachments/assets/e240eb25-b139-4133-9fba-2c61e7befaa2)

3. 의존 관계
+ 의존관계는 일반적으로 메서드 내에서 다른 클래스를 사용할 때 발생하며, UML 다이어그램에서는 점선 화살표로 표시됨
+ 연관 관계와의 차이점으로는 연관 관계는 변수로 다른 클래스와 연관이 있을 때 사용하고 의존 관계는 메소드의 파라미터나 반환에 사용되는 클래스 관계를 나타낼 때 사용함

**즉, 연관 관계는 해당 클래스의 멤버 변수로 할당할 때 사용하고**

**의존 관계는 로컬 변수, 파라미터, 반환 값으로 호출되는 메소드가 실행되는 동안에만 유지가 될 때 사용함**

![Image](https://github.com/user-attachments/assets/e4196081-a42c-46f0-bc3f-60441840465d)

4. 집합/집약 관계
+ 집합 관계는 전체 클래스와 부분 클래스 사이의 강한 포함 관계를 나타냄
+ 전체 클래스가 사라지면 부분 클래스도 함께 사라짐.
+ UML 다이어그램에서는 전체 클래스와 부분 클래스 사이의 관계를 화살표로 표시하며, 화살표 끝에는 검은색 다이아몬드로 표시

+ 집약 관계는 전체 클래스와 부분 클래스 사이의 약한 포함 관계를 나타냄
+ 전체 클래스가 사라져도, 부분 클래스는 독립적으로 존재 가능
+ UML 다이어그램에서는 전체 클래스와 부분 클래스 사이의 관계를 화살표로 표시하며, 화살표 끝에는 빈 다이아몬드로 표시

![Image](https://github.com/user-attachments/assets/30d28779-4274-4277-b649-26ca8604518b)
