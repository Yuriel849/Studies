package study;

import java.io.*;
// 15-8 예제

class Ex06_IO06 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(100);
			dos.writeFloat(20f);
			dos.writeBoolean(true);
			// binary data(2진수)로 저장된다 --> 파일을 열어도 사람이 읽을 수 없다!
			//		>> eclipse에서 열었을 때는 int인지 float인지 boolean 값인지 모른다 --> 타입을 모르니까 2진수 원형 그대로 보여준다!
			//					<--> 반면, println은 모든 것을 문자로 취급하여 출력한다.
			// 		>> 16진수용 에디터에서 열면 제대로 읽을 수 있다 (16진수로 표현되겠지만)
			
			dos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main() 끝.
} // 클래스 끝.