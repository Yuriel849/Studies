package study;

public class Ex03_Shallow_DeepCopy {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1,1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println("= c1의 변경 후 =");
		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
	} // main() 끝.
} // 클래스 끝.

class Circle implements Cloneable {
	Point p; // 원점
	double r; // 반지름
	
	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle shallowCopy() { // 얕은 복사
		Object obj = null;
		
		try {
			obj = super.clone(); // super.clone() --> 리턴타입은 Object이지만 실제 반환하는 것은 이 코드를 실행한 클래스의 객체
		} catch (CloneNotSupportedException e) { }
		
		return (Circle) obj;
	}
	
	public Circle deepCopy() { // 깊은 복사
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) { }
		Circle c = (Circle) obj;
		c.p = new Point(this.p.x, this.p.y);
		
		return c;
	}
	
	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}