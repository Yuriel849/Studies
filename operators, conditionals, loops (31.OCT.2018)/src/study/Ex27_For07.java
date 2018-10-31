package study;

public class Ex27_For07 {
	public static void main(String[] args) {
		
		// 기본형 변수
		int number = 10;
		number = 20;
		// number의 값: 10 --> 20
		
		// 배열
		int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		// int[] array == int array[]
		System.out.println(array[0] + "\n");
		
		for(int i=0; i<9; i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}

/*		 전체 주석처리
		 * left ctrl + left shift + slash(/)
		 * 전체 주석처리 해제
		 * left ctrl + left shift + reverse slash(\)
*/		 
		
		String str = "abc";
		// index의 위치에 있는 문자를 반환
		char ch = str.charAt(1);
		System.out.print(ch);
		// ch값은 str의 1번째 자리의 값, 'b'
	}

}
