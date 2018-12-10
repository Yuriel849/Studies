package study;

import java.io.*;
import java.util.Arrays;

class Ex01_IO01 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while((data = input.read()) != -1) { // input.read의 결과가 -1이라는 의미는, 더 이상 읽어올 것이 없다는 의미
			output.write(data); // void write(int b) 메서드를 사용한다.
		}
		
		outSrc = output.toByteArray(); // 스트림의 내용을 byte 배열로 반환한다.
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	}
} // 클래스 끝.