package study;

public class Ex05_ABS {
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value + "의 절다값: " + abs(value));
		value = -10;
		System.out.println(value + "의 절다값: " + abs(value));
	}
	
	static int abs(int value) {
		if(value >= 0) { return value; }
		else { return -value; }
		// OR return value >= 0 ? value : -value;
	}
}