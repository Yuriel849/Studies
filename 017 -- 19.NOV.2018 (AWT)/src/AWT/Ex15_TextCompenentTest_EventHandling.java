package AWT;

import java.awt.*;
import java.awt.event.*;

class Ex15_TextCompenentTest_EventHandling extends Frame {
	TextField tf;
	TextArea ta;
	
	Ex15_TextCompenentTest_EventHandling(String title) {
		super(title); // Frame(String title)을 호출한다.
		
		tf = new TextField();
		ta = new TextArea();
		add(ta, "Center");
		add(tf, "South");
	
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TextField에서 Enter를 치면, tf에 입력된 text를 TextArea에 추가한다.
				ta.append(tf.getText() + "\n");
				tf.setText(""); // tf의 text를 지운다.
				tf.requestFocus();
			}
		});
		
		ta.setEditable(false); // TextArea의 text를 편집하지 못하게 한다.
		setSize(300, 200);
		setVisible(true);
		tf.requestFocus(); // focus가 TextField에 위치하도록 한다.
	}
	
	public static void main(String args[]) {
		Ex15_TextCompenentTest_EventHandling mainWin = 
				new Ex15_TextCompenentTest_EventHandling("TextComponentEventTest");
	} // main메서드의 끝.
} // 클래스 끝.