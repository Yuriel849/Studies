package study;

import java.util.Scanner;

public class Ex08_Operator08 {
	public static void main(String args[]) {
		/* 세 과목의 총점과 평균 구하기
		 * 		>> 22OCT2018의 Ex06_Variable05의 변형
		 */
		
		int score1 = 90;
		int score2 = 97;
		int score3 = 94;
		
		Scanner sc = new Scanner(System.in);
		/* program & process처럼...
		 * 		>> Scanner라는 파일을 활성화시켜 sc라는 이름을 붙인다
		 * 		>> sc의 실체는 Scanner (프로그램의 한 프로세스처럼)
		 * 		>> sc을 이용하여 Scanner 클래스 하위의 모든 멤버와 메소드 사용 가능
		 */
				
		/* String과 비교...
		 * String str = new String("abc");
		 * 		>> "str"이라고 이름붙인 String 타입 변수 선언
		 * 		>> new String()으로 "abc"라는 문자열을 메모리 어딘가에 저장하고 그 주소값을 반환
		 * 		>> 대입연산자로 반환된 주소값을 "str" 변수의 값으로  저장
		 * 
		 * !!! 변수는 자신의 자료형과 동일한 자료형만 저장될 수 있다 !!!
		 * 		>> int는 int형 자료만 받을 수 있고, String은 String 타입 주소값만 받을 수 있다
		 * 
		 * String은 Scanner와 달리 java.lang package 안에 위치
		 * 		>> java.util & et al.과 달리 java.lang은 별도로 import 필요없이 접근 가능하게 설정됨
		 * 
		 * String str = new String("");
		 * str.equals("A")
		 * 		>> String 클래스 속에 있는 equals() 메소드 호출, str의 내용물이 "A"와 똑같은지 판별하는 메소드
		 */

		/* Scanner
		 * java에서 제공하는 클래스... i.e. API
		 * 		>> 이미 제3자에 의해 정의된 클래스들을 우리가 사용할 수 있도록 java 설치 시 default로 포함되는 파일들
		 * 		>> 입출력에 필요한 여러 메소드들을 하나의 클래스 안에 묶어 놓은 것
		 * 
		 * Scanner의 실제 위치
		 * 		>> C: Program Files Java jdk1.8.0_192 src.zip java util
		 * 
		 * 원래 Scanner의 경로는 java.util.Scanner sc = new Scanner(System.in);
		 * 		>> "System.in"... 표준입출력이라는 의미
		 */
		
		System.out.printf("첫번째 성적을 입력하세요 : ");
		/* 의미
		 * 		>> java.lang에 위치한 "System"이라는 클래스에 접근
		 * 		>> System 클래스 내 "out"이라는 속성에 접근
		 *  	>> 속성을 통해 "printf"이라는 함수에 접근하여 실행
		 */
		score1 = sc.nextInt();
		System.out.printf("두번째 성적을 입력하세요 : ");
		score2 = sc.nextInt();
		System.out.printf("세번째 성적을 입력하세요 : ");
		score3 = sc.nextInt();
		// "."은 접근연산자... 특정 메소드나 멤버에 접근하기 위한 목적
		// ()가 붙은 것은 메소드라는 의미이자 이 코드를 실행하면서 그 메소드를 실행하라는 의미
		
		/* IO(입출력)나 네트워크 관련된 클래스 사용 후에는 close() 메소드를 사용하여 자원을 닫아주어야 (연결을 해제해야)
		 * BUT Scanner는 자동으로 관리되어서 sc.close();를 하지 않아도 된다
		 */
		sc.close();
		
		// 총점 저장 변수
		int total;
		
		// 평균 저장 변수
		float average;
		
		// +, -, *, /
		total = score1 + score2 + score3;
		average = total / 3.0F;
		// average = total / (float) 3;
		// average = (float)total / 3;
		
		/* 이것은 안된다!!
		 * 이미 괄호 속에서 total/3하고 소수점을 버린 후 결과물을 float로 바꿀뿐이다
		 * average = (float)(total / 3); == average = total / 3;
		 */
		
		// printf() 메소드로 출력하기
		System.out.printf("총점 : %d점, 평균 : %.2f점", total, average);
	}
}