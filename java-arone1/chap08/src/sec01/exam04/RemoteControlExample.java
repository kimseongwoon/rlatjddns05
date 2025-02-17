package sec01.exam04;

import sec01.exam03.RemoteControl;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc1;  
		RemoteControl rc2;
	
		rc1 = new Television();
		rc1.turnOn();
		rc1.setVolume(10);
		rc1.turnOff();
		
		rc2 = new Audio();
		rc2.turnOn();
		rc2.setVolume(10);
		rc2.turnOff();
		
		Television tv1 = new Television();
		Audio audio1 = new Audio();
		audio1.a(audio1);	// 매개값으로 RemoteControl 구현한 구현 객체 대입
		audio1.a(tv1);		// 매개값으로 RemoteControl 구현한 구현 객체 대입
	}
}
