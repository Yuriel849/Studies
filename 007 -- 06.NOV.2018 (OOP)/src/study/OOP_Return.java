package study;

class Return {
	int max(int a, int b) {
		if(a>b) {
			return a;
		} // 왜 에러? if일 때 int형 a를 반환하는데? --> if가 실행 안 될 때는?? --> 그러면 int형을 반환하지 않기에 에러!
		else {
			return b;
		}
	}
}

public class OOP_Return {
	public static void main(String[] args) {
		Return ret = new Return();
		ret.max(4, 5); // 호출할 때 반환값을 받지 않는 것은 문제되지 않는다
					   // 정의할 때 반환값이 있어야 하는데 없는 것은 문제된다
	}
}
