package threads;

// join() 사용하기

class Ex12_Thread12 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Ex12_Thread12_1 th1 = new Ex12_Thread12_1();
		Ex12_Thread12_2 th2 = new Ex12_Thread12_2();
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
			th2.join(); // main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
		} catch (InterruptedException e) {}

		System.out.println("소요시간 : " + (System.currentTimeMillis() - Ex12_Thread12.startTime));
	} // main() 끝.
} // 클래스 끝.

class Ex12_Thread12_1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	} // run() 끝.
} // 클래스 끝.

class Ex12_Thread12_2 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
	} // run() 끝.
} // 클래스 끝.