package point;

public class Point {
	int x; // --> this.x --> iv (인스턴스 변수)
	int y; // --> 객체를 생성해야만 존재한다
	
	Point() {
		this(1, 1); // == Point(1,1) --> 아래 Point(int x, int y) 생성자 호출
					// 코드 중복 피하려고 this() 사용
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// System.out.println(p.equals(p2)); --> true 나와야 한다.
	// Object로부터 상속받은 equals를 오버라이딩 하세요.
	public boolean equals(Object obj) {
		// 두 점의 x, y를 비교해서 같으면 true.
		// 아니면 false를 반환하시요.
		if (obj instanceof Point) { // 형변환하기 전에 obj가 Point의 객체가 맞기는 한지 먼저 확인해야 한다.
			Point point = (Point) obj; // instanceof로 확인 후 parent형 --> child형 참조변수로 형변환
			return (this.x == point.x && this.y == point.y); // this의 x, y & point가 참조하는 x, y가 같은지 비교
			}
//			if (this.x == point.x && this.y == point.y) {
//				return true;
		return false;
	}
			/* equals 호출하면서 parent의 참조변수를 이용했다.
			 * 	>> parent의 참조변수로는 parent에게는 없는 (child에게만 있는) 속성(변수)을 사용할 수 없다.
			 * 		>> Object형 참조변수 obj로는 Point 인스턴스의 x, y 멤버에 접근할 수 없다
			 * 			>> Object 클래스에는 x, y가 존재하지 않는다 (Object의 소스코드에 x, y가 없다)
			 * 		>> obj.x --> obj type의 소스코드로 가서 x라는 것을 실행하려고 시도 --> 없다!! --> 에러!!!
			 * 	>> child의 속성을 사용하기 위해서는 parent의 참조변수에서 child의 참조변수로 형변환해야 한다.
			 * 
			 * parent 타입으로 child 인스턴스 참조 --> 기능을 다 못쓸지언정 없는 기능을 사용하려하지 않는다. 문제없다.
			 * child 타입으로 parent 인스턴스 참조 --> 리모컨 역할인 child 타입에는 있지만
			 * 									인스턴스에는 없는 (parent에는 없는) 기능을 사용하려고 하는 에러!
			 *
			 * instanceof를 써야하는 이유
			 * 	>> equals 함수 입장에서는 obj가 어떤 클래스의 인스턴스인지 알 수가 없기 때문이다.
			 * 	>> 만약 obj가 Point와 아예 관련 없는 A라는 클래스라면? 완전히 이상한 것으로 형변환하면서 에러날 수 있다.
			 * 	>> 당연히 A 타입으로 형변환하면 Point 타입의 인스턴스를 사용할 수 없다.
			 */
	
	/* toString()을 오버라이딩하라
	 * 	>> 모든 클래스에는 superclass로 Object class가 있다
	 * 	>> Object의 toString() 메서드를 여기서 오버라이딩하라
	 * 	>> Object의 toString() 메서드의 내용을 여기서 덮어써라
	 */
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
	
	// <객체1>.getDistance(<객체2>);로 호출 --> 여러 값을 <객체2>라고 부르는 하나의 객체 안에 묶어서 인수전달
	double getDistance(Point p) {
		/* static double getDistance(Point p) -->> 에러!!!
		 * 	>> "this" 자체는 지역변수이지만 this는 인스턴스 자신을 가리키는 참조변수다
		 * 	>> 여기서 this는 메서드 호출할 때 사용한 객체 자신을 의미 --> 즉, 이 메서드는 객체를 생성해야만 사용 가능
		 * 	>> static 붙이면 클래스 메서드 --> iv 없어도 된다 --> 객체가 있을 때 & 없을 때 둘 다 사용가능해야 한다
		 * 	>> this는 객체가 없을 때는 (iv 없이는) 사용할 수 없다 --> this & static 메서드는 모순된다
		 * 		>> static method는 this 사용할 수 없다!!!
		 * 		>> 교재 "자바의 정석 3판" 297pg.에 명시
		 */
		return getDistance(p, this); // --> 원래라면 Point.getDistance(p, this)라고 클래스를 명시해야 한다
									 // --> 하지만 여기는 같은 클래스 내 메서드니까 소속 클래스를 명시하지 않아도 찾아간다
		/* static method 남기고 instance method 축약해야
		 * 	>> static은 instance 호출 불가능 --> static은 항상 존재하지만 instance는 호출하는 시점에 존재하지 않을 수도 있다
		 * 	>> instance는 static 호출 가능 --> instance가 존재하는 시점이면 static은 반드시 존재한다
		 */		
//		int a = this.x - p.x;
//		int b = this.y - p.y;
//		return Math.sqrt(a*a + b*b); // --> 어차피 Math.sqrt는 double을 반환하기에 형변환하지 않아도 된다
	}
	
	// Point p1, Point p2 --> 이 함수를 호출하는 곳으로부터 참조형 변수의 주소값을 전달 받는 것
	static double getDistance(Point p1, Point p2) {
//		double square = Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2);
//		double result = Math.sqrt(square); 
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
		// 여기서 p2.x, p2.y 등등은 instance변수 아니다 --> 지역변수다
	}
}
