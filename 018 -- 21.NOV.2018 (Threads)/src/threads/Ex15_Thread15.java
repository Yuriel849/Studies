package threads;

import java.util.ArrayList;

/* 동기화 했을 때 예제
 * 	>> 여전히 문제가 있다!!
 *  	>> 동기화했으나 한 쓰레드가 기다리면서 lock을 쥐고 있기 때문에, 다른 쓰레드가 작동을 못한다
 *  	>> 끝없이 한 쓰레드는 lock을 쥐고 기다리며, 나머지 쓰레드는 그 한 쓰레드 때문에 자기들 일도 하지 못하고 기다린다.
 *  		>> wait() & notify()로 해결!
 */

class Customer2 implements Runnable {
	private Table2 table;
	private String food;
	
	Customer2(Table2 table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood()) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + " failed to eat. :(");
			}
		}
	}
	
	boolean eatFood() { return table.remove(food); }
} // 클래스 끝.

class Cook2 implements Runnable {
	private Table2 table;
	
	Cook2(Table2 table) {
		this.table = table;
	}
	
	public void run() {
		while(true) {
			// 임의의 요리를 하나 선택해서 table에 추가한다.
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
} // 클래스 끝.

class Table2 {
	String[] dishNames = { "donut", "donut", "burger" }; // donut이 더 자주 나온다.
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수
	
	private ArrayList<String> dishes = new ArrayList<> ();
	
	public synchronized void add(String dish) { // synchronized를 추가
		// 테이블에 음식이 가득찼으면, 테이블에 음식을 추가하지 않는다.
		if(dishes.size() >= MAX_FOOD	 ) { return; }
		dishes.add(dish);
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) {
			// 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try { Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
			
			for(int i = 0; i < dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		} // synchronized
		
		return false;
	}
	
	public int dishNum() { return dishNames.length; }
} // 클래스 끝.

class Ex15_Thread15 {
	public static void main(String[] args) throws Exception {
		Table2 table = new Table2(); // 여러 쓰레드가 공유하는 객체
		
		new Thread(new Cook2(table), "COOK1").start();
		new Thread(new Customer2(table, "donut"), "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();

		// 0.1초 (100 millis) 후에 강제 종료한다.
		Thread.sleep(5000);
		System.exit(0);
	} // main() 끝.
} // 클래스 끝.