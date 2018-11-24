package chapter_06;

// shuffle() 메서드를 작성하라.

public class Exercise06_20 {
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		System.out.println(java.util.Arrays.toString(original));
	}
	
	static int[] shuffle(int[] arr) {
		// int[] ARR = arr;
		/* shuffle(original) 실행
		 * 	>> original이라는 변수에 저장된 주소값 전달
		 * 	>> shuffle 메서드의 매개변수에 주소값 대입
		 * 	>> ARR에 주소값 대입
		 * 		>> ARR는 original과 같은 배열을 참조하고 있다.
		 */
		
		if(arr==null || arr.length == 0) { return arr; }
		/* 유효성체크
		 * 	>> 매개변수로 전달한 배열이 null이거나 길이 0일 때 처리하기 위한 코드
		 */
		
		int temp;
		for(int i = 0; i < 100; i++) {
			int j = (int)(Math.random() * 7 + 1);
			temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
}
