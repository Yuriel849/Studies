package study;

class Ex03_Super {
	public static void main(String[] args) {
		PointA p = new PointA();
		Point3D p3 = new Point3D(1,2,3);	
	}
}
	
	class PointA {
		int x;
		int y;
		
		PointA() {} // 기본생성자
		
		PointA(int x, int y) { // 사용자 정의 생성자
			this.x = x;
			this.y = y;
		}
	}
	
	class Point3D extends PointA {
		int z;
		
		Point3D(int x, int y, int z) {
//			this.x = x; // Point3D class의 조상 멤버 초기화 --> 조상 멤버 초기화는 조상이 하는 것이 올바르다
//			this.y = y; // Point3D class의 조상 멤버 초기화 --> 자손에서 조상 멤버 초기화하면 코드 중복이 발생
			// super(); --> 기본생성자 호출 (만약 PointA 클래스에 기본생성자가 없으면 에러)
			super(1, 1); // 조상 메서드 Point(int x, int y) 호출 --> 생성자 간 this(x,y)으로 호출하는 것과 비슷
					 	 // 생성자가 생성자를 호출할 때는 항상 호출하는 생성자의 첫 줄에 위치해야
			  			 // 만약 사용자가 작성하지 않는다면, 컴파일러가 자동으로 super(); 추가한다 (조상의 생성자 호출)
			this.z = z;
		}
	}
