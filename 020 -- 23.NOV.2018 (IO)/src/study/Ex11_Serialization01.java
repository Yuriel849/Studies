package study;

// Ex07_Serialization02 * Ex08_Serialization03에서 사용할 UserInfo를 넣는 클래스이다.

@SuppressWarnings("serial")
class Ex11_Serialization01 implements java.io.Serializable {
	String name;
	transient String password; // "transient" 붙였기에 "password"라는 이름을 가진 이 문자열은 직렬화에서 제외된다!
	int age;				   // 	 >> 실제로 역직렬화해서 보면, "password"가 들어갈 자리에 기본값 "null"이라고 써있다!	
	
	public Ex11_Serialization01() {
		this("Unknown", "1111", 0);
	}
	
	public Ex11_Serialization01(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
} // 클래스 끝.