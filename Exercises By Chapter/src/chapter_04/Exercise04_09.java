package chapter_04;

// 문자열의 각 문자를 더해서 합을 구하라 (문자열 "12345")

public class Exercise04_09 {
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		
		System.out.println("sum = " + sum);
	} // main() 끝.
} // 클래스 끝.