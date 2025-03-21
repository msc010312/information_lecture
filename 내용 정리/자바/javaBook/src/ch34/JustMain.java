package ch34;

@CustomAnnotaion(value="Hello world",number=5)
class Simple {
	String v1;
	int v2;
	
	Simple(){
		CustomAnnotaion ref = this.getClass().getAnnotation(CustomAnnotaion.class);
		System.out.println(ref.value());
		System.out.println(ref.number());
		this.v1 = ref.value();
		this.v2 = ref.number();
	}

	@Override
	public String toString() {
		return "Simple [v1=" + v1 + ", v2=" + v2 + "]";
	}
}


public class JustMain {

	public static void main(String[] args) {
		Simple sp = new Simple();
		System.out.println(sp);

	}

}
