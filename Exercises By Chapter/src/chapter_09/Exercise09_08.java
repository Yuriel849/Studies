package chapter_09;

// round 메서드를 작성하라.

class Exercise09_08 {
	static double round(double d, int n) {
		double db = d*Math.pow(10, n);
		db = Math.round(db);
		return db / Math.pow(10, n); 
	} // round() 끝.
	
	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	} // main() 끝.
} // 클래스 끝.