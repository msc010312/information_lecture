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


 - - -


## 0. 메서드
- Java의 메서드에 대해 설명합니다.
  
`메서드는 함수와 동일한 뜻을 가짐`

> 메서드의 종류

  + 라이브러리 메서드 : 미리만들어져 제공되는 메서드
  + 사용자정의 메서드 : 개발자에 의해 만들어지는 메서드
  + main 메서드 : 최초 실행 메서드

**예시**
```
public class ch00HelloWorld {
	public static void main(String[] args) { // 메인메서드
		System.out.println("hello world"); // 라이브러리 메서드
	}
}
```
- - -

## 1. 출력함수
- `System.out.println()`을 사용하여 출력합니다.

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
- 기본 자료형과 참조 자료형이 있습니다.
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
- 자료형 간의 변환 방법에 대해 설명합니다.

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
- 사용자 입력을 받는 방법을 설명합니다.

+ Scanner : 데이터 입력 클래스
+ System.in : 표준입력 스트림 생성(요청)
+ System.out : 표준출력 스트림 생성(요청)
```
Scanner "변수명" = new Scanner(System.in);
sc.close(); // 불필요한 데이터 누수 차단
```

## 5. 연산자
- 산술 연산자, 비교 연산자 등을 다룹니다.

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
- `if`, `else`, `switch` 등을 설명합니다.

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
- `for`, `while` 반복문을 설명합니다.

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
- 객체지향 프로그래밍의 기본 개념을 설명합니다.

## 9. 정보은닉-캡슐화
- 정보은닉과 캡슐화의 중요성을 설명합니다.

## 10. 배열
- 배열의 선언과 사용 방법을 다룹니다.

## 11. static
- `static` 키워드의 사용에 대해 설명합니다.

## 12. 상속
- 상속 개념과 활용 방법을 설명합니다.

## 13. 추상화-인터페이스
- 추상화와 인터페이스를 설명합니다
