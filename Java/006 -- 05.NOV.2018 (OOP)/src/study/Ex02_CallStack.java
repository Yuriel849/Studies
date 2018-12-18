package study;

public class Ex02_CallStack {
	public static void main(String[] args) { // --> 메소드 선언부 == 정의부 == signature
	
	/* Call Stack 메모리
	 *	>> 프로그램 실행 시 정적변수들이 저장되는 위치
	 *		(간단한 설명...)
	 *		정적변수 --> 프로그램 실행 이전 이미 선언된 변수들
	 *		동적변수 --> 프로그램 실행 도중 새롭게 만들어지고 없어지는 변수들
	 *	1) 지역변수가 저장된다 (지역변수 == 메소드 (중괄호 {}) 내부에서 선언된 변수)
	 *	2) 메소드가 실행될 때 사용하는 메모리 공간
	 *	3) 자동초기화가 지원되지 않음 --> 명시적으로 초기화시켜줘야 한다
	 *	4) 매개변수(parameter)가 저장된다 (매개변수 == 메소드 선언부의 괄호 안에서 선언된 변수)
	 *		>> 중괄호 내부에서 선언된 변수는 아니지만, 메소드의 메모리 공간 안에 위치하기에 지역변수 취급!!!
	 *		>> public static void main(String[] args) --> "String[] args"가 매개변수
	 *		>> 매개변수는 메소드 실행 시 입력값을 받아오는 역할 (값을 복사+붙여넣기로 받아옴)
	 */
		
		// 인수전달 안한다 -> 2개 add 메소드 중 매개변수 없는 add를 실행 -> "add() 메소드" & "c : 10 + 20" 출력
		add();
		
		// 인수전달 한다 -> 2개 add 메소드 중 매개변수 있는 add를 실행 -> "2" 출력
		add(2);
		
		/* add(2, 3);
		 * 에러!
		 * 	>> add(int i)의 선언부에서 정해진 자료형과 정해진 개수의 인수를 전달해야 실행 가능
		 * 	>> 단 하나의 int형 인수를 전달해야, 안 그러면 에러
		 */
	}

	// 메소드 내에서 또다른 메소드를 만들 수 없다!!!
	// Java는 메소드의 순서가 중요하지 않다 --> main() method가 맨 처음이 아니어도 상관없다!!!
	
	// 매개변수 없고 외부에서 데이터를 받지 않고 실행 가능
	public static void add() {
		System.out.println("add() 메소드");
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println("c : " + a + " + " + b);
	}
	// int형 데이터 1개를 매개변수로 받아야 실행 가능
	public static void add(int n1) {
		System.out.println(n1);
	}
	
	/* 변수는 같은 이름의 변수가 2개 이상 존재할 수 없다 --> 변수를 구분할 수 있는 수단이 이름 밖에 없기 때문이다 
	 * 메소드는 괄호 () 속 매개변수에서 차이가 있다면 메소드 이름은 같아도 된다!!!
	 * 	>> "Method Overloading" 명칭
	 * 		>> 메소드의 이름이 같아도 매개변수가 다르면 다른 메소드로 인식하는 문법
	 * 		>> 매개변수가 다르다는 의미는 매개변수의 타입(종류), 개수, 순서가 다르다는 것이다
	 * 		>> the following are examples
	 */
	
	// 매개변수의 타입
	public static void add(int n1, int n2) {
		System.out.println(n1);
	}
	public static void add(int n1, float n2) {
		System.out.println(n1);
	}
	
	// 매개변수의 개수
	public static void add02(int n1, int n2) {
		System.out.println(n1);
	}
	public static void add02(int n1, int n2, int n3) {
		System.out.println(n1);
	}
	
	// 매개변수의 순서
	public static void add02(int n1, float n2) {
		System.out.println(n1);
	}
	public static void add02(float n1, int n2) {
		System.out.println(n1);
	}
}
