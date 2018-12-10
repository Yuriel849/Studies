package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GridLayout은 버튼의 크기가 동일하다

class Ex16_BingoTest {
	public static void main(String args[]) {
		Frame f = new Frame("GridLayoutTest");
		f.setSize(250, 250);
		f.setLayout(new GridLayout(5, 5)); // 5행 5열의 테이블을 만들어서 str의 문자열들로 채운다.
		
		// 빙고판을 채울 단어 25개 (각각이 문자열)
		String[] str = { "참새", "두루미", "황새", "비둘기", "까오기",
				"오리", "타조", "부엉이", "올빼미", "뱁새",
				"꿩", "닭", "구관조", "잉꼬", "매",
				"거위", "독수리", "콘돌", "봉황", "공작",
				"까치", "까마귀", "앵무새", "꾀꼬리", "고니" };
	
		// str의 요소들을 섞는다.
		for(int i = 0; i < 25; i++) {
			int ran = (int)(Math.random() * 23 + 1);
			String temp = str[ran];
			str[ran] = str[0];
			str[0] = temp;
		}
		
		for(int i = 0; i < 25; i++) {
			/* 중복된다!!!
			 * 	>> Button은 순차적으로 i를 1씩 증가하면서 입력하는데, 그 와중에 (그와 동시에) str의 요소들이 섞이고 있다
			 */
//			int ran = (int)(Math.random() * 23 + 1);
//			String temp = str[ran];
//			str[ran] = str[0];
//			str[0] = temp;
			Button b = new Button(str[i]); // Button 객채 생성, Button의 label은 str[i]
			b.setBackground(Color.cyan); // b의 배경색깔 설정
			f.add(b); // f에다가 b를 추가
			
			b.addActionListener(new ButtonHandler2 ()); 
			/* ButtonHandler2 클래스의 객체, 일명 "이벤트 객체"를 생성
			 * 	>> 이벤트 객체에는 이벤트에 대한 정보가 담겨져있다.
			 * 	>> 이벤트 객체의 메서드들을 사용하면 그 정보에 접근할 수 있다.
			 */
		}
		f.setVisible(true); // f가 화면에 나타나도록		
	}
	// 빙고판이 새 창에 뜨면, 그 상태에서는 main()은 끝난 것! f.setVisible(true)까지 모두 실행하고 종료한 것!
	// 하지만 빙고판의 각 버튼에 addActionListener에 의해서 이벤트처리 메서드가 연결되어 있다 --> 기다리다가 사용자가 버튼을 누르면 그것과 연결된 메서드를 따라가서 ButtonHandler2의 actionPerformed 메서드를 호출한다!
}

class ButtonHandler2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
		b.setBackground(Color.LIGHT_GRAY);
		System.out.println(b.getLabel());
	}
}