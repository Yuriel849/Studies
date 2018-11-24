package study;

// add this file to 14 Nov. 2018 (7장 연습문제)

class Ex05_Shapes {
	// 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
	static double sumArea(Shape[] arr) {
		double sum = 0;
		for(Shape s : arr) {
			sum += s.calcArea();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Rectangle(3,4), new Circle(1) };
		System.out.println("면적의 합: " + sumArea(arr));
	}
}

abstract class Shape {
	Point p;
	
	Shape() {
		this(new Point(0,0));
	}
	
	Shape(Point p) {
		this.p = p;
	}
	
	// 도형의 면적을 계산해서 반환하는 메서드
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
} // 추상클래스 Shape 끝.

class Point {
	int x;
	int y;
	
	Point() {
		this(0,0);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + x + "," + y + "]";
	}
} // Point 클래스 끝.

class Circle extends Shape {
	double r;
	
	Circle() {
		this(new Point(0,0), 1);
	}
	
	Circle(double x) {
		this(new Point(0,0), x);
	}
	
	Circle(Point p, double x) {
		super(p);
		this.r = x;
	}
	
	double calcArea() {
		return Math.PI * r * r;
	}
} // Circle 클래스 끝.

class Rectangle extends Shape {
	double width, height;
	
	Rectangle() {
		this(new Point(0,0), 1, 1);
	}
	
	Rectangle(double x, double y) {
		this(new Point(0,0), x, y);
	}
	
	Rectangle(Point p, double x, double y) {
		super(p);
		this.width = x;
		this.height = y;
	}
	
	double calcArea() {
		return width * height;
	}
	
	boolean isSquare() {
		return width == height && width*height != 0; // 높이 또는 넓이가 0이 아니어야 한다 (높이와 넓이를 곱했을 때 0이 아니어야 한다)
	}
} // Rectangle 클래스 끝.