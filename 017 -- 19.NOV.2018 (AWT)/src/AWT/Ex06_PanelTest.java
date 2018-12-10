package AWT;

import java.awt.*;

public class Ex06_PanelTest {
	public static void main(String args[]) {
		Frame f = new Frame("Panel");
		f.setSize(300, 200);
		f.setLayout(null); // Frame이 Layout Manager를 사용하지 않도록 한다
		
		Panel p = new Panel();
		p.setBackground(Color.green); // Panel의 배경을 녹색으로 한다
		p.setSize(100, 100);
		p.setLocation(50, 50);
		
		Button ok = new Button("OK");
		
		p.add(ok); // Button을 Panel에 포함시킨다
		f.add(p); // Panel을 Frame에 포함시킨다
		f.setVisible(true);
			// Frame 컨테이너 안에 Panel 컨테이너가 있고, Panel 안에 Button 컨테이너가 있다
	} // main() 끝.
} // 클래스 끝.