package study;

class InnerClass {
	public static void main(String[] args) {
		Outer o = new Outer(); // Outer 클래스의 객체 생성
		System.out.println("o.iv = " + o.iv); // '100' 출력 --> Outer 클래스의 인스턴스변수 iv

		// Inner 내부클래스를 사용하려면 Outer 클래스의 객체를 먼저 생성해야 한다.
//		Outer.Inner i = o.new Inner(); // Inner라고만 하면 내부 클래스를 찾지 못한다.
//									   // 내부클래스는 외부클래스 내부에서만 사용하기 위한 것이기에 사용하기가 불편하다.
//		System.out.println("i.iv = " + i.iv); // '200' 출력

		Outer.StaticInner i = new Outer.StaticInner(); // Inner 클래스가 static이기에 Outer 객체 생성 없이 접근 가능하다.
		System.out.println("Outer.StaticInner.cv = " + Outer.StaticInner.cv); // '500' 출력
		System.out.println();
	}
}

class Outer {
	int iv = 100;

	// Outer 객체를 먼저 생성해야 InstanceInner 객체를 생성 가능
	class InstanceInner {
		int iv = 200;
//		static int cv = 300; // 에러! --> 클래스가 static이 아닌데 (Outer 객체를 만들지 않고는 사용할 수 없는데), 어떻게 내부에 static멤버가 있나?
	}
		
	// Outer 객체 생성 없이 StaticInner 객체를 생성 가능하다.
	static class StaticInner {
		int iv = 400;
		static int cv = 500;
	}
}