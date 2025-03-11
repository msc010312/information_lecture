package ch16;

class Person {
	String name;
	int age;
	String addr;
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
}

class Man extends Person{
	public Man(String name, int age, String addr) {
		super(name, age, addr);
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

class Woman extends Person{

	public Woman(String name, int age, String addr) {
		super(name, age, addr);
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

class Couple<X extends Person, Y extends Person> {
	private X member1;
	private Y member2;
	public Couple(X member1, Y member2) {
		super();
		this.member1 = member1;
		this.member2 = member2;
	}
	@Override
	public String toString() {
		return "Couple [member1=" + member1 + ", member2=" + member2 + "]";
	}
}

public class ch03Generic {

	public static void main(String[] args) {
		Couple<Man,Woman> couple1 = new Couple<Man,Woman>(new Man("홍길동",50,"대구"),new Woman("김영희",40,"울산")); //자료형이 같다면 생략가능
		Couple<Man,Man> couple2 = new Couple<Man,Man>(new Man("홍길동",50,"대구"),new Man("홍길동2",40,"울산"));
//		Couple<Integer,Integer> couple3 = new Couple<Integer,Integer>(100,200); // Person을 상속받아서 사용불가능
		System.out.println(couple1);
		System.out.println(couple2);
//		System.out.println(couple3);
	}

}
