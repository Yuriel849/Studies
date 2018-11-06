package study;

class MyMath {
	long a, b; // iv --> 인스턴스 변수
	
//	static long add() { // a, b --> 매개변수 없음 --> MyMath의 인스턴스 변수 사용 --> 클래스 메서드가 생성되지 않은 인스턴스 변수 사용 불가능
//							 // --> main()에서 객체를 만든 후 사용할 수가 있지 않나? --> 컴파일 과정에서 (main() 실행하기 전) 먼저 에러 
//		return a + b;
//	}
	
	static long add2(int a, int b) { // a, b --> add2의 매개변수 --> add2의 지역변수
		return a + b;
	}
	
	/* 1. static 메서드는 객체 생성 없이 호출 가능
	 * 	>> 왜? --> 객체(instance variable) 없이 작동하니까
	 * 2. 인스턴스 메서드는 객체 생성해야 호출 가능
	 * 	>> 왜? --> 객체(instance variable) 사용해서 작동하니까
	 * 
	 * 같은 클래스의 멤버 (변수 & 메서드) 간에는 객체생성이나 참조변수 없이 참조할 수 있다 (참조하다 == 사용하다)
	 * 		>> BUT static 멤버는 인스턴스 멤버를 참조할 수 없다.
	 * 		>> 왜? --> static 멤버가 참조하려고 할 때, 인스턴스 멤버가 존재하지 않는 시점일 수 있기 때문이다 (i.e. 객체 생성 전)
	 */
	
	/* 호출
	 *	>> 인스턴스 메서드 --> <object name>.add(x, y)
	 *	>> 클래스 메서드 --> MyMath.add2(x, y)
	 */
	
	/* 메서드 오버로딩의 조건
	 * 1. 메서드 이름이 같아야 한다.
	 * 		>> 메서드 이름이 같다는 것 --> 같은 작업을 한다는 의미
	 * 		>> 오버로딩은 같은 작업을 하는 메서드를 2개 이상 만들 때 사용
	 * 2. 매개변수의 개수 OR 타입 OR 순서가 달라야 한다.
	 * 3. 리턴 타입의 차이와는 무관하다 (중복정의 에러).
	 */
}

public class OOP_MyMathTest {
	public static void main(String[] args) {
		MyMath mm = new MyMath();
//		long result = mm.add(3, 5);
		long result = MyMath.add2(5, 5);
		System.out.println(result);
	}

}
