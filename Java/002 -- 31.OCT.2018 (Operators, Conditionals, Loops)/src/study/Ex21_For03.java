package study;

public class Ex21_For03 {
	public static void main(String args[]) {
		// 변수의 접근 범위 (== 유효범위 == scope)
		
		int num;
		/* 변수 num은 main() method 내부에서 바로 선언되었으므로
		 * 		변수 num이 선언된 부분부터 main() method 종료될 때까지 메모리 상에 남아있음
		 * 	>> main() 내의 num은 main이 끝날 때까지 모든 코드에 영향을 미친다
		 * 	>> main() 내에서의 유일한 num이다 
		 * 
		 * 자바는 소스코드에서의 scope, 작동 등이 실제 메모리에서의 상호작용이나 작동과 거의 일치한다...
		 * 	>> main() method, main 내의 num은 모두 Call Stack 영역에 저장
		 * 	>> for문, for 내의 i는 for문이 실행될 때 생겼다가 실행 끝나면 ({} 닫히면) 사라진다
		 * 	>> 아래의 2개 for문은 서로 다른 for문으로 시간 차를 두고 생겼다가 없어진다... 2개의 i는 이름만 같을뿐 완전히 다르다
		 */
		
		for(int i=1; i<=3; i++) {
			/* int num;
			 * 에러
			 * 	>> main() 내의 num과 동시에 존재한다 --> 어느 쪽이 "진짜"인가?
			 * 								  --> num을 사용하면 어느 num을 사용해야하는가?
			 * 	>> 다른 이름을 붙이던가 (i.e. int num1;),
			 * 		  자료형을 없애 main() 내의 num에 접근하던가 (i.e. num = 10;)
			 */
			System.out.printf("i = %d%n", i);
		}
		
		for(int i=1; i<=3; i++) {
			System.out.printf("i = %d%n", i);
		}
	}
}