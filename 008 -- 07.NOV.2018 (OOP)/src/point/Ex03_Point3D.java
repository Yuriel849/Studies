package point;

public class Point3D extends Point {
	int z;
	
	Point3D() {
		this(1,1,1);
	}

	Point3D(int x, int y, int z) {
		super(x,y); // 여기서 다시 x, y 관련 코드를 작성하는 대신 parent의 멤버인 x, y 조작은 parent 생성자에게 맡긴다.
		this.z = z;
	}
	
	// System.out.println(p3.equals(p4)); --> true 나와야 한다.
	// Object로부터 상속받아 Point에서 오버라이딩 한 equals를 여기서 다시 오버라이딩 하세요.
	public boolean equals(Object obj) {
		// 두 점의 x, y를 비교해서 같으면 true.
		// 아니면 false를 반환하시요.
		if (obj instanceof Point3D) {
			Point3D point = (Point3D) obj; // parent 타입에서 child의 child 타입 참조변수로 단번에 형변환
			if (this.x == point.x && this.y == point.y && this.z == point.z) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + ", z : " + z;
	}
}
