package collectionsFramework;

// 무엇을 만들 때마다 꾸준히 test하는 것이 중요!!!
class MyVectorAnswerTest {
	public static void main(String[] args) {
		MyVectorAnswer v = new MyVectorAnswer(2);
		System.out.println(v.isEmpty());
		for(int i = 0; i < 10; i++) {
			v.add(i + ""); // 숫자와 빈문자열 더하면 결과도 문자열
			System.out.println(v + ":capacity=" + v.capacity());
		}
		System.out.println(v.size());
		v.clear();
		System.out.println(v + ":capacity=" + v.capacity());
		System.out.println(v.size());

	}
	
}
