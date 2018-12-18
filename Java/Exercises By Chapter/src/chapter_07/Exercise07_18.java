package chapter_07;

// 주어진 객체의 메서드를 호출하는 프로그램을 작성하라.

class Exercise07_18 {
	static void action(Robot r) { // 매개변수는 Robot 인스턴스 OR Robot의 child 인스턴스
		if(r instanceof DanceRobot) {
			((DanceRobot) r).dance();
		} else if(r instanceof SingRobot) {
			((SingRobot) r).sing();
		} else if(r instanceof DrawRobot) {
			((DrawRobot) r).draw();
		}
	} // action() 끝.
	
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		
		for(int i = 0; i < arr.length; i++) { action(arr[i]); }
	} // main 끝.
} // 클래스 끝.

class Robot { }

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}