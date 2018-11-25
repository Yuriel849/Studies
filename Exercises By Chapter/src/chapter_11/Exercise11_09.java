package chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Exercise11_08에 이어서 반등수(classRank)도 계산하여,
//		반으로 오름차순 정렬하고 반이 같으면 총점으로 내림차순 정렬하라.

class Exercise11_09 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateClassRank(List list) {
		// 먼저 반별 오름차순, 같은 반은 총점기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
			// 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		for(int i = 0, n = 0; i < length; i++, n++) {
			if(list.get(i) instanceof Student5) {
				Student5 std = (Student5) list.get(i);
					// 2. 반이 달라지면 (ban과 prevBan)이 다르면 prevRank와 prevTotal을 초기화한다.
				if(std.ban != prevBan) {
					prevRank = -1;
					prevTotal = -1;
					n = 0;
				}
					// 3. total이 prevTotal과 같으면 prevRank를 classRank로 한다.
				if(std.total == prevTotal) { std.classRank = prevRank; }
					// 4. 총점이 서로 다르면, classRank의 값을 알맞게 계산한다. 동점자가 있었다면, 그 다음 등수는 동점자도 고려해야 한다.
				else { std.classRank = n + 1; }
					// 5. 현재 반과 총점과 등수를 prevBan, prevTotal, prevRank에 저장한다.
				prevBan = std.ban;
				prevTotal = std.total;
				prevRank = std.classRank;
			}
		} // for문 끝.
	} // calculateClassRank() 끝.
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateSchoolRank(List list) {
		// 먼저 총점기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		
			// 1. 반복문을 이용해서 list에 저장된 Student 객체를 하나씩 읽는다.
		for(int i = 0; i < length; i++) {
			if(list.get(i) instanceof Student5) {
				Student5 std = (Student5) list.get(i);
					// 2. total이 prevTotal과 같으면 prevRank를 schoolRank로 한다.
				if(std.getTotal() == prevTotal) { std.schoolRank = prevRank; }
					// 3. 총점이 다르면, schoolRank의 값을 알맞게 계산한다. 동점자가 있었다면, 그 다음 등수는 동점자도 고려해야 한다.
				else { std.schoolRank = i + 1; } // 이미 sort()로 정렬되었기에, else문이 실행된다면 total이 더 크다는 것!
					// 4. 현재 총점과 등수를 prevTotal과 prevRank에 저장한다.
				prevTotal = std.getTotal();
				prevRank = std.schoolRank;
			}
		} // for문 끝.
	} // calculateSchoolRank() 끝.
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student5("이자바",2,1,70,90,70));
		list.add(new Student5("안자바",2,2,60,100,80));
		list.add(new Student5("홍길동",1,3,100,100,100));
		list.add(new Student5("남자바",1,1,90,70,90));
		list.add(new Student5("김자바",1,2,80,80,90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		System.out.println("이름, 반,\t번호,\t국어,\t영어,\t수학,\t총점,\t평균,\t전교등수,\t반 등수");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() 끝.
} // 클래스 끝.


@SuppressWarnings("rawtypes")
class Student5 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수
	int classRank; // 반 등수
	
	Student5(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return name
				+ "," + ban
				+ ",\t" + no
				+ ",\t" + kor
				+ ",\t" + eng
				+ ",\t" + math
				+ ",\t" + getTotal()
				+ ",\t" + getAverage()
				+ ",\t" + schoolRank
				+ ",\t" + classRank;
	}

	
	public int compareTo(Object o) {
		if(o instanceof Student4) {
			Student4 tmp = (Student4) o;
			return tmp.total - this.total; // tmp의 total이 더 크면 양수, 같으면 0, 더 작으면 음수를 반환
		}
		return -1;
	}
} // 클래스 끝.


@SuppressWarnings("rawtypes")
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int result = 0;
		if(o1 instanceof Student5 && o2 instanceof Student5) {
			Student5 s1 = (Student5) o1;
			Student5 s2 = (Student5) o2;
			result = s1.ban - s2.ban; // 반(ban) 기준정렬 (오름차순)
			
			if(result == 0) {
				result = s2.total - s1.total; // 총점(total) 기준정렬 (내림차순)
			}
		}
		return result;
	} // compare() 끝.
} // 클래스 끝.