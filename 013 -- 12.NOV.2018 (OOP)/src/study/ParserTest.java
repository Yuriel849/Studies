package study;

interface Parseable {
	// 구문 분석작업을 수행한다.
	public abstract void parse(String fileName);
}

class ParserManager {
	// 리턴타입이 Parseable 인터페이스다.
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			return new HTMLParser();
			/* 아래 코드의 압축버전
			 * 	>> Parseable p = new HTMLParser();
			 * 	>> return p;
			 */
		}
	}
}

class XMLParser implements Parseable {
	public void parse(String fileName) {
		/* 구분 분석작업을 수행하는 코드를 적는다. */
		System.out.println(fileName + " - XML parsing completed.");
	}
}

class HTMLParser implements Parseable {
	public void parse(String fileName) {
		/* 구분 분석작업을 수행하는 코드를 적는다. */
		System.out.println(fileName + " - HTML parsing completed.");
	}
}

class ParserTest {
	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML"); // parser 참조변수는 XMLParser 객체를 참조하게 된다
		parser.parse("document.xml"); // XMLParser.parse("document.xml")와 동일하다
		parser = ParserManager.getParser("HTML");
		parser.parse("document.html");
	}
}
