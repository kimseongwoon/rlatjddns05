package ch17.sec10;

import java.util.*;

public class OptionalExample {
	
	public static void main(String[] args) {
		// Optional클래스는 NullPointer방지를 위해 많이 사용
		List<Integer> list = new ArrayList<>();  // 원소에 값이 없는 상태

		// isPresent로 값이 있는지 체크하는 방법
		OptionalDouble optional = list.stream()
				.mapToInt(Integer::intValue)
				.average();
		if(optional.isPresent()) { // optional에 값이 실제 있으면
			System.out.println("방법1_평균: " + optional.getAsDouble());
		} else {
			System.out.println("방법1_평균: 0.0(없음)");
		}
		
		// orElse를 이용해서 값이 없을 때 값을 지정하는 방법
		double avg = list.stream()
				.mapToInt(Integer::intValue)
				.average().orElse(0.0);
		System.out.println("방법2_평균: " + avg);
		
		// ifPresent로 값이 있는지 체크하여 로직 실행
		list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.ifPresent(a -> System.out.println("방법3_평균: " + a));
		
 		avg = list.stream()
 	 			.mapToInt(Integer :: intValue)
 	 			.average()
 	 			.getAsDouble();  // <- 여기서 exception
 		
	}
}
