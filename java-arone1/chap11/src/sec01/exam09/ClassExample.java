package sec01.exam09;

public class ClassExample {
	public static void main(String[] args) throws Exception {
		// 첫번째 방법
		Class clazz1 = String.class;
		
		// 두번째 방법
		Class clazz2 = Class.forName("java.lang.String");
		
		// 세번째 방법
		String str1 = "Ada";
		Class clazz3 = str1.getClass();
		
		System.out.println(clazz1.getName());				// 클래스 이름 출력(java.lang.String)
		System.out.println(clazz1.getSimpleName());			// 간단한 클래스 이름 출력(String)
		System.out.println(clazz1.getPackage().getName());	// 패키지 이름이 출력(java.lang)
		
		// Car클래스 메타정보 가져오기
		//how1
		Class<Car> clazz = Car.class;
		
		//how2
		//Class clazz = Class.forName("sec01.Car");
		
		//how3
		//Car car = new Car();
		//Class clazz = car.getClass();
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
	}
}
