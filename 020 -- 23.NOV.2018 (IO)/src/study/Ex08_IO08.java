package study;

import java.io.*;

// 15-12 예제

class Ex08_IO08 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			} // 무한반복인데, 파일을 다 읽으면 EOF 예외가 발생하면서 while문을 벗어난다.
		} catch(EOFException e) {
			System.out.println("점수의 총합은 " + sum + "입니다.");
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			try { // 예외가 발생하던 안하던 마지막에 dis를 close한다. --> 매번 close하기가 귀찮으니까 try-with-resources 사용 (큰 의미는 없다)
				if(dis != null) { dis.close(); }
			} catch(IOException ie) { // close()가 원래 IOException 예외를 발생시킬 수 있다.
				ie.printStackTrace();
			}
		} // try-catch문 끝.
	} // main() 끝.
} // 클래스 끝.