package study;

class Ex02_InterfaceTest02 {
	public static void main(String[] args) {
	A2 a = new A2();
	a.autoPlay(new B2());
	a.autoPlay(new C2());
	}
}

class A2 {
	void autoPlay(I i) {
		i.play();
	}
}

interface I {
	public abstract void play();
}

class B2 implements I {
	public void play() {
		System.out.println("play in B2 class");
	}
}

class C2 implements I {
	public void play() {
		System.out.println("play in C2 class");
	}
}