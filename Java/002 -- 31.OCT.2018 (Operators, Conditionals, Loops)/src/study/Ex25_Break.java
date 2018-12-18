package study;

public class Ex25_Break {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		while(true) {
			if(sum > 100) {
				break;				
			}
			i++;
			sum += i;
		}
		System.out.println("1번 :");
		System.out.println("i= " + i);
		System.out.println("sum= " + sum + "\n");
		
		/* 출력물
		 * 	>> 1
		 * 	>> 1 2
		 * 	>> 1 2 3
		 * 	>> 1 2 3 4
		 * 	>> 1 2 3 4 5
		 */
		System.out.println("2번 :");
		i = 1;
		while(true) {
			for(int k = 1; k <= i; k++) {
				System.out.printf("%2d", k);
			}
			System.out.println();
			i++;
			if(i > 5) {
				break;
			}
		}

		/* 출력물
		 * 	>> 1
		 * 	>> 2 2
		 * 	>> 3 3 3
		 * 	>> 4 4 4 4
		 * 	>> 5 5 5 5 5
		 */
		System.out.println();
		System.out.println("3번 :");
		i = 1;
		while(true) {
			for(int j = 1; j <= i; j++) {
				System.out.printf("%2d", i);
			}
			System.out.println();
			i++;
			if(i > 5) {
				break;
			}
		}
		
		/* 출력물
		 * 	>>  1
		 * 	>>  2  3
		 * 	>>  4  5  6
		 * 	>>  7  8  9 10
		 * 	>> 11 12 13 14 15
		 */
		System.out.println();
		System.out.println("4번 :");
		i = 1;
		int m = 1;
		while(true) {
			for(int j = 1; j <= i; j++) {
				System.out.printf("%3d", m++);
			}
			System.out.println();
			i++;
			if(i > 5) {
				break;
			}
		}
		
		/* 출력물
		 * 	>> A
		 * 	>> A B
		 * 	>> A B C
		 * 	>> A B C D
		 * 	>> A B C D E
		 */
		System.out.println();
		System.out.println("5번 :");
		char ch = 65;
		while(true) {
			for(char ch2 = 'A'; ch2 <= ch; ch2++) {
				System.out.printf("%2c", ch2);
			}
			System.out.println();
			ch++;
			if(ch > 69) {
				break;
			}
		}
		
		/* 출력물
		 * 	>> 		   5
		 * 	>>		 4 5
		 * 	>>     3 4 5
		 * 	>>   2 3 4 5
		 * 	>> 1 2 3 4 5
		 */
		System.out.println();
		System.out.println("6번 :");
		int b = 5;
		while(true) {
			for(int a = 1; a <= 5; a++) {
				if (a < b) {
					System.out.printf("  ");
				} else {
					System.out.printf("%2d", a);
				}
			}
			System.out.println();
			b--;
			if(b == 0) {
				break;
			}
		}
		
		/* 출력물
		 * 	>> 		   Z
		 * 	>>		 Y Z
		 * 	>>     X Y Z
		 * 	>>   W X Y Z
		 * 	>> V W X Y Z
		 */
		System.out.println();
		System.out.println("7번 :");
		char ch3 = 'Z';
		while(true) {
			for(char ch4 = 'V'; ch4 <= 'Z'; ch4++) {
				if (ch4 < ch3) {
					System.out.printf("  ");
				} else {
					System.out.printf("%2c", ch4);
				}
			}
			System.out.println();
			ch3--;
			if(ch3 < 'V') {
				break;
			}
		}	
	}
}