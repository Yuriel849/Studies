package study;

/* 변수의 생명 주기 (Life Cycle)
 * 	1) 멤버변수 (== 멤버필드 == 필드)
 * 		클래스가 활성화되어 있는 한 사라지지 않는다
 * 	2) 지역변수-1
 * 		메소드 내부에서 선언된 변수
 * 		메소드 실행 시 메모리에 로딩, 메소드의 종료 시 메모리에서 해제 (없어짐)
 * 			>> 메모리에서 자동으로 해제된다
 * 	3) 지역변수-2
 * 		메소드 내부의 또다른 코드블럭(중괄호 {}) 안에서 선언된 변수
 * 		ex) for, while, if 등의 코드블럭 안에서 선언된 변수
 */
		
public class Ex01_VariableLifeCycle {
	public static void main(String args[]) {
		int lv; // 지역변수-1
		
		// i <-- 지역변수-2
		for(int i=0; i<3; i++) {
			System.out.println(i);
		}
	}

}
