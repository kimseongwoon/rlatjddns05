package ch17.sec08;

import java.util.Arrays;

public class LoopingExample {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 }; 
			
		// 최종 처리하는 메소드가 없어서 peek가 실행이 되지 않음
		Arrays.stream(intArray)
			.filter(a -> a % 2 == 0)  // 짝수만 가져오기
			.peek(n -> System.out.println(n));
		
		// 최종 처리하는 메소드 sum이 있어서 peek가 실행
		Arrays.stream(intArray)
			.filter(a -> a % 2 == 0)		// 짝수만 가져오기
			.peek(n -> System.out.println(n))
			.sum();
		
		//최종 처리 메소드 forEach()를 이용해서 반복 처리
		Arrays.stream(intArray)
			.filter(a -> a % 2 == 0)
			.forEach(n -> System.out.println(n)); 	//최종 처리이므로 동작함
	}
}
