package sec02.exam04;

import sec02.exam02.Bus; 

import sec02.exam02.Taxi;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.drive(bus);	// 자동형변환이 되어 인수전달
		driver.drive(taxi); // 자동형변환이 되어 인수전달
	}

}
