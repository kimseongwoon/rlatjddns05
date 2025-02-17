package sec01.exam06;

import sec01.exam03.RemoteControl;

import sec01.exam04.Audio;

import sec01.exam04.Television;

public class MyClass {
	// 필드
	RemoteControl rc = new Television();

	// 생성자
	MyClass() {
	}

	MyClass(RemoteControl rc) {
      this.rc = rc;
	  rc.turnOn();
	  rc.setVolume(5);
	}

	// 메소드
	void methodA() {	// 오디오를 키는 메소드
	  RemoteControl rc = new Audio();
	  rc.turnOn();
	  rc.setVolume(5);
	}
	
	void methodB(RemoteControl rc) { // TV를 키는 메소드
	  rc.turnOn();
      rc.setVolume(5); 
	}
}
