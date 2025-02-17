package ch16.sec05;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		
		//정적 메소드일 경우
		//람다식
		//person.action((x, y) -> Computer.staticMethod(x, y));		
		//메소드 참조
		person.action(Computer::staticMethod);
		
		//인스턴스 메소드일 경우
		Computer com = new Computer();
		//람다식
		//person.action((x, y) -> com.instanceMethod(x, y));		
		//메소드 참조
		person.action(com::instanceMethod);
		
		// 매개변수의 메소드 참조 (a, b) -> a.compareToIgnoreCase(b);
		ordering(String::compareToIgnoreCase);
	}
	
	private static void ordering(Comparable comparable) {
		String a = "홍길동";
		String b = "김길동";

		int result = comparable.compare(a, b);

		if(result < 0) {
			System.out.println(a + "은 " + b + "보다 앞에 옵니다.");
		} else if(result == 0) {
			System.out.println(a + "은 " + b + "과 같습니다.");
		} else {
			System.out.println(a + "은 " + b + "보다 뒤에 옵니다.");
		}
	}
}
