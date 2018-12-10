package study;

import java.io.*;

// 15-26 예제

class Ex09_IO09 {
	public static void main(String[] args) {
//					   	번호, 국어, 영어, 수학
		int[] score = {  1, 100,  90,  90,
						 2,  70,  90, 100,
						 3, 100, 100, 100,
						 4,  70,  60,  80,
						 5,  70,  90, 100
		};
		
		try {
			@SuppressWarnings("resource")
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
			for(int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]);
			} // 파일포인터가 끝으로 이동한 상태다 (당연히 파일에 출력하면서 파일포인터는 맨 뒤에 위치한다)
			
			raf.seek(0); // 파일포인터를 맨 처음으로 이동시킨다 --> 없으면 파일포인터가 이미 끝에 있느니까 곧바로 EOF 나온다!
			while(true) {
				System.out.println(raf.readInt());
			}
		} catch(EOFException eof) {
			// readInt()를 호출 했을 때 더 이상 읽을 내용이 없으면 EOFException 발생!
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} // try-catch문 끝.
	} // main() 끝.
} // 클래스 끝.