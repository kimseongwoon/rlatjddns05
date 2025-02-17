package sec03.exam03;

public class Car {
	//필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	//생성자
	Car() {
	}

	Car(String model) {
	  this.model = model;     // 밑에 있는 3개의 매개변수가 있는 생성자 호출
	}
	
	Car(String model, String color) {
		this.model = model;   // 밑에 있는 3개의 매개변수가 있는 생성자 호출
		this.color = color;                      
	}
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
  }