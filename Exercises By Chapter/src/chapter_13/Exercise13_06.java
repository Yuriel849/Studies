package chapter_13;

// 원래라면 main 쓰레드에사 예외가 발생하면서 종료되어야 하지만, eclipse여서 그런지 종료되지 않는다.

class Exercise13_06 {
	@SuppressWarnings("static-access")
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