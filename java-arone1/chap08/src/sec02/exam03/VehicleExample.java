package sec02.exam03;

public class VehicleExample {
	public static void main(String[] args) {
		Bus vehicle = new Bus();
		vehicle.run(); // 버스가 달립니다.
		//vehicle.checkFare(); // error -> Vehicle 인터페이스에는 checkFare메소드가 없음
		
		Bus bus = (Bus)vehicle;	// 강제형변환(casting)
		bus.run();
		bus.checkFare();	// Bus의 객체인 bus에서 checkFare메소드가 존재하므로 실행가능
	}
}
