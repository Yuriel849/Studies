package study;

/* 클래스란...
 * 	1. 설계도
 * 	2. 변수와 함수의 결합
 * 	3. 사용자 정의 타입
 */

/* 클래스 사용하는 것이 사용하지 않는 것보다
 * 	>> 코드 중복을 줄이고
 * 	>> 코드 관리가 수월하고 --> 클래스에서만 코드 수정하면 해당 클래스의 객체의 모든 데이터와 함수도 함께 변한다
 */

class Time {
	/* 클래스를 정의한다고 해서 hour, minute, second의 저장공간이 생기는 것이 아니다.
	 * 	>> 클래스 정의는 설계도 작성 --> 실제로 클래스를 사용하는 것은 아니다.
	 */
	int hour;
	int minute;
	int second;

}

public class Ex09_TimeTest {
	public static void main(String[] args) {
		// 객체를 생성해야 Time 클래스의 멤버변수들의 저장공간이 생긴다.
		Time time = new Time();
		System.out.println(time.hour);
		System.out.println(time.minute);
		System.out.println(time.second);
		
		System.out.println();
		
		// main() 메서드 실행하면서 바로 저장공간이 생긴다.
		int hour = 12;
		int minute = 34;
		int second = 56;
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		int hour2 = 12;
		int minute2 = 34;
		int second2 = 56;
		System.out.println(hour2);
		System.out.println(minute2);
		System.out.println(second2);
		int hour3 = 12;
		int minute3 = 34;
		int second3 = 56;
		System.out.println(hour3);
		System.out.println(minute3);
		System.out.println(second3);
		int hour4 = 12;
		int minute4 = 34;
		int second4 = 56;
		System.out.println(hour4);
		System.out.println(minute4);
		System.out.println(second4);
	}
}
