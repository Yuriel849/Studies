package chapter_07;

// Buyer클래스를 작성하고 물건을 사고, 산 물건을 장바구니에 저장하고, 쇼핑의 결과를 출력하는 예제

class Exercise07_19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		
		b.summary();
	} // main() 끝.
} // 클래스 끝.

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int idx = 0; // Product 배열 card에 사용될 index
	
	void buy(Product p) {
		// 가진 돈과 물건의 가격을 비교하여 가진 돈이 적으면 메서드를 종료한다.
		if(p.price > money) {
			System.out.println("잔액이 부족하여 " + p + "를 살 수 없습니다.");
			return;
		}
		
		// 가진 돈이 충분하면, 제품의 가격을 가진 돈에서 뺀다.
		money -= p.price;
		
		// 장바구니에 구입한 물건을 담는다. (add메서드 호출)
		add(p);
	} // buy() 끝.
	
	void add(Product p) {
		// idx의 값이 장바구니의 크기보다 같거나 크면 -->
		if(idx >= cart.length) {
				// 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다.
			Product[] temp = new Product[cart.length * 2];
				// 기존의 장바구니의 내용을 새로운 배열에 복사한다.
			System.arraycopy(cart, 0, temp, 0, cart.length);
				// 새로운 장바구니와 기존의 장바구니를 바꾼다.
			cart = temp;
		}

		// 물건을 장바구니(cart)에 저장한다. 그리고 idx의 값을 1 증가시킨다.
		cart[idx++] = p;
	} // add() 끝.
	
	void summary() {
		// 장바구니에 담긴 물건들의 목록을 만들어 출력한다.
		String str = "구입한 물건 : ";
		for(int i = 0; i < cart.length; i++) {
			if(i > 0) { str += ", "; }
			str += cart[i];
		}
		System.out.println(str);
		
		// 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다.
		str = "사용한 금액 : ";
		int sum = 0;
		for(int i = 0; i < cart.length; i++) {
			sum += cart[i].price;
		}
		System.out.println(str + sum);
		
		// 물건을 사고 남은 금액(money)를 출력한다.
		System.out.println("남은 금액 : " + money);
		
	} // summary() 끝.
} // Buyer 클래스 끝.

class Product {
	int price; // 제품의 가격
	
	Product(int price) {
		this.price = price;
	}
} // Product 클래스 끝.

class Tv extends Product {
	Tv() {
		super(100);
	}
	
	public String toString() {
		return "Tv";
	}
} // Tv 클래스 끝.

class Computer extends Product {
	Computer() {
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
} // Computer 클래스 끝.

class Audio extends Product {
	Audio() {
		super(50);
	}
	
	public String toString() {
		return "Audio";
	}
} // Audio 클래스 끝.