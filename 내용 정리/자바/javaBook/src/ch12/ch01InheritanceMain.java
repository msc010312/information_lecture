//package ch12;
//
//
//class point2D {
//	int x;
//	int y;
//	point2D(){
//		System.out.println("point2d default");
//	}
//}
//
//
//class point3D extends point2D {
//	int z;
//	point3D(){
//		super(); // 상위클래스 point2D() 생성자 호출
//		System.out.println("point3d default");
//	}
//	@Override
//	public String toString() {
//		return "point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
//	}
//}
//
//public class ch01InheritanceMain {
//
//	public static void main(String[] args) {
//		point3D p3 = new point3D();
//		p3.x = 10;
//		p3.y = 20;
//		p3.z = 30;
//		System.out.println(p3);
//		
//	}
//
//}
