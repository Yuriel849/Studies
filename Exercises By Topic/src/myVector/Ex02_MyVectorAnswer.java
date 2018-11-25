package myVector;

class Ex02_MyVectorAnswer {
	Object[] objArr; // null로 자동초기화
		// capacity를 얼마로 할지 모르는데 간단초기화하지 못한다 --> 생성자에서 초기화해야
	int size;
	
	// 생성자 : 주어진 값의 크기로 iv 초기화 
	Ex02_MyVectorAnswer(int capacity) {
			// capacity는 배열의 크기
		if(capacity < 0) {
			throw new IllegalArgumentException("잘못된 값을 입력했습니다 --> " + capacity);
		}
		objArr = new Object[capacity];
	}
	
	// 기본생성자 : 사용자가 capacity를 설정하지 않는다면
	Ex02_MyVectorAnswer() {
		this(16); // == MyVectorAnswer(16);
//		objArr = new Object[16];
	}
	
	// MyVectorAnswer의 capacity(== 용량 == 배열의 길이) 반환
	int capacity() {
		return objArr.length;
	}
	
	// MyVectorAnswer의 size 반환
	int size() {
		return size;
	}
	
	// MyVectorAnswer이 비었을 때 true, 아니면 false
	// "배열이 비었다" == 배열에 저장된 객체가 하나도 없다
	boolean isEmpty() {
//		if(size == 0) { return true; }
//		return false;
		return size == 0;
	}
	
	// 지정된 index에 저장된 객체를 반환
	Object get(int index) {
		if(index < 0) { // 항상 유효성 검사를 해야한다!!
			throw new IllegalArgumentException("인덱스의 범위를 넘었습니다 --> " + index);
		}
		return objArr[index];
	}
	// 주어진 객체(obj)를 배열에 저장
	void add(Object obj) {
		// 저장할 공간이 남아있는지 확인하기
		// A. 공간이 없으면, 공간 확보 후 저장 (큰 배열 생성, 기존 내용 복사, 참조변수 복사)
		if(capacity() == size) {
				// 1. 큰 배열 생성 (기존 용량의 2배)
			Object[] tmp = new Object[objArr.length * 2];
				// 2. 기본 내용 복사 (objArr[0] ~ objArr[size])
			for(int i = 0; i < size; i++) {
				tmp[i] = objArr[i]; }
				// 3. 참조값 변경 (참조변수를 기존 배열에서 새 배열로 이동)
			objArr = tmp; }
		// B. 공간이 있으면 obj를 objArr에 저장
		objArr[size++] = obj;
	}
	
	public String toString() {
		String tmp = "[";
		for(int i = 0; i < size; i++) {
			tmp += objArr[i] + ","; }
		return tmp + "]";
	}
	
	// 지정된 객체(obj)의 위치(배열의 index)를 반환 --> 못 찾으면 -1 반환
	int indexOf(Object obj) {
		// objArr에서 obj를 찾는다
		for(int i = 0; i < size; i++) {
			if(objArr[i].equals(obj)) {
				// obj를 찾은 위치(배열의 index)를 반환
				return i;
			} }
		return -1;
	}
	
	// objArr에서 지정된 객체(obj)를 삭제하는 메서드
	boolean remove(Object obj) {
		// objArr에서 obj가 어디있는지 위치 찾기
		int idx = indexOf(obj);		
		// objArr에서 obj를 못 찾으면 (idx == -1) 삭제 실패
		if(idx == -1) { return false; }
		// obj 찾으면 삭제
			// (1) 삭제하려는 요소 이하의 요소를 한칸씩 위로 이동
		System.arraycopy(objArr, idx+1, objArr, idx, size-1-idx);
				// objArr[idx+1]에서 objArr[idx]로 size-idx-1개 요소를 복사
			// (2) 마지막 요소를 null로
		objArr[size-1] = null;
			// (3) size--; 
		size--;
		return true;
	}
	
	// 객체 배열의 모든 객체를기 제거 (모든 요소를 null로 저장하고 size = 0)
	void clear() {
		for(int i = 0; i < size; i++) {
			objArr[i] = null;
		}
		size = 0;
	}
}