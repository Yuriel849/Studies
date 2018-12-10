package study;

import java.io.*;
import java.util.Arrays;

// Ex03_IO03 업그레이드 --> 배열을 이용해서 IO 효율을 향상

class Ex04_IO04 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 이전 예제와 배열의 크기가 다르다.
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0) {
				int len = input.read(temp); // read() 반환값은 몇 개를 읽었는지 int형 숫자다!
				output.write(temp, 0, len); // 정확히 read()로 읽어 온 개수만큼만 write한다.
			}
		} catch(IOException e) {}
		
		outSrc = output.toByteArray(); // 스트림의 내용을 byte 배열로 반환한다.
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	} // main() 끝.
} // 클래스 끝.