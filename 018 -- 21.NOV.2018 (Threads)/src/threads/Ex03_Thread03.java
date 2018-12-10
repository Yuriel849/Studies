package threads;

import javax.swing.JOptionPane;

// Ex02_Thread02와 비교!!

class Ex03_Thread03 {
	public static void main(String[] args) throws Exception {
		ThreadEx03 th1 = new ThreadEx03();
		th1.start();
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
	} // main() 끝.
} // 클래스 끝.

class ThreadEx03 extends Thread {
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 간 시간을 지연한다.
			} catch (Exception e) {}
		}
	} // run() 끝.
} // 클래스 끝.