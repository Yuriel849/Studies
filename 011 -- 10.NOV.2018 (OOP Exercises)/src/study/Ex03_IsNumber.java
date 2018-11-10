package study;

public class Ex03_IsNumber {
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
	
	static boolean isNumber(String str) {
		//유효성 체크
		if(str == null || str == "") { return false; }
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(!('0' <= c && c <= '9')) { return false; }
		}
		return true;
	}
}
