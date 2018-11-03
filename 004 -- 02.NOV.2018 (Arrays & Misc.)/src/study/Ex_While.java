package study;

import java.util.Scanner;

public class Ex_While {
	public static void main(String[] args) {
		int num = 0;
		int sum = 0;
		
		System.out.print("숫자를 입력하세요 (예:12345)");
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine(); // 화면을 통해 입력받은 내용을 tmp에 저장
		num = Integer.parseInt(tmp); // 입력받은 문자열(tmp)을 숫자로 변환
			/* Integer.parseInt(A)는 A라는 문자열을 int 타입 숫자로 변환하는 메소드
			 * 		>> 문자열이 int의 범위 (약 +/-20억) 안의 숫자여야 한다!!
			 * 		>> tmp에 너무 큰 값을 입력한다면 NumberFormatException 에러난다
			 * 		>> int의 범위를 초과한 숫자를 사용하고자 한다면, Long.parseLong(tmp) 사용 
			 */
		
		while(num != 0) {
			// num을 10으로 나눈 나머지를 sum에 더함
			sum += num%10; // sum = sum + num%10;
			System.out.printf("sum=%3d num=%d%n", sum, num);
			
			num /= 10; // num = num / 10; --> num을 10으로 나눈 값을 다시 num에 저장
		}
		
		System.out.println("각 자리수의 합: " + sum);
	}

}
