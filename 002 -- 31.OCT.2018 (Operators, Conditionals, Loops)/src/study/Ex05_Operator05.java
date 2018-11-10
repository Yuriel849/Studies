package study;

public class Ex05_Operator05 {
	public static void main(String args[]) {
		int num1 = 10, num2 = 5;
		
		/* ��Ʈ������ AND (&)
		 * ���װ� ������ �� ��Ʈ�� ���Ͽ� ��� 1�� �ڸ��� 1�� ��ȯ, �������� 0�� ��ȯ
		 */
		int result = num1 & num2;
		System.out.println("num1 & num2 : " + result);
		/* "0"�� ��µȴ�
		 * num1 -> 0 1 0 1 0
		 * num2 -> 0 0 1 0 1
		 *  &   -> 0 0 0 0 0 
		 * 		--> ��Ʈ�����ڷ� 10�� ��Ʈ���� 5�� ��Ʈ���� ��� 1�� �� 1�� ��ȯ�ϴ� &�� ��������� ��� 1�� ��Ʈ�� ����!!
		 * 		--> "10"�� 2������ 1 0 1 0 --> (1x2**3) + (1x2**1) = 8 + 2 = 10
		 */
		
		/* ��Ʈ������ OR (|)
		 * ���װ� ������ �� ��Ʈ�� ���Ͽ� ��� 0�� �ڸ��� 0�� ��ȯ, �������� 1�� ��ȯ
		 */
		result = num1 | num2;
		System.out.println("num1 | num2 : " + result);
		/* num1 -> 0 1 0 1 0
		 * num2 -> 0 0 1 0 1
		 *  |   -> 0 1 1 1 1 --> (1x2**3) + (1x2**2) + (1x2**1) + (1x2**0)
		 *  				 --> 	 8    +		4 	 +	   2	+	  1    = 15
		 */
		
		/* ��Ʈ������ XOR (^)
		 * ���װ� ������ �� ��Ʈ�� ���Ͽ� ���� �ٸ� �ڸ��� 1�� ��ȯ, �������� 0�� ��ȯ
		 */
		result = num1 ^ num2;
		System.out.println("num1 ^ num2 : " + result);
		/* num1 -> 0 1 0 1 0
		 * num2 -> 0 0 1 0 1
		 *  |   -> 0 1 1 1 1 --> (1x2**3) + (1x2**2) + (1x2**1) + (1x2**0)
  		 *  				 --> 	 8    +		4 	 +	   2	+	  1    = 15
		 *  				 --> �̹����� �쿬�� OR & XOR ������� ��ġ���� ��!!!
		 */
		
		/* ��Ʈ������ NOT (~)
		 * ���׿����ڴ�
		 * �ش� ��Ʈ���� �ݴ�� �ٲپ� ��ȯ (1�� 0����, 0�� 1��)
		 */
		result = ~num1 & num2;
		System.out.println("~num1 & num2 : " + result);
		/* num1 -> 0 1 0 1 0
		 *~num1 -> 1 0 1 0 1
		 * num2 -> 0 0 1 0 1
		 *  &   -> 0 0 1 0 1 --> (1x2**2) + (1x2**0)
		 *  				 --> 	 4 	  + 	1    = 5
		 */
	}

}