package AWT;

import java.awt.*;
import java.awt.event.*;

class Ex04_FrameTest_EventHandling {
	public static void main(String args[]) {
		Frame f = new Frame("Login"); // Frame 객체를 생성한다
		f.setSize(300, 200); // Frame의 크기를 설정한다
		Button b = new Button("OK");
		
		// 2. 버튼에 이벤트 처리기를 등록(연결)한다
		b.addActionListener(new ButtonHandler());
		f.add(b);
		b.addMouseMotionListener(new MouseHandler()); // 마우스 움직임 이벤트처리를 b에서 해야 한다. b가 f를 완전히 덮기 때문에, 마우스 움직임 이벤트를 f가 받지 못하고 b가 받기 때문이다.
		
		// EventHandler 클래스의 객체를 생성해서 Frame의 WindowListener로 등록한다
		f.addWindowListener(new EventHandler());
		f.setVisible(true); // Frame . 생성한 을 화면에 보이도록 한다
	}
}

// OOP의 Adapter 패턴이기에 Window"Adapter"라고 부른다.
// Adapter 클래스는 추상클래스로 인터페이스의 추상메서드를 모두 빈 (내용 없는) 메서드로 구현해놨다. (아마...?)
	// 추상클래스로 만든 이유는 객체 생성 못하게 하기 위해서 --> Adapter클래스를 객체 생성해봐야 내용이 없어서 의미가 없다 --> 아예 객체 생성 못하게 막는 것
// 사용자는 인터페이스를 직접 구현할 필요 없이 adapter를 상속받아서 원하는 메서드만 오버라이딩 하면 된다.
// Adapter 클래스를 사용하는데 문제점은 Adapter 클래스를 상속받기에 다른 것을 상속 받을 수 없다.
class EventHandler extends WindowAdapter {
	// 인터페이스 WindowListener는 모든 추상메서드를  괄호라도 붙여서 모두 구현해야 한다.
	// 클래스 WindowAdapter는 WindowListener의 추상메서드를 빈 (내용이 없는) 메서드로 구현해놓았고, 그래서 사용자는 사용하기 싶은 메서드만 오버라이딩하면 된다.
	public void windowClosing(WindowEvent e) { // Frame의 닫기 버튼을 눌렀을 때 자동으로 호출된다
		e.getWindow().setVisible(false); // Frame을 화면에서 보이지 않도록 하고,
		e.getWindow().dispose(); // 메모리에서 제거한다
		System.exit(0); // 프로그램을 종료한다
	}
}

//class EventHandler implements WindowListener {
//	public void windowOpened(WindowEvent e) {}
//	public void windowClosing(WindowEvent e) { // Frame의 닫기 버튼을 눌렀을 때 자동으로 호출된다
//		e.getWindow().setVisible(false); // Frame을 화면에서 보이지 않도록 하고,
//		e.getWindow().dispose(); // 메모리에서 제거한다
//		System.exit(0); // 프로그램을 종료한다
//	}
//	
//	// 아래 메서드들은 WindowListener 인터페이스에 있는 것들 --> 창을 닫는데는 필요하지 않다.
//	public void windowClosed(WindowEvent e) {} // 아무내용도 없는 메서드 구현 --> 인터페이스의 추상메서드이기 때문에
//	public void windowIconified(WindowEvent e) {}
//	public void windowDeiconified(WindowEvent e) {}
//	public void windowActivated(WindowEvent e) {}
//	public void windowDeactivated(WindowEvent e) {}
//}

// 1. 이벤트 처리기를 작성 (원하는 메서드를 가진 인터페이스 구현)
class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK 버튼이 눌러졌어요.");
	}
}

class MouseHandler implements MouseMotionListener {
	public void mouseDragged(MouseEvent me) {}
	
	public void mouseMoved(MouseEvent me) {
		System.out.println("x = " + me.getX() + ", y = " + me.getY());
	}

}