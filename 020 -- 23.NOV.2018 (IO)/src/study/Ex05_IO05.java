package study;

import java.io.*;
import java.util.Arrays;

class Ex05_IO05 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			// BufferedOutputStream의 버퍼 크기를 5로 한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			// 파일 123.txt에 1부터 9까지 출력한다.
			for(int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			bos.close(); // 보조스트림을 닫아야 한다! --> flush()를 먼저 호출하여 버퍼에 남은 내용을 출력한 후 기반스트림의 close()를 호출한다.
//			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main() 끝.
} // 클래스 끝.