package study;

public class Ex11_Constructor01 {
	public static void main(String[] args) {
		Data1 dt1 = new Data1();
		Data2 dt2 = new Data2(100);
		
		/* 기본생성자 사용하려면 >>
		 * Data2 dt22 = new Data2();
		 */
	}

}

class Data1 {
	int value;
}

class Data2 {
	int value;
	Data2(int x) {
		value = x;
	}
	/* 기본생성자 사용하려면
	 * Data2() {	}
	 */
}