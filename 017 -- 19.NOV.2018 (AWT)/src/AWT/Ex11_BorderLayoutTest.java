package AWT;

import java.awt.*;

// Layout Manager에 의해 창의 크기를 수정할 때 자동으로 크기 조절을 해준다.

// BorderLayout은 Layout Manager의 5개 종류 중 하나

public class Ex11_BorderLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("BorderLayoutTest");
		f.setSize(400, 400);
		//Frame은 기본적으로 BorderLayout로 설정되어 있으므로 따로 설정하지 않아도 됨
		f.setLayout(new BorderLayout());
		Button north = new Button("North");
		Button south = new Button("South");
		Button east = new Button("East");
		Button west = new Button("West");
		Button center = new Button("Center");
		
		// Frame의 5개의 각 영역에 Button을 하나씩 추가한다
//		f.add(north, "North"); // f.add("North",north);와 같이 쓸 수도 있다
		f.add(south, "South"); // South의 대소문자 정확히
		f.add(east, "East"); // East 대신, BorderLayout.EAST 사용가능
//		f.add(west, "West");
		f.add(center, "Center");
		// 특정 영역에 버튼 필요없다면, 그 부분에 add()하지 않으면 그 영역을 빼고 화면을 채운다.
		
		f.setVisible(true);
	} // main() 끝.
} // 클래스 끝.