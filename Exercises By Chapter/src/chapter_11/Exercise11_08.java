package chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Student의 기본정렬을 총점(total)을 기준으로 한 내림차순으로 설정하고,
//		총점을 기준으로 각 학생의 전교등수를 계산하고 전교등수를 기준으로 오름차순 정렬하여 출력하라.

class Exercise11_08 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateSchoolRank(List list) {
		// 먼저 총점기준 내림차순으로 정렬한다.
		Collections.sort(list);
		
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		
			// 1. 반복문을 이용해서 list에 저장된 Student 객체를 하나씩 읽는다.
		for(int i = 0; i < length; i++) {
			if(list.get(i) instanceof Student4) {
				Student4 std = (Student4) list.get(i);
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
		list.add(new Student4("이자바",2,1,70,90,70));
		list.add(new Student4("안자바",2,2,60,100,80));
		list.add(new Student4("홍길동",1,3,100,100,100));
		list.add(new Student4("남자바",1,1,90,70,80));
		list.add(new Student4("김자바",1,2,80,80,90));

		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() 끝.
} // 클래스 끝.

@SuppressWarnings("rawtypes")
class Student4 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수
	
	Student4(String name, int ban, int no, int kor, int eng, int math) {
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
				+ "," + no
				+ "," + kor
				+ "," + eng
				+ "," + math
				+ "," + getTotal()
				+ "," + getAverage()
				+ "," + schoolRank;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student4) {
			Student4 tmp = (Student4) o;
			return tmp.total - this.total; // tmp의 total이 더 크면 양수, 같으면 0, 더 작으면 음수를 반환
		}
		return -1;
	}
} // 클래스 끝.