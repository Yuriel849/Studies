package study;

/* Call by Value & Call by Reference
 * 	>> Java에서의 call by value는 C언어와 동일
 * 	>> Java에서의 call by reference는 다르다
 */

public class Ex07_Method03 {
	// Call by Reference 참조에 의한 호출
	public static void method(int[] number) {
		number[2] = 332;
	}
	public static void main(String[] args) {
		int[] number = {10, 20, 30, 40, 50};
		
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println("\n\n===============\n");
		method(number);
		/* 배열의 경우...
		 * "number"는 number 배열의 주소를 의미
		 * number[A]를 해야지 배열의 값을 의미
		 */

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
	}

}
