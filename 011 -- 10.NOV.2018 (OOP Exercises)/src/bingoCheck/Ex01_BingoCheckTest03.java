package bingoCheck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Project "007 -- 06.NOV.2018 (OOP)" >> package "study" >> file "OOP_BingoCheckTest"
// Project "008 -- 08.NOV.2018 (OOP)" >> package "study" >> file "BingoCheckTestUpdate"

class Ex01_BingoCheckTest03 {
	/* 2차원 배열을 받아서 bingo의 개수를 세서 반환
	 * 메서드 이름 : bingoCheck
	 * 매개변수(입력) : 2차원 int 배열
	 * 반환값 : bingo의 개수
	 */

	int bingoCheck(int[][] arr) {
		int[][] bingo = arr; // bingo 배열에 매개변수로 전달한 arr를 대입할 필요가 없다.
							 // 어차피 주소값을 주고 받기에 매개변수의 arr를 그대로 사용해도 문제 없다.
		
		int num = 0;
		
		// 1st --> 행, 열, 대각선 2개를 따로 따로 확인하는 코드 작성
//		// check left-top --> right-bottom bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][i] != 0) { check1++; } 
//		}
//		if (check1 == 5) { num++; }
//		
//		// check left-bottom --> right-top bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][4-i] != 0) { check2++; } 
//		}
//		if (check2 == 5) { num++; }
//		
//		// check rows for bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][0] == 1 && bingo[i][1] == 1 && bingo[i][2] == 1 && bingo[i][3] == 1 && bingo[i][4] == 1) {
//				num++;
//			}
//		}
//		
//		// check columns for bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[0][i] == 1 && bingo[1][i] == 1 && bingo[2][i] == 1 && bingo[3][i] == 1 && bingo[4][i] == 1) {
//				num++;
//			}
//		}
		
		// 2nd --> 별개 코드 작성 후 합치기
		// 방법 01 >>
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][0] == 1 && bingo[i][1] == 1 && bingo[i][2] == 1 && bingo[i][3] == 1 && bingo[i][4] == 1) {
//				num++;
//			}
//			if(bingo[0][i] == 1 && bingo[1][i] == 1 && bingo[2][i] == 1 && bingo[3][i] == 1 && bingo[4][i] == 1) {
//				num++;
//			}
//		}
//		if(bingo[0][0] == 1 && bingo[1][1] == 1 && bingo[2][2] == 1 && bingo[3][3] == 1 && bingo[4][4] == 1) {
//			num++;
//		}
//		if(bingo[0][4] == 1 && bingo[1][3] == 1 && bingo[2][2] == 1 && bingo[3][1] == 1 && bingo[4][0] == 1) {
//			num++;
//		}

		// 방법 02 >>
//		int check1 = 0, check2 = 0;
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				if (bingo[i][j] == 0) { break; }
//				if (j == 4) { num++; }
//			}
//			for(int j = 0; j < 5; j++) {
//				if (bingo[j][i] == 0) { break; }
//				if (j == 4) { num++; }
//			}
//			if(bingo[i][i] == 1) { check1++; }
//			if(bingo[i][4-i] == 1) { check2++; }
//		}
//		if (check1 == 5) { num++; }
//		if (check2 == 5) { num++; }
		
		// 방법 03 >> 방법 02의 개량형
//		for(int i = 0, k = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				if (bingo[i][j] == 0) { break; }
//				if (j == 4) { num++; }
//			}
//			for(int j = 0; j < 5; j++) {
//				if (bingo[j][i] == 0) { break; }
//				if (j == 4) { num++; }
//			}
//			while (i == 0) {
//				if (bingo[k][k] == 0) { break; }
//				if (k == 4) {
//					num++;
//					k = 0;
//					break;
//					}
//				k++;
//			}
//			while (i == 0) {
//				if (bingo[k][4-k] == 0) { break; }
//				if (k == 4) {
//					num++;
//					break;
//					}
//				k++;
//			}
//		}
		
		int row, col, leftD, rightD;
		row = col = leftD = rightD = 0;
		
		// 방법 04		
		for(int i = 0; i < 5; i++, row = 0, col = 0) {
			for(int j = 0; j < 5; j++) {
				if (bingo[i][j] == 1) {
					row++;
					if (row == 5) { num++; } } // 가로빙고 세기 끝.
				if (bingo[j][i] == 1) {
					col++;
					if (col == 5) { num++; } } // 세로빙고 세기 끝.
				if (j == 0 && bingo[i][i] == 1) {
					leftD++;
					if (leftD == 5) { num++; }
				}
				if (j == 0 && bingo[i][4-i] == 1) {
					rightD++;
					if (rightD == 5) { num++; }
				} } } // 방법 04 끝.
		return num;
	}
		
//	// 강사님 코드
//	int bingoCheck(int[][] arr) {
//		int gcnt = 0; // 가로 빙고를 센다
//		int scnt = 0; // 세로 빙고를 센다
//		int dcnt = 0;
//		int rcnt = 0;
//		int bingoCnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr.length; j++) {
//				if(arr[i][j] == 1) { gcnt++; }
//				if(arr[j][i] == 1) { scnt++; }
//				if(arr[i][j] == 1 && i == j) { dcnt++; }
//				if(arr[i][j] == 1 && i+j==4) { rcnt++; }
//			}
//			if(gcnt == 5) { bingoCnt++; }
//			if(scnt == 5) { bingoCnt++; }
//			if(dcnt == 5) {bingoCnt++; }
//			if(rcnt == 5) {bingoCnt++; }
//			gcnt = 0;
//			scnt = 0;
//		}
//
//
//		// 대각선 빙고 갯수를 센다.
//		int dcnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				if(arr[i][j] == 1 && i == j) { dcnt++; }
//			}
//		}
//		if(dcnt == 5) {bingoCnt++; }
//		
//		// 역대각선 빙고 갯수를 센다.
//		int rcnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				if(arr[i][j] == 1 && i+j==4) { rcnt++; }
//			}
//		}
//		if(rcnt == 5) {bingoCnt++; }
//		
//	return bingoCnt;
//	}

	@Test
	void test() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1}
		};
		
		assertTrue(bingoCheck(arr) == 12);
	}
	
	@Test
	void test2() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,1,0,0,0},
				{1,0,1,0,0},
				{1,0,0,1,0},
				{1,0,0,0,1}
		};
		
		assertTrue(bingoCheck(arr) == 3);
	}
	
	@Test
	void test3() {
		int[][] arr = {
				{1,1,1,1,1},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		};
		
		assertTrue(bingoCheck(arr) == 1);
	}
	
	@Test
	void test4() {
		int[][] arr = {
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,1,0,0},
				{1,0,0,1,0},
				{1,0,0,0,1}
		};
		
		assertTrue(bingoCheck(arr) == 1);
	}

}
