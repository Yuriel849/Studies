package study;

/* Call by Value & Call by Reference
 * 	>> Java에서의 call by value는 C언어와 동일
 * 	>> Java에서의 call by reference는 다르다
 */

public class Ex06_Method02 {
	// Call by Value 값에 의한 호출
	public static void method(int number) {
		number = 332;
	}
	public static void main(String[] args) {
		int number = 10;
		
		System.out.println("number : " + number);
		
		method(number); // number == 10을 인수전달하면서 method 메소드를 호출
		System.out.println("number : " + number);
	}

}
