package study;

class Ex02_DeliberateException {
	public static void main(String[] args) {
		try {
//			ArithmeticException exc = new ArithmeticException("고의로 발생시켰음"); // 예외 객체 선언과 생성
//			throw exc;
			Exception ex = new ArithmeticException("다시 고의로 발생시켰음");
			/* 위에 있는 exc를 주석처리 안하면 "unreachable code" 에러
			 * 	>> exc를 throw하면서 try 블럭에서 catch 블럭으로 넘어가기에 여기를 절대 실행하지 않는다.
			 */			
			throw ex;
		} catch (ArithmeticException ae) { // "catch (Exception)" 아래에 있으면 에러 --> Exception에서 모든 예외를 처리하기에 절대 실행 안된다.
			// 여기가 비었기에 실행 시 20번 줄만 출력된다.
		} catch (Exception ee) { // catch의 참조변수(여기서는 "ae")로 예외객체에 접근할 수 있다.  
			System.out.println("에러 메시지: " + ee.getMessage()); // getMessage 함수로 예외 객체의 내부 정보 가져온다.
			ee.printStackTrace(); // 예외발생 당시의 호출스택에 있었떤 메서드의 정보와 예외 메세지를 화면에 출력한다.
								  // 어느 메서드에서 무엇을 하다가 에러가 났는지 보여준다.
		}
		System.out.println("프로그램이 정상 종료되었음.");
	}
	
	// catch블럭에스는 예외 객체를 사용할 수 있다 --> 예외 객체는 그 안에 정보를 담고 있다
	// printStackTrace --> "호출 스택 출력" 메서드 --> 어느 메서드가 어느 메서드를 호출하다가 어디서 에러 났는지 인과관계를 보여준다.

}
