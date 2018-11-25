package chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Student클래스에 Comparable 인터페이스를 구현하라.
// 기본정렬기준이 name이 되도록하라.

class Exercise11_05 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("홍길동",1,1,100,100,100));
		list.add(new Student("박자바",1,2,90,70,80));
		list.add(new Student("김자바",1,3,80,80,90));
		list.add(new Student("이자바",1,4,60,90,70));
		list.add(new Student("안자바",1,5,70,50,50));
		
		Collections.sort(list);
		Iterator it = list.iterator();
		
		System.out.println("이름, 반, 번호, 국어, 영어, 수학, 총점, 평균");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() 끝.
} // 클래스 끝.

@SuppressWarnings("rawtypes")
class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
	
	public int compareTo(Object o) {
		String myName = this.name;
		String yourName = "";
		if(o instanceof Student) {
			yourName = ((Student) o).name;
		}
		return myName.compareTo(yourName);
	}
} // 클래스 끝.