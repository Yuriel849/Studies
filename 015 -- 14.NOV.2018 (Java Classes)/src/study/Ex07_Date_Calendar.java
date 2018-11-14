package study;

import java.util.Calendar;
import java.util.Date;

public class Ex07_Date_Calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간으로 Calendar 객체 생성
		Calendar cal2 = Calendar.getInstance();
		
		System.out.println("현재 날짜와 시간으로 Calendar 생성한 직후");
		System.out.println(cal);
		System.out.println(cal2);
		
		cal.clear(); // 기존에 설정된 날짜와 시간을 삭제 --> 새롭게 설정할 수 있다
		cal2.clear(); // clear() 사용하지 않고 set()하면 서로 다른 값이 저장된다 --> 시간을 nanosecond 수준으로 기록하기 때문이다
		
		System.out.println("clear()로 기존 설정 삭제 직후");
		System.out.println(cal); // clear()한 상태에서 값이 모두 "?"이거나 초기값인 것을 볼 수가 있다
		
		cal.set(2008, 10, 13); // Month는 0이 January, Date는 우리가 아는데로
		cal2.set(2008, 10, 13);
		
		System.out.println("set()으로 년,월,일 새롭게 설정 직후");
		System.out.println(cal); // clear() 후 set()하면서 set할 때 설정한 값들만 채워진 것을 볼 수가 있다
		System.out.println(cal2);
		
		System.out.println();
		System.out.println(cal.equals(cal2));
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(new Date(cal.getTimeInMillis())); // cal의 모든 정보가 아닌, Date 형식에 맞춰 출력하도록 Date로 변환한다.

	}
}
