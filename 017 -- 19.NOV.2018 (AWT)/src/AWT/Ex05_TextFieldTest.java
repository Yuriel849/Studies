package AWT;

import java.awt.*;

class Ex05_TextFieldTest {
	public static void main(String args[]) {
		Frame f = new Frame("Login");
		f.setSize(400, 100);
		f.setLayout(new FlowLayout()); // LayoutManager를 FlowLayout으로 한다
		
		// 실행 시 나타나는 창에서 "ID: " & "Password: "가 바로 레이블
		Label lid = new Label("ID :", Label.RIGHT); // 정렬을 오른쪽으로
		Label lpwd = new Label("Password :", Label.RIGHT);
		
		// 실행 시 나타나는 창에서 사용자가 입력할 수 있는 박스가 textfield
		TextField id = new TextField(10);//약 10개의 글자를 입력할 수 있는 TextField 생성
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*'); // 입력한 값 대신 '*'가 보이도록 한다
		
		f.add(lid); // 생성한 컴포넌트들을 Frame에 포함시킨다
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
	} // main() 끝.
} // 클래스 끝.
