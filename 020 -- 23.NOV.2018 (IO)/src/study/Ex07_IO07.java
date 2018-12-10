package study;

import java.io.*;

// 15-11 예제

class Ex07_IO07 {
	public static void main(String[] args) {
		int[] score = { 100, 90, 95, 85, 50 };
		
		try {
			FileOutputStream fos = new FileOutputStream("score.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			for(int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]);
			}
			
			dos.close();
		} catch(IOException e) {
			e.printStackTrace();
		} // try-catch문 끝.
	} // main() 끝.
} // 클래스 끝.