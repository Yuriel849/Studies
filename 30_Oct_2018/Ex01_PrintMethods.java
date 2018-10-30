package study;

public class Ex01_PrintMethods {
	public static void main(String args[]) {
		// Java의 출력 메소드 --> print, println, printf
		
		// 1. print
		/* 메소드의 인자값을 콘솔 화면에 출력함
		 * 		>> "인자값"은 메소드의 () 속에 들어가는 것
		 * 자동 줄바꿈 X
		 */
		// Hello Java !!!
		System.out.print("1. Hello");
		System.out.print(" Java !!!\n");
		
		// Hello
		// Java !!!
		System.out.print("\n");
		System.out.print("2. Hello \n");
		System.out.print("Java !!!");
		System.out.print("\n\n");
		// \n <-- new line
		
		// 2. println
		/* 메소드의 인자값을 콘솔 화면에 출력함
		 * 자동 줄바꿈 O
		 */
		// Hello
		// Java !!!
		System.out.println("3. Hello");
		System.out.println("Java !!!");
		
		// 3. printf
		/* 서식문자를 사용해서 정의한 폼에 맞추어서 화면에 출력함
		 * 		>> "서식문자" == 변환문자
		 * 		%s: 문자열		%c: 문자 하나
		 * 		%d: 정수(10진수)	%f: 실수(float)
		 * 자동 줄바꿈 X
		 * 		>> printf에 한해서 \n 대신 %n 사용해도 된다
		 */
		System.out.printf("\n4. %s 과목은 %d 점입니다.", "국어", 100);
		System.out.printf("%n5. %s 과목은 %d 점입니다.\n", "영어", 200);
		/* 여러 인자를 구분하기 위해서 ","을 사용
		 * 		>> (format, args) == 첫번째 인자 format, 두번째 인자 args
		 * 		>> args에서 s가 붙은 것은 여러가지 인자를 여기에 받을 수 있다는 뜻
		 * 		>> ","로 구분하기를 첫번째 "," 이전 내용 전체가 format에 할당하고 그 이후 모든 내용은 args에 할당
		 * ''로 문자 하나를 받고, ""로 문자열을 받고
		 */
		System.out.printf("\n6. %5s 과목은 %+5d 점입니다.", "국어", -100);
		System.out.printf("%n7. %5s 과목은 %+5d 점입니다.\n", "영어", 200);
		
		System.out.printf("\n8. %-5s 과목은 %+-5d 점입니다.", 'K', -100);
		System.out.printf("%n9. %-5s 과목은 %-+5d 점입니다.\n", 888, -200);
		/* "%s"에다가 String 외의 것을 넣어도 자동으로 String으로 변환시키기에 에러 없이 실행된다.
		 * 다만 가독성이 떨어지기에 잘 사용하지 않고, 알맞은 서식문자가 있으면 그것을 쓰는 것이 좋다.
		 */
		
	}
	
}
