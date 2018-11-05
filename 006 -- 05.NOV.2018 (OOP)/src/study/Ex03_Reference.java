package study;

/* 레퍼런스 변수 (== 참조변수 == 참조 == 레퍼런스)
 * 	>> 기본형의 값(정수, 실수, 문자 등)이 아닌 데이터의 주소(위치값)를 저장하는 변수
 * 	>> 레퍼런스 변수가 참조하는 데이터는 Heap memory 영역에 저장된다 (로딩된다)
 * 		<-> 레퍼런스 변수 그 자체는 CallStack memory 영역에 저장된다 
 * 	>> 기본형 이외의 타입 : 배열 타입, 클래스 타입
 * 	>> 기본값(초기값)은 'null'
 */

public class Ex03_Reference {
	public static void main(String[] args) {
		String str = new String("abc");
		String str2 = "abc";
		
		int[] array = new int[5];
		
		// str & array 초기화하기
		str = null;
		array = null;

	}

}
