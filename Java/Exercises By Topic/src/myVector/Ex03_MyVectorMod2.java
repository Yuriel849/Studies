package myVector;

// 이미 존재하는 Vector 클래스를 모방하는 나만의 클래스를 만들어보자.
class Ex03_MyVectorMod2 {
	Object[] objArr;
	int size;
	
	// 사용자가 capacity를 지정할 수 있는 생성자
	Ex03_MyVectorMod2(int capacity) {
		if(capacity < 0) { System.exit(0); } // 0보다 작은 인자를 사용하면 종료하도록 한다.
		objArr = new Object[capacity];
	}
	
	// 기본생성자 (default capacity = 16)
	Ex03_MyVectorMod2() {
		this(16);
	}

	// 배열에 저장된 객체의 개수를 반환
	int size() {
		return size;
	} // size() 끝.
	
	// 배열의 크기를 반환
	int capacity() {
		return objArr.length;
	} // capacity() 끝.
	
	// 배열이 비었는지 확인
	boolean isEmpty() {
		return size == 0; // 배열이 비었다 -> size는 0이다 --> true 반환 <--> size가 0이 아니면 false 반환
	} // isEmpty() 끝.
	
	// 배열에 추가
	void add(Object obj) { // 저장할 공간이 있는지를 확인해야!
		if(size >= capacity()) { // i.e. 현재 객체배열에 빈 자리가 없을 시
			ensureCapacity(capacity()*2); // 배열을 늘리기
			objArr[size++] = obj;
		}
		else { objArr[size++] = obj; } // 배열에 객체 추가 후 size 값 1 증가
	} // add() 끝.
	
	// 더 커진 새 배열을 생성하고 기존 배열의 값들을 복사 붙여넣는다
	void ensureCapacity(int newSize) {
		// ensureCapacity 호출하면서 넘긴 인자값의 크기를 체크
		if(newSize <= capacity()) {
			System.out.println("잘못된 값을 입력했습니다.");
			System.exit(0);
		}
		Object[] tmp = new Object[newSize];
		System.arraycopy(objArr, 0, tmp, 0, size);
		objArr = tmp;
	} // ensureCapacity() 끝.
	
	// 지정된 위치(index)에 있는 값을 반환
	Object get(int index) {
		return objArr[index];
	} // get() 끝.
	
	// 지정된 객체의 위치(index)를 반환
	int indexOf(Object obj3) {
		int index = 0;
		for(int i = 0; i < size; i++) {
			if(obj3 == null) { break; } 
			else if (obj3.equals(objArr[i])) {
		/* equals() 호출하면 Object의 원조 equals()가 아니라 
		 * 	>> 객체의 실제 인스턴스의 equals()가 호출된다
		 * 		>> 다형성!!! >> 참조변수의 타입과 상관 없이 항상 실제 인스턴스의 메서드가 호출된다!
		 * 	>> ex) obj3이 String타입이면 String의 오버라이딩된 equals() 호출
		 * 
		 * 객체의 실제 인스턴스에서 오버라이딩했는지 안했는지는 어떻게 아는가?
		 * 	>> 해당 클래스에서 알아서 책임졌을 것, 그것까지 내가 해줄 필요는 없다
		 */
				return i;
			} } // for문 끝.
		System.out.println("지정된 객체를 찾지 못했습니다. (indexOf)");
		return -1;
	} // indexOf() 끝.

			// 아래 코드의 문제점은 객체가 반드시 String 타입이어야 한다는 것!!!
//			if(obj3 instanceof String && objArr[i] instanceof String) {	
//				if(((String) obj3).equals((String) objArr[i])) {
		/* obj3 & objArr의 각 칸의 객체가
		 * 	>> Object타입 참조변수로 참조하는 String 객체(문자열)이기에
		 * 	>> String클래스에서 오버라이딩한 equals()로 비교
		 */
	
			// 아래 코드의 문제점은 객체가 반드시 Integer 타입이어야 한다는 것!!!
//			if(obj3 instanceof Integer && objArr[i] instanceof Integer) {
//				if(((Integer) obj3).intValue() == (Integer) objArr[i]) {
		/* wrapper클래스와 기본형을 비교하면 wrapper를 기본형으로 unboxing하여 비교한다
		 * 	>> intValue 때문에 obj3는 int <--> objArr[i]는 Integer 객체
		 * 	>> 비교하면 objArr[i]를 int로 unboxing 후 값 비교
		 */
	
	// 지정된 객체를 삭제
	boolean remove(Object obj) {
		int index = indexOf(obj); // 객체의 위치(index) 확인
		if(index == -1) {
			System.out.println("지정된 객체가 존재하지 않습니다. (remove)");
			return false;
		} else {
			System.arraycopy(objArr, index+1, objArr, index, size-1-index);
			objArr[size-1] = null;
			size--;
			System.out.println("지정된 객체(" + obj + ")를 삭제했습니다.");
			return true;
		}
	} // remove() 끝.
	
	// Object로부터 상속받은 toString() 오버라이딩
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			if(i > 0) { str += ","; }
			str += objArr[i];
		}
		return str + "]";
	} // toString() 끝.
} // 클래스 끝.
