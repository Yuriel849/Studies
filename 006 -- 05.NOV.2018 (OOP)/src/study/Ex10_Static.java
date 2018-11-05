package study;

public class Ex10_Static {
	int iv;
	static int cv;
	
	void instanceMethod01() {	}
	static void staticMethod01() { 	}
	
	void instanceMethod02() {
		System.out.println(iv); // 인스턴스 메소드는 객체 생성 후에야 사용가능하니까 인스턴스 멤버 사용에 문제 없음
		System.out.println(cv);
		instanceMethod01();
		staticMethod01();
	}
	
	static void staticMethod02() {
		// System.out.println(iv); --> 객체 생성 전 실행하려하니까 에러
		System.out.println(cv);
		// instanceMethod01(); --> 객체 생성 전 실행하려하니까 에러
		staticMethod01();
		Ex10_Static st = new Ex10_Static();
		System.out.println(st.iv);
		st.instanceMethod01();
	}

}
