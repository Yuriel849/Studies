package study;

import java.util.Scanner;

public class OOP_BaseballGame {
	public static void main(String[] args) {
		/* 1. 1 ~ 9 사이의 숫자로 이루어진 3자리 정수(중복 X)를 임의로 생성
		 * 		>> use Math.random() to get digits b/w 0 ~ 9
		 * 		>> put digits into 3-element array
		 * 		>> if digits are the same as previous, get new digit
		 * 2. 반복적으로 3자리 정수를 입력받는다.
		 * 		>> Scanner & while loop
		 * 		>> take user input and put into 3-element array
		 * 3. 입력받은 숫자와 (1)의 숫자를 비교해서 결과를 출력 (ex) 1S2B)
		 * 4. 비교결과가 3S0B 될 때까지 (2)~(3) 반복 실행
 		 * 		>> incl. if and break to escape loop when 3S0B
		 * 5. 몇 번 만에 맞췄는지 입력횟수 출력 
		 * 		>> keep count of how many loops
		 */
		
		
		int[] std = new int[3];
		int[] entry = new int[3];
		int cnt = 0;
		
		// 방법 01 --> 임의의 3자리 정수 생성
		for(int i = 0; i < std.length; i++) {
			do {
				std[i] = (int)((Math.random() * 9) + 1);
			} while((i == 0) ? false : ((i == 1) ? (std[i] == std[0]) : (std[i] == std[0] || std[i] == std[1])));
		}

		// 방법 02 --> 임의의 3자리 정수 생성
//		int[] ran = new int[9];
//		int temp, j;
//		for(j = 1; j < 10; j++) {
//			ran[j-1] = j;
//		}
//		for(int k = 0; k < 100; k++) {
//			j = (int)(Math.random() * 9);
//			temp = ran[0];
//			ran[0] = ran[j];
//			ran[j] = temp;
//		}
//		for(j = 0; j < 3; j++) {
//			std[j] = ran[j];
//		}
	
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("3자리 정수를 입력해주세요 : ");
			int input = scan.nextInt();
			for(int k = 0; k < entry.length; k++) {
				entry[2-k] = input%10;
				input /= 10;
			}
			
			// ball --> 같은 숫자가 있는데, 위치가 다를 때
			int b = 0;
			// strike --> 같은 숫자가 있는데, 위치가 같을 때
			int s = 0;
			
			for(int i = 0; i < std.length; i++) {
				for(int k = 0; k < entry.length; k++) {
					if (std[i] == entry[k]) { // 두 값이 같을 때, ball or strike
						if (i != k) { // 값은 같은데 위치가 다를 때
							b++;
						} else { // 값은 같은데 위치가 같을 때
							s++;
						}
					}
				}
			}
			System.out.printf("%dS%dB\n", s, b);
			cnt++;
			if(s == 3) {
				System.out.printf("%d번만에 맞추셨습니다!!", cnt);
				break;
			}
		}
		scan.close();
	}
}

