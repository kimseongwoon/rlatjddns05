package sec01.exam04;

import sec01.exam03.RemoteControl;

public class Audio implements RemoteControl {
    private int volume;	// 필드(멤버 변수)
	
	public void turnOn() {           // RemoteControl에 있는 turnOn메소드
		System.out.println("Audio를 켭니다.");
	}
	public void turnOff() {          // RemoteControl에 있는 turnOff메소드  
		System.out.println("Audio를 끕니다.");
	}
	public void setVolume(int vol) { // RemoteControl에 있는 setVolume메소드 
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = vol;
		}
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}
	
	// 매소드의 매개 타입이 인터페이스
	public void a(RemoteControl b) {
	
	}
}
