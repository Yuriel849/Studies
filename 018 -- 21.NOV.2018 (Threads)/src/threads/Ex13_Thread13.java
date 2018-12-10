package threads;

// 동기화 예제 --> 동기화가 안 되어있다.

public class Ex13_Thread13 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx13();
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc 대상이 아니다.
		new Thread(r).start();
	} // main() 끝.
} // 클래스 끝.

class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance >= money) {
			try { Thread.sleep(1000);
			} catch (InterruptedException e) {}
			balance -= money;
		}
	}
} // 클래스 끝.

class RunnableEx13 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300 중의 한 값을 임의로 선택해서 출금 (withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.getBalance());
		}
	}
} // 클래스 끝.