package chapter_09;

// Point3D 클래스의 equals()를 오버라이딩하여 멤버변수 x, y, z의 값을 비교하고,
// 		toString()은 실행결과를 참고해서 적절히 오버라이딩하라.

class Exercise09_02 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1 == p2? " + (p1==p2));
		System.out.println("p1.equals(p2)? " + (p1.equals(p2)));
	} // main() 끝.
} // 클래스 끝.

class Point3D {
	int x, y, z;
	
	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point3D() {
		this(0,0,0);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point3D) {
			Point3D p3d = (Point3D) obj;
			return (this.x == p3d.x && this.y == p3d.y && this.z == p3d.z);
		}
		return false;
	}
	
	public String toString() {
		return "[" + x + "," + y + "," + z + "]";
	}
}