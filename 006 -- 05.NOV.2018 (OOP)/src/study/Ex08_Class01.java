package study;

public class Ex08_Class01 {
	public static void main(String[] args) {
		Time time = new Time();
		
		System.out.println(time.hour);
		System.out.println(time.minute);
		System.out.println(time.second);

		// int[] t = new int[3]; --> 비교용
		Time[] time2 = new Time[3];
			/* Time 타입의 데이터를 받을 수 있는 3칸짜리 "time2"라고 부르는 배열 생성
			 * 		--> 각 칸에는 (기본형이 아니니까) 주소값만 받을 수 있다
			 * 		--> 초기화되지 않는다
			 * 		--> 실행하면 참조를 따라갔는데, 그곳에는 아무것도 없으니까 null이라고 에러남
			 */
		// 아래 3개 실행문(Lines 19~21)이 없으면 NullPointerException 발생
		time2[0] = new Time(); // time2 배열의 각 칸에 Time의 객체를 생성하여 그 주소값을 저장
		time2[1] = new Time(); // 		--> 이제 참조하여 배열의 칸에 찾아가면 Time의 객체가 있을 것이다
		time2[2] = new Time();
		
		System.out.println(time2[0]);
			/* time2 배열의 첫번째 칸에 담긴 값을 반환
			 * 		--> 객체의 주소값
			 * 		--> "study.Time@1175e2db"
			 * 		--> study라는 package의 Time이라는 클래스 + 16진수 주소값
			 */

		time2[0].hour = 10;
		time2[0].minute = 20;
		time2[0].second = 30;
		time2[1].hour = 40;
		time2[1].minute = 50;
		time2[1].second = 60;
		time2[2].hour = 70;
		time2[2].minute = 80;
		time2[2].second = 90;
		
		System.out.println(time2[0].hour);
		System.out.println(time2[0].minute);
		System.out.println(time2[0].second);
		System.out.println(time2[1].hour);
		System.out.println(time2[1].minute);
		System.out.println(time2[1].second);
		System.out.println(time2[2].hour);
		System.out.println(time2[2].minute);
		System.out.println(time2[2].second);
	}

}