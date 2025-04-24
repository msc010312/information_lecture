# Spring

## Spring FrameWork
>작업에 필요한것들을 직접구하지않고 프레임내에서 가져와 쓸 수 있도록 제공하는 툴

> FrameWork, Library, api 차이

|-|능동/수동|유틸리티|개발자
|---|---|---|---|
|FrameWork|능동|제작을 의뢰|조건 제공
|Library|수동|직접 도구를 사용하여 제작|직접 사용
|API|능동|프로그렘간 연결|통신

> 핵심기능 및 설명

|핵심기능|설명|
|---|---|
|의존성 주입 (Dependency Injection, DI)|Spring은 객체 간의 의존성을 주입하는 기능을 제공, DI를 통해 객체 간의 결합도를 낮추고 코드의 유연성을 향상
|제어의 역전 (Inversion of Control, IoC)|Spring은 제어의 역전 원칙을 따르며, 객체의 생명주기와 의존성 관리를 프레임워크가 담당함
|트랜잭션 관리|Spring은 선언적 트랜잭션 관리를 지원하여 개발자가 트랜잭션 처리에 대한 복잡한 코드를 작성하지 않아도 됨 데이터베이스 연산의 일관성과 안정성을 보장함
|스프링 MVC (Spring Model-View-Controller)|Spring은 웹 애플리케이션을 개발하기 위한 MVC 아키텍처를 제공함 Spring MVC를 사용하면 요청을 처리하는 컨트롤러, 데이터를 표시하는 뷰, 비즈니스 로직을 처리하는 모델을 분리하여 개발할 수 있음
|스프링 데이터 (Spring Data)|Spring은 데이터 액세스를 위한 다양한 기능을 제공함
|스프링 시큐리티 (Spring Security)|Spring은 보안을 위한 스프링 시큐리티 프레임워크를 제공함 스프링 시큐리티를 사용하면 인증, 권한 부여, 보안 설정 등을 쉽게 구현할 수 있음
|스프링 배치 (Spring Batch)|Spring은 대용량 데이터 처리를 위한 스프링 배치 프레임워크를 제공함 스프링 배치는 일괄 처리 작업을 생성하고 구성할 수 있으며, 작업을 스케줄링하고 청크 기반 처리를 통해 대용량 데이터를 효율적으로 처리할 수 있음

## Bean 등록(의존주입)
1. Context 파일에서 직접 객체 등록
```
<!-- root-context.xml -->
<bean id="personDTO1" class="com.example.app.domain.DTO.PersonDTO">
		<constructor-arg name="name" value="kevin"></constructor-arg>
		<constructor-arg name="age" value="11"></constructor-arg>
		<constructor-arg name="addr" value="deagu"></constructor-arg>
</bean>
```

2. Context에 객체 등록
```
@Configuration // Context에 인식
public class PersonDTOBeanConfig {
  @Bean // Context에 Bean 등록
  public PersonDTO person3() {
		return PersonDTO.builder() // 빌더 활용
				.age(999)
				.name("ggg")
				.addr("addr2")
				.build();
	}

  @Bean(name="personBean) // 이름 설정(미 설정시 생성자의 이름을 씀 ex: PersonBean -> personBean)
  public PersonDTO person4() {
    return new PersonDTO("name",age,"addr");
  }
}
```

3. 클래스를 Context에 bean등록
```
@Data // getter,setter,toString 생성
@Component // Context에 class 인식
public class PersonComponent {
	private String name;
	private int age;
	private String addr;
	
	PersonComponent(){
		this.name = "qqq";
		this.age = 1;
		this.addr = "wwww";
	}
}
```

4. Autowired
+ @Autowired 어노테이션의 경우 형(타입)을 통해 해당 자리에 들어올 객체를 판별하여 주입해줌
+ 다형성을 띄고있는 객체타입에 @Autowired를 사용한 경우에는 @Qualifier("Bean이름") 을 이용하여 해당 자리에 주입될 Bean을 명시해야함

```
@Autowired
	private PersonDTO personDTO1; // 현재 Context에 저장되어있는 Bean을 명시

@Qualifier("name")
@Autowired
  private PersonInterface personIn; // PersonInterface를 name과 age가 구현하고 있을 경우 @Qualifier로 명시할 Bean이름을 명시
```

## 파라미터 요청
+ @RequestParam = HTTP 요청의 파라미터를 메소드의 파라미터와 바인딩 "URL 쿼리 문자열이나 POST 요청의 form 데이터" 와 매핑
+ @RequestBody =  HTTP 요청의 본문(body)을 메소드의 파라미터에 바인딩 주로 "JSON 또는 XML" 형식의 데이터를 객체로 변환할 때 사용

```
// GET 요청의 URL 파라미터를 메소드의 파라미터로 받는 예시
@RequestMapping(value="/p01", method=RequestMethod.GET)
public void p01(@RequestParam(value="name", required=true) String name) {
    // 로그에 요청된 name 값을 출력
    log.info("GET /param/p01 " + name);
    /*
     * @RequestParam은 HTTP 요청의 쿼리 파라미터를 자바 메소드의 파라미터로 바인딩
     * /p01?name=홍길동 과 같은 요청이 들어오면 name 파라미터에 "홍길동"이 전달
     * required=true는 해당 파라미터가 반드시 포함되어야 함을 의미
     */
}

// POST 요청의 본문(body)에 담긴 데이터를 문자열로 받는 예시
@PostMapping(value="/p04")
public void p04(@RequestBody String name) {
    // 로그에 요청 본문에 담긴 name 데이터를 출력
    log.info("/param/p04 " + name);
    /*
     * @RequestBody는 HTTP 요청의 본문을 메소드의 파라미터로 바인딩
     * 일반적으로 JSON 또는 XML 형식의 데이터를 처리할 때 사용
     * 요청 본문이 "홍길동" 이면, name 파라미터는 "홍길동" 값을 가짐
     * JSON 예시: { "name": "홍길동" }
     */
```

## 유효성체크
+
