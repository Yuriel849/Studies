package chapter_13;

/* 실행결과를 예측하라.
 *		>> 0부터 9까지의 숫자를 1초마다 하나씩 한줄 한줄 출력한다.
 *		>> 출력 도중 main 쓰레드에서 예외를 발생시키지만, 숫자 출력은 계속된다.
 *		>> th1 쓰레드는 종료되지만 main 쓰레드는 끝나지 않고 suspend된다.
 */

class Exercise13_05 {
	public static void main(String[] args) throws Exception {
		Thread3 th1 = new Thread3();
		th1.start();
		
		try {
			Thread.sleep(5*1000);
		} catch(Exception e) {}
		
		throw new Exception("꽝~!!!");
	} // main() 끝.
} // 클래스 끝.

class Thread3 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	} // run() 끝.
} // Thread3 클래스 끝.