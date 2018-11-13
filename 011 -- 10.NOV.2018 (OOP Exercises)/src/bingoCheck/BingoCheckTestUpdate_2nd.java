package bingoCheck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BingoCheckTestUpdate_2nd {
	/* 2���� �迭�� �޾Ƽ� bingo�� ������ ���� ��ȯ
	 * �޼��� �̸� : bingoCheck
	 * �Ű�����(�Է�) : 2���� int �迭
	 * ��ȯ�� : bingo�� ����
	 */

	int bingoCheck(int[][] arr) {
		int[][] bingo = arr; // bingo �迭�� �Ű������� ������ arr�� ������ �ʿ䰡 ����.
							 // ������ �ּҰ��� �ְ� �ޱ⿡ �Ű������� arr�� �״�� ����ص� ���� ����.
		
		int num = 0;
		
		// 1st --> ��, ��, �밢�� 2���� ���� ���� Ȯ���ϴ� �ڵ� �ۼ�
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
		
		// 2nd --> ���� �ڵ� �ۼ� �� ��ġ��
		// ��� 01 >>
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

		// ��� 02 >>
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
		
		// ��� 03 >> ��� 02�� ������
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
		
		// ��� 04		
		for(int i = 0; i < 5; i++, row = 0, col = 0) {
			for(int j = 0; j < 5; j++) {
				if (bingo[i][j] == 1) {
					row++;
					if (row == 5) { num++; } } // ���κ��� ���� ��.
				if (bingo[j][i] == 1) {
					col++;
					if (col == 5) { num++; } } // ���κ��� ���� ��.
				if (j == 0 && bingo[i][i] == 1) {
					leftD++;
					if (leftD == 5) { num++; }
				}
				if (j == 0 && bingo[i][4-i] == 1) {
					rightD++;
					if (rightD == 5) { num++; }
				} } } // ��� 04 ��.
		return num;
	}
		
//	// ����� �ڵ�
//	int bingoCheck(int[][] arr) {
//		int gcnt = 0; // ���� ������ ����
//		int scnt = 0; // ���� ������ ����
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
//		// �밢�� ���� ������ ����.
//		int dcnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				if(arr[i][j] == 1 && i == j) { dcnt++; }
//			}
//		}
//		if(dcnt == 5) {bingoCnt++; }
//		
//		// ���밢�� ���� ������ ����.
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