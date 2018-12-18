package chapter_13;

// Thread 클래스로부터 상속 받는 코드를 Runnable 인터페이스를 구현하도록 수정하라.

class Exercise13_01 {
	public static void main(String args[]) {
		Thread th1 = new Thread(new Thread1());
		th1.start();
	}
} // 클래스 끝.

class Thread1 implements Runnable {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('-');
		}
	}
} // Thread1 클래스 끝.

	// 기존의 Thread를 상속받은 클래스
//class Thread1 extends Thread {
//	public void run() {
//		for (int i = 0; i < 300; i++) {
//			System.out.print('-');
//		}
//	}
//}