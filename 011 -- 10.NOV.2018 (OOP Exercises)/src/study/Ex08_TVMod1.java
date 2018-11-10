package study;

public class Ex08_TVMod1 {
	public static void main(String args[]) {
		MyTv2 t = new MyTv2();

		// check setChannel, getChannel, setVolume, getVolume methods
//		t.setChannel(10);
//		System.out.println("CH:"+t.getChannel());
//		t.setVolume(20);
//		System.out.println("VOL:"+t.getVolume());
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}
}

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int previousChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		// isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
		isPowerOn = !isPowerOn;
	}
	
	int getVolume() { return volume; }
	
	void setVolume(int input) {
		// 유효성체크
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) { return; }
		volume = input;
		}
	
	void volumeUp() {
		// volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다.
		if(volume < MAX_VOLUME) { volume++; }
	}
	
	void volumeDown() {
		// volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다.
		if(volume > MIN_VOLUME) { volume--; }
	}
	
	int getChannel() { return channel; }
	
	void setChannel(int channel) {
		// 유효성 체크
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) { return; }
		previousChannel = this.channel; // channel 바꿀 때 이전 channel이 무엇인지 기록
		this.channel = channel; }
	
	void gotoPrevChannel() { // 이전 channel로 돌아감과 동시에 현재 channel을 이전 channel로 새롭게  기록
		int temp = channel;
		channel = previousChannel;
		previousChannel = temp;
		
		// setChannel(previousChannel)
	}
	
	void channelUp() {
		// channel의 값을 1 증가시킨다.
		// 만일 channel이 MAX_CHANNEL이면, channel의 값을 MIN_CHANNEL로 바꾼다.
		if(channel == MAX_CHANNEL) {
			previousChannel = channel; 
			channel = MIN_CHANNEL; }
		else {
			previousChannel = channel; 
			channel++; } // else 붙여야 한다 --> if가 실행되도 이 부분이 그 다음에 실행되기 때문이다.
	}
	
	void channelDown() {
		// channel의 값을 1 감소시킨다.
		// 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
		if(channel == MIN_CHANNEL) { channel = MAX_CHANNEL; }
		else { channel--; }
	}
}
