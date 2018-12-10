package study;

import java.io.*;
import java.util.Arrays;

// Ex01_IO01 업그레이드 --> 배열을 이용해서 IO 효율을 향상

class Ex02_IO02 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp, 0, temp.length); // input배열에서 index값 0부터 temp의 길이만큼의 값들을 temp에 쓴다
		output.write(temp, 5, 5); // temp 배열에서 index값 5부터 5개 값만 가져와서 output에 쓴다
				
		outSrc = output.toByteArray(); // 스트림의 내용을 byte 배열로 반환한다.
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	}
} // 클래스 끝.