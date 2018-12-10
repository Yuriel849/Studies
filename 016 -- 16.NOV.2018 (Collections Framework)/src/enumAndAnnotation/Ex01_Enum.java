package enumAndAnnotation;

// "Direction"이라는 타입의 객체는 4개의 값만을 가질 수 있다.
enum Direction { EAST, SOUTH, WEST, NORTH }

class Ex01_Enum {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST;
			// new Direction("EAST")라고 하는 것과 동일하다 --> 하지만 실제로 생성자를 사용하면 안된다!
			// 이렇게 주로 사용하고, 그 외 아래 2가지 방법도 사용할 수 있다.
			// EAST 등은 int형이 아니라 객체다!
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1==d2 ? " + (d1==d2));
		System.out.println("d1==d3 ? " + (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d2 > d3 ? " + (d2 > d3)); --> 에러! --> enum과 비교연산자를 같이 쓸 수 없다.
		System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
		System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));
		
		switch(d1) {
			case EAST: // Direction.EAST라고 쓸 수 없다.
				System.out.println("The direction is EAST."); break;
			case SOUTH:
				System.out.println("The direction is SOUTH."); break;
			case WEST:
				System.out.println("The direction is WEST."); break;
			case NORTH:
				System.out.println("The direction is NORTH."); break;
			default:
				System.out.println("Invalid direction."); break;
		}

		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) // for(Direction d : Direction.values())
			System.out.printf("%s=%d%n", d.name(), d.ordinal());
	} // main() 끝.
} // 클래스 끝.
