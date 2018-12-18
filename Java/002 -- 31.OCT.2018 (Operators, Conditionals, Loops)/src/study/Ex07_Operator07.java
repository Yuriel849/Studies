package study;

public class Ex07_Operator07 {
	public static void main(String args[]) {
		//삼항연산자
		int x = -10;
		int result = (x>=0) ? x : -x;
		System.out.println("result : " + result + "\n");
		
		int number = 11;
		String str = (number % 2 == 0) ? "짝수입니다" : "홀수입니다";
		System.out.println("Even or Odd?? (number = " + number + ") : " + str);
		System.out.printf("Even or Odd?? (number = %d) : %s\n\n", number, str);
		
		int gender = 1;
		String str2 = (gender == 1 || gender == 3) ? "남자" : "여자";
		System.out.printf("당신은 %s입니까?", str2);
	}
}