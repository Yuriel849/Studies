package study;

class InnerClass2 {
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Outer2.Inner2 inner = outer.new Inner2();
		inner.method1();
	} // main() 끝.
} // InnerClass2 끝.

class Outer2 {
	int value = 10;
	
	class Inner2 {
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println("           value : " + value); // method1 메서드의 value --> method1에 value가 없으면 this.value와 같다.
			System.out.println("      this.value : " + this.value);	// 내부 클래스의 value
			System.out.println("Outer.this.value : " + Outer2.this.value); // 외부 클래스의 value
		}
	} // Inner 클래스 끝.
} // Outer 클래스 끝.
