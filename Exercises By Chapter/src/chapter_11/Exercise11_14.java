package chapter_11;

import java.util.*;

// 성적처리 프로그램의 일부이다. Scanner클래스를 이용해서 화면으로부터 데이터를 입력하고 보여주는 기능을 완성하라.

class Exercise11_14 {
	@SuppressWarnings("rawtypes")
	static ArrayList record = new ArrayList(); // 성적데이터를 저장할 공간
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
			switch(displayMenu()) {
				case 1 :
					inputRecord();
					break;
				case 2 :
					displayRecord();
					break;
				case 3 :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			}
		} // while(true) 끝.
	} // main() 끝.

	// menu를 보여주는 메서드
	static int displayMenu(){
		System.out.println("**************************************************");
		System.out.println("* 성적 관리 프로그램 *");
		System.out.println("**************************************************");
		System.out.println();
		System.out.println(" 1. 학생성적 입력하기 ");
		System.out.println();
		System.out.println(" 2. 학생성적 보기");
		System.out.println();
		System.out.println(" 3. 프로그램 종료 ");
		System.out.println();
		System.out.print("원하는 메뉴를 선택하세요.(1~3) : ");
		
		int menu = 0;
		
		// 1. 화면으로부터 메뉴를 입력받는다. 메뉴의 값은 1~3사이의 값이어야 한다.
		while(true) {
			menu = scan.nextInt();
			// 2. 1~3사이의 값을 입력받지 않으면, 메뉴의 선택이 잘못되었음을 알려주고 다시 입력받는다.(유효한 값을 입력받을 때까지 반복해서 입력받는다.)
			if(menu < 1 || 3 < menu) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요!");
			} else {
				break;
			}
		}
		
		

		return menu;
	} // displayMenu() 끝.
	
	// 데이터를 입력받는 메서드
	@SuppressWarnings("unchecked")
	static void inputRecord() {
		System.out.println("1. 학생성적 입력하기");
		System.out.println("이름,반,번호,국어성적,영어성적,수학성적'의 순서로 공백없이 입력하세요.");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
		while(true) {
			System.out.print(">>");
			
			// 1. Scanner를 이용해서 화면으로 부터 데이터를 입력받는다.(','를 구분자로)
			try {
				String[] input = scan.nextLine().split(",");
				// 2. 입력받은 값이 q 또는 Q이면 메서드를 종료하고, 그렇지 않으면 입력받은 값으로 Student인스턴스를 생성하고 record에 추가한다.
				if(input[0].equalsIgnoreCase("q")) { return; }
				else {
					Student std = new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]),
							Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]));
					record.add(std);
				}
			} catch(Exception e) {
				// 3. 입력받은 데이터에서 예외가 발생하면, "입력오류입니다."를 보여주고 다시 입력받는다.
				System.out.println("입력오류입니다.");
			}
		} // while 끝.
	} // inputRecord() 끝.
	
	// 데이터 목록을 보여주는 메서드
	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int length = record.size();
		if(length > 0) {
			System.out.println();
			System.out.println("이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
			System.out.println("====================================================");
			for (int i = 0; i < length ; i++) {
				Student student = (Student)record.get(i);
				System.out.println(student);
				koreanTotal += student.kor;
				mathTotal += student.math;
				englishTotal += student.eng;
				total += student.total;
			} // for문 끝.
			System.out.println("====================================================");
			System.out.println("총점: "+koreanTotal+" "+englishTotal +" "+mathTotal+" "+total);
			System.out.println();
		} else {
			System.out.println("====================================================");
			System.out.println(" 데이터가 없습니다.");
			System.out.println("====================================================");
		}
	} // displayRecord() 끝.
} // 클래스 끝.

@SuppressWarnings("rawtypes")
class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank;
	int classRank; // 반등수
	
	// 생성자
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
	}
		
	int getTotal() {
		return total;
	}
		
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
		
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}
		
	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + ","
				+ getTotal() + "," + getAverage() + "," + schoolRank + "," + classRank;
	}
} // Student 클래스 끝.
