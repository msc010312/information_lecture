package ch12;

class Employee {
	public String name;
	private int age;
	private String addr;

	Employee(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}

class Parttimer extends Employee {
	private int hourPay;

	Parttimer(String name, int age, String addr, int hourPay) {
		super(name, age, addr);
		this.hourPay = hourPay;
	}

	public void setHourPay(int hourPay) {
		this.hourPay = hourPay;
	}

	@Override
	public String toString() {
		return "Parttimer [name=" + name + ",age=" + getAge() + ", addr=" + getAddr() + ", hourPay=" + hourPay + "]";
	}

}

class Regular extends Employee {
	private int salary;

	Regular(String name, int age, String addr, int salary) {
		super(name, age, addr);
		this.salary = salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Regular [name=" + name + ", age=" + getAge() + ", addr=" + getAddr() + ",salary=" + salary + "]";
	}

}

public class ch05ex {

	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동", 25, "대구", 20000);
		Regular emp2 = new Regular("서길동", 45, "울산", 50000000);
		System.out.println(emp1);
		System.out.println(emp2);
	}

}
