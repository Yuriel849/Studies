package study;


public class Ex18_For {
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i*=2) {
			System.out.println(i);
		}
		System.out.println();
		
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);
		}
		System.out.println();
		
		/* 원하는 결과물
		 * 1	10 	  1	   1
		 * 2	 9	  1	   2
		 * 3	 8	  1	   3
		 * 4	 7	  2	   1
		 * 5	 6	  2	   2
		 * 6	 5	  2	   3
		 * 7	 4	  3	   1
		 * 8	 3 	  3	   2
		 * 9	 2	  3	   3
		 * 10	 1	  4	   1
		 */
		for(int i = 1, k = 0, j = 1; i <= 10; i++, k++) {
			System.out.printf("%d\t%d\t%d\t%d\n", i, 11-i, j+(i-1)/3, i-3*(k/3));
			/* alternative code for 3rd column
			 * 	>> (i%3==0) ? j++ : j
			 */
			
			/* alternative codes for 4th column
			 * 	>> (i%3==0) ? 3 : i%3
			 * 	>> (i%3==0) ? (i-3*k++) : (i-3*k)
			 * 	>> (outside the for statement)
			 * 			if(i != 1 && i % 3 == 1) {
			 * 				k++; }
			 * 	   (within the printf())
			 * 			(i-3*k)
			 */
		}
		System.out.println();
		
		// Multiplication table
		for(int i = 2; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%-2dX%2d = %-4d", j, i, j*i);
			}
			System.out.println();
		}
	}
	

}
