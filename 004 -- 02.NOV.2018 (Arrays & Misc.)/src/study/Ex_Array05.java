package study;

import java.util.Arrays;

// ������ ������ �迭 ä��� --> ���� �Ǵ� �ҿ������� ����� �迭�� �ʱ�ȭ �Ѵ�.
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