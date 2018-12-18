package study;

public class Ex05_Variable04 {
	public static void main(String args[]) {
		// float type�� ����� �ʱ�ȭ
		float f;
		/* f = 0.1;
		 * 		>> 에러
		 * 		>> 실수는 접미사가 없으면 default인 double로 설정되는데 f는 float이기 때문
		 * 		>> float(4byte로 표현)는 double(8byte로 표현)보다 작은 자료형
		 * 		>> double을 float에 우겨넣으려면 다 들어가지 않을 것이고 그러면 데이터 손실의 위험성이 존재한다
		 */
		f = 0.1f;
		f = 0.1F;
		f = (float)10.1; // 접미사 붙이는 대신 강제형변환 시킨 것
		
		/* double d;
		 * d = 3.14;
		 * 실수의 default 자료형이 double이기에 실수 뒤에 d라고 쓸 필요가 없다!!
		 * 		>> float만 default가 아닌 float형으로 바꾸기 위해서 쓰는 것이다
		 * 
		 * d = 3.14f;
		 * 에러 없다!!!
		 * 		>> d는 double(8byte로 표현)로 float(4byte로 표현)인 3.14f보다 크다
		 * 	
		 * 		>> !!! 작은 자료형의 데이터를 더 큰 자료형에 넣는 것은 자료손실 없이 변환되어 넣어지기에 문제없다!!!
		 */
		
		char ch = 'G';
		
		System.out.printf("ch : %c\n", ch);
		System.out.printf("ch : %c\n", ch + ('a' - 'A'));

		ch = 'f';
		
		System.out.printf("ch : %c\n", ch);
		System.out.printf("ch : %c\n", ch - ('a' - 'A'));
	}
	
}
