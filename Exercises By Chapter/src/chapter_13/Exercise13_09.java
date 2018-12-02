package chapter_13;

import javax.swing.JOptionPane;

class Exercise13_09 {
	public static void main(String[] args) throws Exception {
		Exercise13_09_1 th1 = new Exercise13_09_1();
		th1.start();
	
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
	
		System.out.println("입력하신 값은 " + input + "입니다.");
	
		th1.interrupt(); // 쓰레드에게 작업을 멈추라고 요청한다.
	} // main() 끝.
} // 클래스 끝.

class Exercise13_09_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000); // 1초 지연
			} catch(InterruptedException e) {
				interrupt();
				/* 혹시 자고 있는 상태에서 interrupt되면 다시 깨어나고 interrupted 상태는 다시 false로 초기화된다.
				 * 	>> 하지만 main 쓰레드에서 interrupt하면 그것은 종료하기 위해서일 것
				 * 		>> 다시 자신을 interrupt해서 멈춘다
				 */
			}
		}
		
		System.out.println("카운트가 종료되었습니다.");
	} // run() 끝.
} // 클래스 끝.