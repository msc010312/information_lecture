package ch11;


class Company{
	int n1;
	int n2;
	
	//toString
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
	//	싱글톤 패턴 구조
	private static Company instance; // !

	private Company() {}	// !외부에서 객체생성 불가설정
	public static Company getInstance()	// ! 
	{
		if(instance==null)
			instance = new Company();
		return instance;
	}
}

public class ch03singletonPattern {

	public static void main(String[] args) {
		
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		com1.n1=100;
		com2.n2=200;
		System.out.println("com1 : " + com1);
		System.out.println("com2 : " + com2);
	}

}
