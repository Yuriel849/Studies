package study;

class Ex05_RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
//		scv.repair(marine); --> 에러! --> repair(Repairable) in SCV cannot be applied to class Marine
	}
}

interface Repairable {} // 내용 없는 인터페이스 작성

class Unit {
	int hitPoint;
	final int MAX_HP;
	
	Unit(int hp) {
		MAX_HP = hp;
	}
	
	// 기타등등......
}

class GroundUnit extends Unit {
	GroundUnit(int hp) { // GroundUnit 클래스의 생성자
		super(hp); // GroundUnit의 parent인 Unit 클래스의 생성자 호출
	}
}

class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
		/* Tank 생성자에서 GroundUnit 생성자 호출
		 *	--> GroundUnit 생성자에서 Unit 생성자 호출
		 * 	--> Unit에서 Tank의 고유 MAX_HP 설정
		 * 	--> MAX_HP를 hitPoint에 대입
		 * 		(체력의 한계(MAX_HP)는 존재하되 체력을 잃고 채울 때 사용하기 위한 hitPoint)
		 */
	}
	
	public String toString() {
		return "Tank";
	}
	
	// 기타 등등......
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Dropship";
	}
	
	// 기타 등등......
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Marine";
	}
	
	// 기타 등등......
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	
	void repair(Repairable r) {
		if(r instanceof Unit) {
			Unit u = (Unit) r;
			while(u.hitPoint != u.MAX_HP) {
				/* Unit의 HP를 증가시킨다. */
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		}
	}
	
	public String toString() {
		return "SCV";
	}
}