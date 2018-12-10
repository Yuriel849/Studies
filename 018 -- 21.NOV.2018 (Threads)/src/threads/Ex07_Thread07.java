package threads;

import javax.swing.JOptionPane;

// Ex08_Thread08와 비교!!

class Ex07_Thread07 {
	public static void main(String[] args) throws Exception {
		Ex07_Thread07_1 th1 = new Ex07_Thread07_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요. ");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt(); // interrupt()를 호출하면, interrupted 상태가 true가 된다.
		System.out.println("isInterrupted(): " + th1.isInterrupted()); // true가 출력되어야 한다
	} // main() 끝.
} // 클래스 끝.

class Ex07_Thread07_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted())	{
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++); // 시간 지연용
		}
		
		System.out.println("카운트가 종료되었습니다.");
	} // run() 끝.
} // 클래스 끝.