package AWT;

import java.awt.*;
import java.awt.event.*;

// 오목게임이다.
// Frame에 오목판을 그리고 그 위에 왼쪽 버튼을 누르면 검은 돌이, 오른쪽 버튼을 누르면 흰 돌이 그려지도록 알맞은 코드를 완성하시오.
// 단 돌은 클릭한 곳의 가장 가까운 교차점에 놓여야 한다.

class Ex21_OmokTest extends Frame implements MouseListener {
	public static void main(String[] args) {
		new Ex21_OmokTest("OmokTest");
	} // main() 끝.

	final int LINE_NUM = 9; // 오목판 줄 수
	final int LINE_WIDTH = 30; // 오목판 줄 간격
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM-1); // 오목판의 크기
	final int STONE_SIZE = (int)(LINE_WIDTH * 0.8); // 돌의 크기

	final int X0; // x 오목판 시작위치 좌표
	final int Y0; // y 오목판 시작위치 좌표
	
	final int FRAME_WIDTH; // Frame의 폭
	final int FRAME_HEIGHT; // Frame의 높이
	
	Image img = null;
	Graphics gImg = null;
	
	// 생성자!!
	public Ex21_OmokTest(String title) {
		super(title);
		
		// Event Handler를 등록한다.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setVisible(true); // Frame을 화면에 보이게 한다.
		Insets insets = getInsets(); // setVisible을 이용하여 화면에 보이기 전에는 Insets의 값을 얻을 수 없다.

		// 오목판 그려질 위치(LEFT, TOP)의 좌표 X0, Y0를 지정한다.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top + LINE_WIDTH;
		
		// Frame의 크기를 계산한다.
		FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH*2+insets.left+insets.right;
		FRAME_HEIGHT = BOARD_SIZE+LINE_WIDTH*2+insets.top+insets.bottom;

		// Frame을 화면의 (100,100)의 위치에 계산된 크기로 보이게 한다.
		setBounds(100,100, FRAME_WIDTH, FRAME_HEIGHT);
	
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
	
		setResizable(false); // Frame의 크기를 변경하지 못하게 한다
							 // true로 설정할 경우, Frame의 크기를 변경할 수 있으나 오목판의 크기는 늘어나지 않는다.
		drawBoard(gImg);
	} // 생성자 Ex21_OmokTest(String title) 끝.
	
	public void drawBoard(Graphics g) {
		for(int i=0; i<LINE_NUM;i++) {
			g.drawLine(X0,Y0+i*LINE_WIDTH,X0+BOARD_SIZE, Y0+i*LINE_WIDTH);
			g.drawLine(X0+i*LINE_WIDTH,Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE);
		}
	} // drawBoard() 끝.
	
	public void paint(Graphics g) {
		if(img==null) return;
		g.drawImage(img,0,0,this); // 가상화면에 그려진 그림을 Frame에 복사
	} // paint() 끝.
	
	public void mousePressed(MouseEvent e) { // MouseListener
		int x = e.getX(); // 마우스 포인터의 x좌표
		int y = e.getY(); // 마우스 포인터의 y좌표
		
		// 1. x와 y의 값이 오목판의 밖을 벗어난 곳이면 돌을 그리지 않는다.
		if((x <= (X0-LINE_WIDTH/2) || X0+BOARD_SIZE+LINE_WIDTH/2 <= x) || (y <= (Y0-LINE_WIDTH/2) || Y0+BOARD_SIZE+LINE_WIDTH/2 <= y))
			{ return; }
		
		// 2. x와 y의 값을 클릭한 곳에서 가장 가까운 교차점으로 변경한다. (반올림)
		x = (x-X0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + X0;
		/* (해설)
		 * 	>> 마우스 클릭으로 지정한 x의 값에서 X0(원점)을 빼고, 거기다가 LINE_WIDTH의 절반을 더한다.
		 * 	>> 만약 반올림이 될 값이라면 (LINE_WIDTH의 절반 이상이기에 더 큰 교차점에 더 가깝다면) 반올림이 됐을 것이다.
		 * 		>> 반올림이 안 됐다면 애초에 더 작은 교차점에 가까운 값이다.
		 * 	>> int인 LINE_WIDTH으로 나누기해서 소수점 이하를 버린다.
		 * 	>> 다시 LINE_WIDTH 곱하고 X0 더해서 교차점으로 이동한 원래 x 값을 구한다.
		 */
		y = (y-Y0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + Y0;
		
		// 3. x와 y의 값에서 돌의 크기 (STONE_SIZE)의 절반을 빼야 클릭한 곳에 돌이 그려진다.
		// 	>> drawOval(), fillOval()로 그릴 떄, x,y는 어느 지점에서부터 그리는지를 표시한다 --> 두 선의 교차점을 원점으로 그려지려면 x,y를 왼쪽 위로 이동시켜야 한다. 
		x -= STONE_SIZE/2;
		y -= STONE_SIZE/2;
		
		/* 4. 눌러진 버튼이 마우스 왼쪽 버튼이면 (x,y)의 위치에 검은 돌을 그리고, --> 마우스 왼쪽 버튼이 BUTTON1
			    눌러진 버튼이 마우스 오른쪽 버튼이면 (x,y)의 위치에 흰 돌을 그린다. --> 마우스 오른쪽 버튼이 BUTTON3
			 (흰 돌을 그릴 때 검은 색 테두리도 같이 그린다.) */
		gImg = img.getGraphics();
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK ) {
			gImg.setColor(Color.black);
			gImg.fillOval(x,y, STONE_SIZE,STONE_SIZE); // fillOval은 채운다.
		} else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK ) {
			gImg.setColor(Color.white);
			gImg.fillOval(x,y, STONE_SIZE, STONE_SIZE);
			gImg.setColor(Color.black);
			gImg.drawOval(x,y, STONE_SIZE,STONE_SIZE); // drawOval은 테두리만 그린다.
		}
		
		// 5. repaint()를 호출한다.
		repaint();

	} // mousePressed() 끝.

	// MouseListener 인터페이스의 다른 메서드들, 사용하지 않으니까 빈 메서드로 구현
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
} // 클래스 끝.