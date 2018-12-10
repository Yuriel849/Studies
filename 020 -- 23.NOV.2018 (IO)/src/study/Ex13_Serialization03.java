package study;

import study.Ex11_Serialization01;
import java.io.*;
import java.util.ArrayList;

class Ex13_Serialization03 {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName); 	// 이것 하나가 기반 스트림!
			BufferedInputStream bis = new BufferedInputStream(fis); // 	>> 보조스트림 01
			ObjectInputStream in = new ObjectInputStream(bis); 		// 	>> 보조스트림 02
			
			// 객체를 읽을 때는 출력한 순서와 일치해야한다.
			Ex11_Serialization01 u1 = (Ex11_Serialization01) in.readObject();
			Ex11_Serialization01 u2 = (Ex11_Serialization01) in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			
			/* 출력할 때, u1 & u2를 list에 add()한 후에 list의 데이터를 출력했다.
			 * 	>> 즉, UserInfo.ser에 있는 3번째 데이터는 ArrayList에서 쓸 수 있는 단 하나의 데이터이다.
			 * 		>> 이 위치에 ArrayList가 아닌 것이 오면 에러난다 --> 3번째 데이터는 ArrayList로만 형변환 가능한 데이터라는 의미다.
			 * 	>> (recommendation!) 아예 개별적인 객체(i.e. u1 & u2)를 쓰지 않고 처음부터 모든 객체를 ArrayList같은 컬렉션에 담아서 직렬화하는 것이 좋다.
			 * 		>> 객체의 순서를 신경 쓸 필요 없이 컬렉션 하나만 직렬화 & 역직렬화하면 되기 때문이다.
			 */
	
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main() 끝.
} // 클래스 끝.
