package ch16.sec02;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();
		
		// 구현코드가 2줄 이상일 때(중괄호 생략 불가능)
		person.action(() -> {
			// 실제 work구현 코드
			System.out.println("출근을 합니다.");
			System.out.println("프로그래밍을 합니다.");
		});
		// 구현코드가 한 줄일 때(중괄호 생략 가능)
		person.action(() -> System.out.println("퇴근합니다."));
	}
}
