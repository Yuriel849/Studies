package chapter_13;

/* 실행결과를 예측하라.
 * 		>> th1은 0부터 9까지의 숫자를 1초에 한번씩 한줄 한줄 출력한다.
 * 		>> main()에서는 th1.sleep을 사용하나 th1 대신 main 쓰레드가 sleep한다.
 * 		>> main쓰레드에서 의도적으로 예외를 발생시키고 suspend된다.
 * 		>> main쓰레드는 예외 처리를 하지 않았기에 끝나지 않고, th1은 데몬쓰레드이지만 무한반복이 아니기에 종료된다. 
 */

class Exercise13_06 {
	public static void main(String[] args) throws Exception	{
		Thread4 th1 = new Thread4();
		th1.setDaemon(true);
		th1.start();
		
		try {
			th1.sleep(5*1000);
		} catch(Exception e) {}
		
		throw new Exception("꽝~!!!");
	} // main() 끝.
} // 클래스 끝.

class Thread4 extends Thread {
	public void run() {
		for(int i=0; i < 10; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}
	} // run() 끝.
} // Thread4 클래스 끝.