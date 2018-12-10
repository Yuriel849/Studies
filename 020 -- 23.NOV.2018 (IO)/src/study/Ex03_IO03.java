package study;

import java.io.*;
import java.util.Arrays;

// Ex01_IO01 업그레이드 --> 배열을 이용해서 IO 효율을 향상

class Ex03_IO03 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 이전 예제와 배열의 크기가 다르다.
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));

		try {
			while(input.available() > 0) {
				input.read(temp); // read() --> input으로부터 읽어온 내용을 배열 temp에 담는다.
					// read(byte[] b, 0, b.length)와 같다 --> input에서 가져와서 b에 들어갈 수 있는만큼 꽉 채운다 (input에서 읽어올 것이 남았다는 전제 하)
					// 기존에 temp 배열에 있는 내용을 덮어쓴다 --> 만약 temp의 모든 칸을 완전히 덮어쓰지 않는다면, 기존 내용도 같이 남는다.
					// read() 반환값은 몇 개를 읽었는지 int형 숫자다!
				output.write(temp); // write() --> 배열 temp에 담긴 모든 내용을 출력한다.
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		} catch(IOException e) {}
	} // main() 끝.
		

	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));

	} // printArrays() 끝.
} // 클래스 끝.