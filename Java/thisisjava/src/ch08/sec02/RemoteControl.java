package ch08.sec02;

public interface RemoteControl {
	// 상수필드
	int ABCD = 11;  // == public static final int ABCD = 1;
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// public 추상메소드
	void turnOn();  // == public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메소드
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			//추상 메소드 호출하면서 상수 필드 사용
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	// 정적 메소드 선언
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}

}
