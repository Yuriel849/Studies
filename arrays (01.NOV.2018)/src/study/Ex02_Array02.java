package study;

public class Ex02_Array02 {
	public static void main(String[] args) {
		// 배열의 선언과 생성을 두 줄로 함
		int[] array1;
		array1 = new int[3];
		
		// 배열의 선언과 생성을 동시에 함
		int[] array2 = new int[3];
		
		// 배열의 선언과 생성과 초기화를 동시에 함
		int[] array3 = new int[] {10, 20, 30};
		// new int[] 생략 가능
		int[] array4 = {10, 20, 30};
		
		// 배열의 선언과 생성, 초기화를 한 줄에 하지 않음
		int[] array5 = new int[3];
		// new int[] 생략할 수 없음
		array5 = new int[] {40, 50, 60};
		
		// 향상된 for문으로 출력
		for(int num : array5) {
			System.out.println(num);
		}
	}

}
