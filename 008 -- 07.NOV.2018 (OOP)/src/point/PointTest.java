package point;

public class PointTest {
	public static void main(String[] args) {
		Point p1 = new Point(); // (x,y) == (1,1)
		Point p2 = new Point(3, 5);
		System.out.println(p1); // Q1-3 문제
		System.out.println(p2.toString());
		/* println(객체명) == println(객체.toString())
		 * 	>> toString 출력해도 똑같이 나오는 것이 println의 기능
		 * 	>> println의 signature --> println(Object o) --> 다형성!!!
		 * 		>> 최고위 parent인 Object 타입 참조변수로 받은 후 toString 함수로 문자열로 만든 후 출력하는 것
		 */
		
		double d = Point.getDistance(p1, p2);
		double d2 = p2.getDistance(p2);
		System.out.println("점 p1 & p2 간 거리 : " + d); // Q1-7 문제
		System.out.println("점 p2 & p2 간 거리 : " + d2); // Q1-6 문제
		/* static 메서드는 항상 클래스명으로 호출 (객체명 사용하지 말 것)
		 * 	>> 에러가 나지는 않지만, 좋지 않다
		 */
		
		p1 = new Point(1,2);
		p2 = new Point(1,2);
		System.out.println(p1.equals(p2));
		
		Point3D p3 = new Point3D(1,2,5);
		Point3D p4 = new Point3D(1,2,5);
		System.out.println(p3); // Q1-11 문제
		System.out.println(p3.equals(p4));
		
		Point4D p5 = new Point4D(1,2,5,8);
		Point4D p6 = new Point4D(1,2,5,8);
		System.out.println(p5); // Q1-11 문제
		System.out.println(p5.equals(p6));
	}

}
