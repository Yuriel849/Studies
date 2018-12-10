package AWT;

import java.awt.*;

class Ex01_FrameTest {
	public static void main(String args[]) {
		Frame f = new Frame("Login"); // Frame 객체를 생성한다
		f.setSize(300, 200); // Frame의 크기를 설정한다
		f.setVisible(true); // 생성한 Frame을 화면에 보이도록 한다
		/* 켜지면 창을 닫지 못한다! 
		 * 	>> "닫기" 버튼 눌렀을 때 어떻게 해야할지를 이벤트처리하지 않았기 때문이다.
		 * 	>> eclipse의 console창에서 stop해야 한다.
		 */
	} // main() 끝.
} // 클래스 끝.
