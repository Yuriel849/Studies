package chapter_13;

// 쓰레드 th1을 생성해서 실행시킨 후 6초 뒤에 정지시킨다.
//	>> 하지만 실제로 실행시키면 정지시킨 다음에도 몇 초가 지난 후에서야 멈춘다.
//	>> 그 이유를 설명하고 쓰레드를 정지시키면 지체없이 바로 정지되도록 코드를 개선하라.
//		>> stopped의 상태가 바뀌어도 th1이 그 당시 sleep 중이면 정지할 수 없다. 그래서 sleep을 interrupt할 필요가 있다.

public class Exercise13_07 {
	static boolean stopped = false;
	
	public static void main(String[] args) {
		Thread5 th1 = new Thread5();
		th1.start();
		
		try {
			Thread.sleep(6*1000);
		} catch(Exception e) {}
		stopped = true; // 쓰레드를 정지시킨다.
		th1.interrupt();
		System.out.println("stopped");
	} // main() 끝.
} // 클래스 끝.

class Thread5 extends Thread {
	public void run() {
	// Exercise13_7.stopped의 값이 false인 동안 반복한다.
		for(int i=0; !Exercise13_07.stopped; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(3*1000);
			} catch(Exception e) {}
		}
	} // run() 끝.
} // Thread5 클래스 끝.