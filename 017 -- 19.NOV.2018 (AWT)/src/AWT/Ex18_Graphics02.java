package AWT;

import java.awt.*;
import java.awt.event.*;

public class Ex18_Graphics02 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;

	public static void main(String[] args) {
		new Ex18_Graphics02("Ex18_Graphics02");
	}
	
	public Ex18_Graphics02(String title) {
		super(title);
		addMouseMotionListener(this);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// Frame (100, 100) width 500, height 500 . 을 의 위치에 크기로 보이게 한다
		setBounds(100,100, 500,500);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawString("마우스를 움직여보세요." ,10, 50);
		g.drawString("*", x, y);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void mouseMoved(MouseEvent me) {
		x = me.getX();
		y = me.getY();
		repaint(); // update()를 호출하는데, update()는 화면을 지운 후 paint()를 호출하기에, 마우스가 움직인 자취가 남지 않는다.
				   // 마우스 움직일 때마다 화면이 깜빡거리는 것은 움직일 때마다 다시 그리기 때문이다.
	}
	
	public void mouseDragged(MouseEvent me) {}
} // class