package AWT;

import java.awt.*;
import java.awt.event.*;

public class Ex14_CardLayout {
	public static void main(String args[]) {
		Frame f = new Frame("계산기");
		TextField tf = new TextField("0");
		tf.setEditable(false);
		f.setSize(190, 160);
		f.setLocation(300,300);
		
		f.add("North", tf);
		Panel numPanel = new Panel();
		Button[] numButtons = null;
		numPanel.setLayout(new GridLayout(4, 5, 4, 4)); // 4행 5열, button 간의 간격을 4,4로 설정
		numPanel.setBackground(Color.lightGray);
		f.add("Center", numPanel);
		
		String numStr[] = { "7", "8", "9", "/", " CE ",
							"4", "5", "6", "*", "BS",
							"1", "2", "3", "-", "1/x",
							"0", "+/-", ".", "+", "=" };
		numButtons = new Button[numStr.length];
		for(int i=0;i<numStr.length;i++) {
			numButtons[i] = new Button(numStr[i]);
			numButtons[i].setForeground(Color.blue);
			numPanel.add(numButtons[i]);
		}
		
		f.setResizable(false);
		f.setVisible(true);
	}
}
