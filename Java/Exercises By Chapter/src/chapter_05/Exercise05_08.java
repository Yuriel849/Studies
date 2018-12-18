package chapter_05;

// 배열 answer에 담긴 데이터를 읽어 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어 그래프를 그려라.

class Exercise05_08 {
	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		
		for(int i = 0; i < answer.length; i++) {
			counter[answer[i]-1]++;
		}
		
		for(int i = 0; i < counter.length; i++) {
			System.out.print(counter[i]);
			for(int j = 0; j < counter[i]; j++) {
				System.out.print('*'); // counter[i]의 값만큼 '*'를 찍는다.
			}
			
			System.out.println();
		}
	}
}