package AWT;

// Image를 이용해서 이미지 출력하기
// 내가 직접 그리는 것의 문제점 --> 현재진행형으로 그리고 출력하니까, 계속 깜빡거리면서 repaint()가 진행된다
// 해결책 --> 직접 그리는 입력을 받을 가상 화면을 하나 만들고, 그것을 다시 복사해서 출력용 화면에 옮긴다 --> double buffering 기법
// 코드
// 1. 가상 이미지 생성
// 2. 가상 이미지의 그래픽스 얻어오기
// 3. 그림 그리기
// 4. 복소

import java.awt.*;
import java.awt.event.*;

class Ex19_Graphics03 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;
	Image img = null; // 가상화면를 다루기 위한 참조변수
	Graphics gImg = null; // 가상화면의 그래픽스를 다루기 위한 참조변수
	
	public static void main(String[] args) {
		new Ex19_Graphics03("Ex19_Graphics03");
	}
	
	public Ex19_Graphics03(String title) {
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
		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("왼쪽버튼을 누른 채로 마우스를 움직여보세요." ,10, 50);
		repaint();
	}
	
	public void paint(Graphics g) {
		if(img!=null)
			g.drawImage(img,0,0,this); // Frame 가상화면에 그려진 그림을 에 복사
	}
	
	public void mouseMoved(MouseEvent me) {}
	
	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK ) { // BUTTON1은 마우스 왼쪽 버튼을 의미
			x = me.getX();
			y = me.getY();
			gImg.drawString("*", x, y);
			repaint();
		}
	}
} // class