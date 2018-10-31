package study;

public class Ex11_If02 {
	public static void main(String args[]) {
		System.out.println("프로그램 시작");
		int number = 10;
		
		if (number >= 15)
			System.out.println("조건식이 참입니다-1");
			System.out.println("조건식이 참입니다-2");
			/* 이 경우, 중괄호 {} 없기 때문에 if문의 실행문은 첫번째 문장 "조건식이 참입니다-1" 단 하나
			 * "조건식이 참입니다-2"는 indent와 상관없이 if문의 실행문으로 취급하지 않아서 실행
			 *	
			 * !!! indent는 사용자(프로그래머)의 가독성을 위한 것 !!!
			 *		>> 컴퓨터 입장에서는 indent 있던 없던 중괄호{}로 스코프를 확인
			 * 		>> 중괄호 {} 넣어야 여러 문장을 모두 if문의 실행문으로 묶을 수 있음
			 */
		
			System.out.println("프로그램 종료");
	}

}