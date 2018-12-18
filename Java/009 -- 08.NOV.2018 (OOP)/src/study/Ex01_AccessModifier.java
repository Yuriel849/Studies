package study;

class Time {
	// 클래스 영역에는 속성과 기능만 작성할 수 있다 --> 문장(ex) println)은 메서드 영역에서 작성해야 한다
	
	private int hour;
	private int minute;
	private int second;
	
	// private Time() { } --> 생성자를 private으로 만들면 외부에서 생성자 사용 불가능 --> 객체 생성 불가능
	
	int getHour() { // 접근제어자가 default
		return hour;
	}
	
	// 매개변수의 값으로 hour 변수의 값을 바꾼다
	void setHour(int hour) {
		if (hour < 0 || hour > 23) return;
		this.hour = hour;
	}
}

public class Ex01_AccessModifier {
	public static void main(String[] args) {
		Time t = new Time();
		// t.hour = 10;
			/* hour 변수를 private으로 바꾸면 "not visible" 에러난다
			 * 	>> not visible --> 보이지 않는다 --> private이기 때문에 "존재하지만 밖에서 안보인다" 의미
			 * 변수의 특징 --> scope & visibility
			 * 	>> scope --> 변수가 어디 코드부터 어디 코드까지 살아 있는가?
			 * 	>> visibility --> 살아 있는데 보이는가? 여기서 그것을 사용할 수 있는가?
			 */
		System.out.println(t.getHour());
		t.setHour(10);
		System.out.println(t.getHour());
	}

}
