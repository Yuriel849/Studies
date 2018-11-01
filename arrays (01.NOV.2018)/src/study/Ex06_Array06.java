package study;

// 2차원 배열
public class Ex06_Array06 {
	public static void main(String args[]) {
		/* int[][] array; 		--> 2차원 배열 선언
		 * array = new int[][]; --> 2차원 배열 생성하고 그 주소값을 배열명에 저장
		 */
		
		/* int[] array;
		 * int[][] array2;
		 * array = new int[3][3];
		 * 		--> 에러! array는 1차원 배열, 2차원 배열을 array에 할당할 수 없다!!!
		 */
		
		int[][] score = new int[][] { {101, 102, 103},
			                     	  { 11,  12,  13},
			                     	  { 21,  22,  23},
			                     	  { 31,  32,  33},
			                     	  { 41,  42,  43}			                     	 
		                            };
	    /* new int[A][B]; --> A개 행 & B개 열로 이루어진 2차원 배열을 생성, 초기화하지 않을 때
	     * new int[][] {{A,B},{C,D}, ...}; --> 초기값을 입력할 때는 [][]는 비워두어야 한다
	     * 
	     * int[][] array11 = new int[][] {{},{},{}}; --> 0으로 초기화된 3x1 행렬
	     * int[][] array22 = new int[][] {{1,2},{3,4},{5,6}}; --> 3x2 행렬
	     * array22[0]; --> array22 2차원 배열의 첫번째 행 전체를 의미 --> {1,2}
	     * array22[0][0]; --> array22 2차원 배열의 첫번째 행의 첫번째 열의 값 --> '1'
	     */
		                            
		for(int i = 0; i < score.length; i++){
	        for(int j = 0; j < score[i].length; j++){
	        	System.out.println(score[i][j]);
	        }
	    }
		
		for(int i = 0; i < score.length; i++){
	        for(int j = 0; j < score[i].length; j++){
	        	score[i][j] = i;
	        	System.out.println(score[i][j]);
	        }
	    }
		                            
	}

}