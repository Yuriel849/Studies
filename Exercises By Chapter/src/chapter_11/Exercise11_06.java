package chapter_11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

// 성적평균의 범위별로 학생 수를 세라.
// TreeSet이 평균을 기준으로 정렬하도록 compare()와
// 		평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 작성하라.

@SuppressWarnings({ "rawtypes", "unchecked" })
class Exercise11_06 {
	static int getGroupCount(TreeSet tset, int from, int to) {
		Student2 s1 = new Student2("", 0, 0, from, from, from);
		Student2 s2 = new Student2("", 0, 0, to, to, to);
		return tset.subSet(s1, s2).size();
	} // getGroupCount() 끝.
	
	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() { // 익명클래스
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Student2 && o2 instanceof Student2) {
					Student2 s1 = (Student2)o1;
					Student2 s2 = (Student2)o2;
					return (int)(s1.getAverage() - s2.getAverage());
				} // 평균점수를 정렬기준으로 쓰기 때문에, 값 중복도 평균점수를 보고 중복인지 아닌지 판단한다. (set은 중복된 값은 저장되지 않는다!)
				return -1;
			}
		});

		set.add(new Student2("홍길동",1,1,100,100,100));
		set.add(new Student2("박자바",1,2,90,70,80));
		set.add(new Student2("김자바",1,3,80,80,90));
		set.add(new Student2("이자바",1,4,70,90,70));
		set.add(new Student2("안자바",1,5,60,100,80)); // 안자바와 박자바의 평균점수와 같기에 중복값으로 취급
													  // 	--> 먼저 실행된 박자바는 저장되고 안자바는 저장되지 않는다.
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("[60~69] :" + getGroupCount(set,60,70));;
		System.out.println("[70~79] :" + getGroupCount(set,70,80));;
		System.out.println("[80~89] :" + getGroupCount(set,80,90));;
		System.out.println("[90~99] :" + getGroupCount(set,90,101));;
	} // main() 끝.
} // 클래스 끝.

@SuppressWarnings("rawtypes")
class Student2 implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
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
		return name
				+ "," + ban
				+ "," + no
				+ "," + kor
				+ "," + eng
				+ "," + math
				+ "," + getTotal()
				+ "," + getAverage();
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student2) {
			Student2 tmp = (Student2) o;
			return name.compareTo(tmp.name);
		}
		return -1;
	}
} // 클래스 끝.