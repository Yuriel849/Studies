package chapter_08;

// UnsupportedFunctionException 예외클래스를 작성하라.

class Exercise08_09 {
	public static void main(String[] args) {
		try {
			throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100);
		} catch(UnsupportedFunctionException e) {
			e.printStackTrace();
		}
	} // main() 끝.
} // 클래스 끝.

class UnsupportedFunctionException extends RuntimeException {
	final private int ERR_CODE;
	
	UnsupportedFunctionException(String str, int num) {
		super(str); // parent의 인스턴스변수 msg를 사용 --> parent의 생성자로 초기화
		ERR_CODE = num;
	}
	
	UnsupportedFunctionException(String str) {
		this(str,100);
	}
	
	public int getErrorCode() { // 에러 코드를 알 수 있게 추가.
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
}
