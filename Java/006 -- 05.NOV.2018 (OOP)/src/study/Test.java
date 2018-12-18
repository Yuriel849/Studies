package study;

public class Test {
	public static void main(String[] args) {
		int[][] array11 = new int[][] {{},{},{}};
		
		int[] array = new int[] {};
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		
		// eclipse는 저장하는 순간 컴파일...빨간 줄이 그어지면 컴파일 에러 (문법 에러)
		// 여기서는 컴파일 에러는 없지만 실제로 파일을 실행하여 출력하려하면 런타임 에러 발생
		
		System.out.println(array[0]);
		/*
		for(int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
			
		}
        */

	}

}
