package study;

import java.util.Arrays;

// 임의의 값으로 배열 채우기 --> 연속 또는 불연속적인 값들로 배열을 초기화 한다.
public class Ex_Array05 {
	public static void main(String[] args) {
		int[] code = {-4, -1, 3, 6, 11};
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			int tmp = (int)(Math.random() * code.length);
			arr[i] = code[tmp];
		}
		
		System.out.println(Arrays.toString(arr));
	}

}