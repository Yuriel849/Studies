package AWT;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

class Ex17_Graphics01 extends Frame {
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Ex17_Graphics01("Ex17_Graphics");
		f.setVisible(true);
		// Frame의 Graphics를 얻어온다.
		Graphics fg = f.getGraphics();
		// Frame에 Hello라고 쓴다.
		// Frame에 시간을 찍는다.
		for(int i = 1; i < 1000; i++) {
			fg.drawString("Hello", 200, 80);
			fg.drawString(new Date().toString(), 200, 200);
			Thread.sleep(1000);
			f.repaint();
		}
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics를 이용해서 그림을 그립니다." ,10, 50);
		
		g.drawOval(50,100, 50,50); // 첫번째 원 그리기
		g.setColor(Color.blue);
		g.fillOval(100,100, 50,50); // 두번째 원 그리기
		
		g.setColor(Color.red);
		g.drawLine(100,100, 150,150); // 대각선 그리기
		
		g.fillRoundRect(200, 100, 120, 80, 30, 30); // 직사각형 그리기
		g.setColor(Color.orange);
		g.fillPolygon(new int[]{ 50, 100, 150, 200}, // 도형 그리기
					new int[]{250, 200, 200, 250}, 4);
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120); // 부채꼴 그리기
	}
	
	public Ex17_Graphics01(String title) {
		super(title);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// Frame을 (100,100)의 위치에 width 400, height 300 크기로 보이게 한다.
		setBounds(100,100, 400,300);
		setVisible(true);
	}
} // class
