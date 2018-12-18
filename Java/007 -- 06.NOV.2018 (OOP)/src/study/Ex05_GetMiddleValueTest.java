package study;

// File -> New -> JUnit Test Case -> (path 추가가 필요하다고 할 경우 add) -> Finish
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Ex05_GetMiddleValueTest {
	/* 3개의 값을 입력 받아서 중간값을 반환하는 메서드 작성
	 * 메서드 이름 : mid
	 * 입력 : 정수값 3개
	 * 출력: 정수값 1개 (중간값)
	 */
	
	int mid(int x, int y, int z) {
		/* x, y, z 중에서 중간 크기의 값을 반환한다.
		 * 	ex) 1, 1, 2의 경우 1이 반환되어야 한다.
		 * 		1, 2, 2의 경우 2가 반환되어야 한다.
		 */
		int mid = x;
		
//		// 방법 01 >>
//		{
//		if(x < y) {
//			if(y < z) { mid = y; }
//			else {
//				if(x < z) { mid = z; }
//				else { mid = x;	}
//			}
//		} else { // x > y
//			if(x < z) { mid = x; }
//			else {
//				if(y < z) { mid = z; }
//				else { mid = y; }
//			}
//		}
//		}
//		
//		// 방법 02 >>
//		{
//		int[] str = new int[3];
//		str[0] = x;
//		str[1] = y;
//		str[2] = z;
//		int temp;
//		
//		for(int i = 0; i < str.length-1; i++) {
//			for(int k = 0; k < str.length-1-i; k++) {
//				if(str[k] < str[k+1]) {
//					temp = str[k];
//					str[k] = str[k+1];
//					str[k+1] = temp;
//				}
//			}
//		}
//		mid = str[1];
//		}
//		
//		// 방법 03 >>
//		{
//		mid = (x < y) ? (y < z) ? y : (x < z) ? z : x : (x < z) ? x : (y < z) ? z : y;
//			/* 삼항연산자 중복하여 만들어서 제대로 실행은 되는데... 가독성 쓰레기다ㅎㅎ
//			 * 	>> 괄호 넣어서 가독성 향상
//			 * 	>> mid = (x < y) ? ((y < z) ? y : ((x < z) ? z : x)) : ((x < z) ? x : ((y < z) ? z : y));
//			 */
//		}

		// 여러가지 방법 -> 1. 비교, 2. 정렬, 3. 비교연산자, etc.
		
		// 방법 04 >> 강사님 답 >> 가장 간단한 답
		{
		if((x < y && y < z) || (z < y && y < x)) return y;
		if((y < x && x < z) || (z < x && x < y)) return x;
		return z;
		}
		// 완벽하지 않다... mid(3,3,2) == 3 --> 실패
		
		//return mid;
	}
	
	// 원래 text할 때 여기서 이렇게 진행한다 --> @Test 반드시 필요! 각 메서드의 이름은 다르게!
	@Test
	void test() {
		assertTrue(mid(1,2,3) == 2);
	}
	
	@Test
	void test2() {
		assertTrue(mid(2,1,3) == 2);
	}
	
	@Test
	void test3() {
		assertTrue(mid(3,1,2) == 2);
	}
	
	@Test
	void test4() {
		assertTrue(mid(1,2,2) == 2);
	}
	
	@Test
	void test5() {
		assertTrue(mid(1,1,1) == 1);
	}
	
	@Test
	void test6() {
		assertTrue(mid(3,2,1) == 2);
	}
	
	@Test
	void test7() {
		assertTrue(mid(3,1,2) == 2);
	}
	
	@Test
	void test8() {
		assertTrue(mid(3,3,2) == 3);
	}

	@Test
	void test9() {
		assertTrue(mid(3,3,3) == 3);
	}
}
