package study;

import java.io.File;

//예외 선언하기 (예외를 처리하는 것이 아니라 해당 메서드를 호출한 곳에서 처리하도록 지시)
class Ex04_ExceptionHandling03 {
	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
		}
	} // main()의 끝.

	static File createFile(String fileName) throws Exception { // createFile에서 예외 발생하면 메서드를 호출한 곳에서 처리해야 한다.
		if(fileName == null || fileName.equals(""))
			throw new Exception("파일이름이 유효하지 않습니다.");
		File f = new File(fileName);
		// File 객체의 createNewFile 메서드를 이용해서 실제 파일을 생성한다.
		f.createNewFile();
		return f; // 생성된 객체의 참조를 반환한다.
	} // createFile 메서듸의 끝.
} // 클래스의 끝.
