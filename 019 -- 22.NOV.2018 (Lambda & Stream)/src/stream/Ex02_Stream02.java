package stream;

import java.io.File;
import java.util.stream.Stream;

// map 쓰기

class Ex02_Stream02 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt") };
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> filenameStream = fileStream.map(File::getName);
//		filenameStream.forEach(System.out::println);// 모든 파일의 이름을 출력
		
//		fileStream = Stream.of(fileArr); // 스트림을 다시 생성
//		
//		fileStream.map(File::getName) // Stream<File> --> Stream<String> 변환
//				  .filter(s -> s.indexOf('.') != -1)
//				  .map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
//				  .map(String::toUpperCase) // 모두 대문자로 변환
//				  .distinct() // 중복 제거
//				  .forEach(System.out::print); // JAVABAKTXT 출력
//		
//		System.out.println();
		
		fileStream = Stream.of(fileArr); // 스트림을 다시 생성
		filenameStream = fileStream.map(File::getName);
		
		filenameStream.filter(s -> s.indexOf('.') != -1)
//					  .peek(System.out::println)
					  .map(s -> s.substring(0, s.indexOf('.'))) // 파일이름에서 확장자를 제외
//					  .peek(System.out::println);
					  .forEach(System.out::println);
	}
}
