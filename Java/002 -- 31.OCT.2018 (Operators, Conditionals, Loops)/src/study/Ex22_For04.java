package study;

public class Ex22_For04 {
	public static void main(String args[]) {
		//2중 중첩 for문
		for(int i=1; i<=10; i++) {
			System.out.println(i + "��");
			for(int j=1; j<=10; j++) {
				System.out.printf("%02d X %02d = %02d\n",  i, j, (i*j));
			}
			System.out.println();
		}
		
		//3중 중첩 for문
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.println("ù��° ���� \"" + i + "\", �ι�° ���� \"" + j + "\"");
				for(int k=1; k<=10; k++) {
					System.out.printf("%02d - %02d - %02d\n",  i, j, k);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}