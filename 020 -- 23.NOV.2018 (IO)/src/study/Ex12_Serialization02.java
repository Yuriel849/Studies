package study;

import study.Ex11_Serialization01;
import java.io.*;
import java.util.ArrayList;

class Ex12_Serialization02 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			Ex11_Serialization01 u1 = new Ex11_Serialization01("JavaMan", "1234", 30); // u1의 타입은 반드시 "java.io.Serializable"을 구현한 클래스이어야 한다.
			Ex11_Serialization01 u2 = new Ex11_Serialization01("C++ Man", "4321", 26);
			
			ArrayList<Ex11_Serialization01> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			
			// 객체를 직렬화한다.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화가 성공적으로 끝났습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main() 끝.
} // 클래스 끝.
