package ch12;

class point2D {
	int x;
	int y;
	point2D(){
		System.out.println("point2d default");
	}
	
	point2D(int x) {
		this.x = x;
		System.out.println("point2d int x");
	}
	
	point2D(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("point2d int x, int y");
	}
}

class point3D extends point2D {
	int z;
	point3D(){
		super(); // 상위클래스 point2D() 생성자 호출
		System.out.println("point3d default");
	}
	point3D(int x) {
		super(x); // 상위클래스 point2D(int x) 호출
		System.out.println("point3d int x");
	}
	
	point3D(int x, int y) {
		super(x,y);
		System.out.println("point3d int x, int y");
	}
	
	point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
		System.out.println("point3d int x, int y, int z");
	}
	@Override
	public String toString() {
		return "point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}

public class ch02InheritanceMain {

	public static void main(String[] args) {
		point3D p3 = new point3D(10,20,30);
		System.out.println(p3);
	}

}
