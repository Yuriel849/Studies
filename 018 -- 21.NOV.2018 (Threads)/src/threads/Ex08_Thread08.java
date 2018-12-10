package threads;

import javax.swing.JOptionPane;

// Ex07_Thread07와 비교!!

class Ex08_Thread08 {
	public static void main(String[] args) throws Exception {
		Ex08_Thread08_1 th1 = new Ex08_Thread08_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요. ");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt(); // interrupt()를 호출하면, interrupted 상태가 true가 된다.
		System.out.println("isInterrupted(): " + th1.isInterrupted()); // true도 false도 나올 수 있다 --> 왜? who cares --> 멈췄다는게 중요하다
	} // main() 끝.
} // 클래스 끝.

class Ex08_Thread08_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted())	{
			System.out.println(i--);
			try {
				Thread.sleep(1000); // 1초씩 지연
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		
		System.out.println("카운트가 종료되었습니다.");
	} // run() 끝.
} // 클래스 끝.