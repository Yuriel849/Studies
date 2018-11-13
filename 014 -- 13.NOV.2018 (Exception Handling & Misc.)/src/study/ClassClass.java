package study;

class Point {
	int x;
	int y;
	
	Point() { }
}

public class ClassClass {
	public static void main(String[] args) throws ClassNotFoundException { // forName 때문에 예외 추가
		Point p = new Point();
		
		// 객체 p의 설계도 객체(Class 객체)를 얻어온다.
		Class cObj = p.getClass();
		Class cObj2 = Point.class; // 클래스파일이 아니라 클래스 리터럴이다!!! --> <클래스명>.class 자체가 상수다!!!
		Class cObj3 = Class.forName("Point"); // 클래스 이름으로부터 클래스 객체를 얻는다.
		
		System.out.println("className = " + cObj.getName());
		System.out.println("packageName = " + cObj.getPackage());
		
		// Class 클래스로 특정 클래스의 객체를 만들고 나면 해당 클래스의 모든 멤버를 알고 사용할 수 있다.
		// 소스코드를 보면 안되나? --> 항상 특정 클래스의 소스코드를 열어볼 수 있는 것이 아니다 (ex) 제3자가 만들어놓은 클래스)
	}
}
