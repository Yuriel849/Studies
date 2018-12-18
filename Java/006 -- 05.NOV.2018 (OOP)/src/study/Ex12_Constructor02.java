package study;

// !!! left+ctrl + 호출문 ==> 호출되는 그 코드로 이동 !!!

class A {
	public A() {
		this(10); // 같은 클래스 내의 다른 생성자 호출
				  //  	--> 생성자는 재귀호출 불가능하기에 괄호 혹 자료형과 메소드 자료형이 같으면 에러
		System.out.println("public A()");
	}
	public A(int i) {
		this(10F);
		System.out.println("public A(int i)");
	}
	public A(float f) {
		this(10.0);
		System.out.println("public A(float f)");
	}
	public A(double d) {
		System.out.println("public A(double d)");
	}
	
	public void display() { // 일반 메소드
		// this(23.54); --> 에러 --> 일반 메소드에서 this로 생성자 호출 불가능
	}
}

public class Ex12_Constructor02 {
	public static void main(String[] args) {
		System.out.println("프로그램 시작\n");
		new A(); // 기본 생성자 호출
			/* 호출하면...
			 * 		--> 기본 생성자 호출
			 * 		--> int 매개변수 받는 생성자 재귀호출
			 * 		--> float 매개변수 받는 생성자 재귀호출
			 * 		--> double 매개변수 받는 생성자 재귀호출
			 * 		--> 재귀호출한 코드 실행이 끝나면 재귀호출한 지점으로 돌아가서 다음 코드 실행 
			 */		
		System.out.println("\n프로그램 종료");
	}
}