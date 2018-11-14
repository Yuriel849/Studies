package collectionsFramework;

// 이미 존재하는 Vector 클래스를 모방하는 나만의 클래스를 만들어보자.
class MyVector {
	Object[] objArr;
	int size;
	int capacity;
	
	// 사용자가 capacity를 지정할 수 있는 생성자
	MyVector(int capacity) {
		if(capacity < 0) { System.exit(0); } // 0보다 작은 인자를 사용하면 종료하도록 한다.
		this.capacity = capacity;
		objArr = new Object[capacity];
	}
	
	// 기본생성자 (default capacity = 16)
	MyVector() {
		this(16);
	}

	// 배열에 저장된 객체의 개수를 반환
	int size() {
		return size;
	}
	
	// 배열의 크기를 반환
	int capacity() {
		return capacity;
	}
	
	// 배열이 비었는지 확인
	boolean isEmpty() {
		if(size == 0) { return true; }
		else { return false; }
	}
	
	// 배열에 추가
	void add(Object obj) { // 저장할 공간이 있는지를 확인해야!
		if(size >= capacity) { // i.e. 현재 객체배열에 빈 자리가 없을 시
			ensureCapacity(capacity*2); // 배열을 늘리기
			objArr[size++] = obj;
		}
		else { objArr[size++] = obj; } // 배열에 객체 추가 후 size 값 1 증가
	}
	
	// 더 커진 새 배열을 생성하고 기존 배열의 값들을 복사 붙여넣는다
	void ensureCapacity(int newSize) {
		if(newSize <= capacity) {
			System.out.println("잘못된 값을 입력했습니다.");
			System.exit(0);
		}
		Object[] obj = new Object[newSize];
		System.arraycopy(objArr, 0, obj, 0, size);
		objArr = obj;
		capacity = newSize;
	}
	
	// 지정된 위치(index)에 있는 값을 반환
	Object get(int index) {
		return objArr[index];
	}
	
	// 지정된 객체의 위치(index)를 반환
	int indexOf(Object obj3) {
		int index = 0;
		boolean flag = false;
		for(int i = 0; i < size; i++) {
//			System.out.println("mrow");
			if(((Integer) obj3).intValue() == ((Integer) objArr[i]).intValue()) {
//				System.out.println("meow");
				flag = true;
				index = i;
			} } // for문 끝.
		if(flag == false) {
			System.out.println("지정된 객체가 존재하지 않습니다.");
			System.exit(0);
		}
		return index;
	}
	
	// 지정된 객체를 삭제
	boolean remove(Object obj) {
		int index = indexOf(obj);
		System.arraycopy(objArr, index+1, objArr, index, size-1-index);
		objArr[size-1] = null;
		size--;
		return true;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			if(i > 0) { str += ","; }
			str += objArr[i];
		}
		str += "]";
		return str;
	}
}
