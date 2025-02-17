package ch16.sec01;

public class LambdaExample {
	
	public static void main(String[] args) {
		// Calculable 인터페이스이 익명(이름이 없는) 구현 객체
		new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println(x + "와 " + y + "의 calculate1함수입니다");
			}
		};
		// 인터페이스로 실행
		action1(
			new Calculable() {
				@Override
				public void calculate(int x, int y) {
					System.out.println(x + "와 " + y + "의 calculate2함수입니다");
				}
			}
		);
		//System.out.println();
		
		// 람다식으로 변경 실행
		action1((x, y) -> {
			// 처리내용
			int result = x + y;
			System.out.println(result);
		});
		// 람다식으로 변경 실행
		action1((x, y) -> {
			// 처리내용
			int result = x - y;
			System.out.println(result);
		});
	}
	
	public static void action1(Calculable calculable) {
		int x = 10;
		int y = 4;
		calculable.calculate(x, y);
	}

}
