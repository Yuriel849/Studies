package AWT;

import java.awt.*;

public class Ex12_FlowLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("FlowLayoutTest");
		f.setSize(500, 250);
		f.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout 왼쪽정렬의 생성
		f.add(new Button("첫 번째"));
		f.add(new Button("두 번째"));
		f.add(new Button("세 번째"));
		f.add(new Button("네 번째"));
		f.add(new Button("다섯 번째"));
		f.add(new Button("여섯 번째"));
		f.add(new Button("일곱 번째"));
		f.add(new Button("여덟 번째"));
		f.add(new Button("아홉 번째"));
		f.add(new Button("열 번째"));
		f.setVisible(true);
	}
}
