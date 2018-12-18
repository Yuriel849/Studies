package chapter_08;

// 예외 되던지기 (error re-throwing)

class Exercise08_10 {
	public static void main(String[] args) {
		try {
			method1();
			System.out.println(6);
		} catch(Exception e) {
			System.out.println(7);
		}
	} // main() 끝.
	
	static void method1() throws Exception {
		try {
			method2();
			System.out.println(1);
		} catch(NullPointerException e) {
			System.out.println(2);
			throw e; // 예외를 다시 발생시킨다 --> 예외 되던지기
			// method1()은 여기서 finally블럭 실행 후 끝나고 main()으로 돌아간다.
				// 만약 여기 catch블럭 내에서 다시 try-catch문을 작성한다면,
				// 				예외를 처리하고 method1()을 계속 실행할 수 있다.
		} catch(Exception e) {
			System.out.println(3);
		} finally {
			System.out.println(4);
		}
		
		System.out.println(5);
	} // method() 끝.
	
	static void method2() {
			// NullPointerException을 발생시킨다.
		throw new NullPointerException();
	} // method2() 끝.
} // 클래스 끝.

