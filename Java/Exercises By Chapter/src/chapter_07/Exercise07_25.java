package chapter_07;

// Outer클래스의 Inner 내부클래스의 멤버변수 iv의 값을 구하라.

class Outer {
	class Inner {
		int iv = 100;
	} // 내부클래스 Inner 끝.
	
	static class Inside {
		int iv = 200;
	} // 내부클래스 Inside 끝.
} // 외부클래스 Outer 끝.


class Exercise07_25 {
	public static void main(String[] args) {
		// Outer 클래스의 내부 클래스 Inside의 멤버변수 iv를 출력한다.
		Outer.Inside inside = new Outer.Inside(); // Inside 내부클래스는 static이기에 외부클래스 객체생성이 불필요하다
		System.out.println(inside.iv);			  // 	>> 하지만 iv가 인스턴스변수이기에 iv에 접근하려면 객체 생성을 해야한다
		
		// Outer 클래스의 내부 클래스 Inner의 멤버변수 iv를 출력한다.
		Outer out = new Outer(); 		  // 1. 외부 클래스 객체를 생성
		Outer.Inner in = out.new Inner(); // 2. 내부 클래스 객체를 생성
		System.out.println(in.iv);		  // 	>> 참조변수 타입은 <외부>.<내부>, 생성 시 <외부 객체명>.new <내부 생성자>
	} // main() 끝.
} // 클래스 끝.
