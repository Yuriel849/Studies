package study;

// 1. 클래스 정의
class Tv { // Tv 클래스의 시작
	String color; // Tv의 색깔
	boolean power; // 전원 on/off --> true면 on, false면 off
	int channel; // 채널
	
	void power() {
		power = !power; // 전원 on/off 전환하기
		// 위 한 줄과 같은 if-else문
//		if(power==true)
//			power = false;
//		else
//			power = true;
	}
	void channelUp() {
		channel++; // 채널 올리기
	}
	void channelDown() {
		channel--; // 채널 내리기
	}
} // Tv 클래스의 끝

public class Ex10_TvTest {
	public static void main(String[] args) {
		// 2. 객체의 생성
		Tv tv = new Tv();
		Tv tv2 = new Tv();
		
		// 3. 객체의 사용 == 객체의 속성 & 기능 사용
		tv.power(); // tv가 가진 기능을 사용
		tv.channel = 7;
		tv.channelUp();
		tv.color = "white"; // tv의 속성을 변경 --> tv의 색깔을 white으로 변경
		
		tv2.power(); // --> 꼭 참조변수가 필요
		
		System.out.println("현재 채널은 " + tv.channel + "입니다.");
	}
}
