package threads;

class Ex01_Thread01 {
	public static void main(String[] args) {
		ThreadEx01 t1 = new ThreadEx01();
		
		Runnable r = new ThreadEx02();
		Thread t2 = new Thread(r); // 생성자 --> Thread(Runnable target)
		
		t1.start();
//		t1.start(); --> start()는 쓰레드 객체 당 단 한 번만 실행 가능 --> 다시 start()하려면 쓰레드 객체를 다시 생성해야!
		t2.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("0." + Thread.currentThread().getName());
		}
		// 쓰레드 실행 중 에러/예외가 발생해도 그 쓰레드만 영향을 받지, 다른 쓰레드는 영향 받지 않는다.
	} // main() 끝. --> 하지만 main 외 다른 쓰레드가 실행 중임으로 프로그램이 종료되지 않는다.
} // 클래스 끝.

// 쓰레드를 만들면 그 후는 쓰레드가 할 일을 제공해야 한다 --> 할 일을 명시한 것이 run() --> 그래서 run()을 오버라이딩하거나 구현하는 것이다.

class ThreadEx01 extends Thread { // Thread 클래스를 상속 받아서 run() 오버라이딩
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("1." + getName()); // superclass Thread의 getName() 바로 호출
		}
	} // run() 끝.
} // 클래스 끝.

class ThreadEx02 implements Runnable { // Runnable 인터페이스를 구현 --> Runnable에는 추상메서드 run() 밖에 없기에 Runnable 구현 means run() 구현
	public void run() {
		for(int i = 0; i < 5; i++) {
			// Thread.currentThread() -->  현재 실행중인 Thread를 반환한다.
			System.out.println("2." + Thread.currentThread().getName());
			/* ThreadEx02는 Thread클래스와 연결고리가 없다!
			 * 	>> 그래서 바로 접근하지 못하고 Thread클래스의 currentThread() 메서드 사용한다.
			 * 	>> currentThread()가 현재 실행중인 Thread를 반환하면, 이제 그것을 이용해서 Thread 클래스에 접근할 수 있다.
			 */
		}
	} // run() 끝.
} // 클래스 끝.