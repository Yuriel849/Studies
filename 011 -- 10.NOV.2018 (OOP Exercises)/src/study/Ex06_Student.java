package study;

public class Ex06_Student {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "È«±æµ¿";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("ÀÌ¸§ : " + s.name);
		System.out.println("ÃÑÁ¡ : " + s.getTotal());
		System.out.println("Æò±Õ : " + s.getAverage());
		System.out.println("s.info() : " + s.info() + "\n");
		
		Student s2 = new Student("È«±æµ¿",1,1,100,60,76);
		System.out.println("s2.info() : " + s2.info());
	}
}

class Student {
	String name;
	int ban, no, kor, eng, math;
	
	Student() {
		this("´©±¸?", 1, 1, 0, 0, 0);
	}
	
	Student(String str, int a, int b, int c, int d, int e) {
		this.name = str;
		this.ban = a;
		this.no = b;
		this.kor = c;
		this.eng = d;
		this.math = e;
	}
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return Math.round(getTotal() / 3.0 * 10) / 10f;
		// OR return (int)(getTotal() / 3f * 10 + 0.5f) / 10f;
	}
	
	String info() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
}