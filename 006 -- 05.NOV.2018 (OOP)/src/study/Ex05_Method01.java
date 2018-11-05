package study;

public class Ex05_Method01 {
	static void test01() {
		System.out.println("test01() 실행1");
		return; // return;을 쓰지 않아도 (보이지는 않지만) 메소드의 끝에 존재한다
		/* System.out.println("test01() 실행2");
		 * 		>> return;에서 메소드는 자동종료하기에 그 이후에 위치한 코드는 무시 
		 */
	}
	
	// main 메소드는 반환값이 없다 --> void를 반환한다 --> void 메소드다
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		test01();
		test01(4F); // 실수 4를 반환 받지만 어딘가에 사용하지 않기에 버려진다
		System.out.println("test01(4F)의 두번째 실행");
		System.out.println(test01(4F));
		System.out.println("프로그램 종료");
	}
	
	static float test01(float number) {
		System.out.println("test01(int number) 실행1");
		/* 매개변수로 전달받은 데이터를 써도 안 써도 상관 없다
		 * 하지만 매개변수로 값을 전달 받지 않으면 실행조차 안된다
		 */		
		System.out.println(number);
		return number * 4.2F; // void 메소드는 void만을 반환할 수 있다!!!
		// return 뒤의 것을 return keyword라고 부른다 (==반환값)
	}

}
