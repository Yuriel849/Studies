package study;

import java.util.Scanner;

public class Ex17_Switch03 {
	public static void main(String args[]) {
		// 월(month)을 입력해서 해당 월에 몇 일까지 있는지 알아보자
				Scanner scan = new Scanner(System.in);
				
				// 월을 저장하는 변수
				int month;
				
				// 날짜를 저장하는 변수
				int date;
				
				System.out.print("1 ~ 12 월 중 하나를 입력하세요 : " + "\n");
				month = scan.nextInt();
				
				switch (month) {
				// 전체 highlight하고 tab 누르면 모두 들여쓰기 함 
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:
						date = 31; break;
					case 4: case 6: case 9: case 11:
						date = 30; break;
					case 2:
						date = 28; break;
					default:
						date = -1;
				}
				
				if(date != -1) {
					System.out.printf("%d월은 %d일까지 있습니다", month, date);
				}else {
					System.out.printf("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}
}