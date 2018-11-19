package study;

class Outer2 {
	int value = 10;
	
	class Inner2 {
		int value = 20;
		void method1() {
			int value = 30;
			
				// 지역변수 value 출력
			System.out.println(value);
				// Inner 내부클래스의 인스턴스 변수 출력
			System.out.println(this.value);
				// Outer 외부클래스의 인스턴스 변수 출력
			System.out.println(Outer2.this.value);
		} // method1() 끝.
	} // 내부클래스 Inner 끝.
} // 외부클래스 Outer 끝.

class Ex07_Outer_Inner02 {
	public static void main(String[] args) {
		Outer2 out = new Outer2();
		Outer2.Inner2 inner = out.new Inner2();
		inner.method1();
	} // main() 끝.
} // 클래스 끝.
