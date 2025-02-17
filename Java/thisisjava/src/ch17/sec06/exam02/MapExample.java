package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.*;

public class MapExample {
	
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5 };
		
		IntStream intStream = Arrays.stream(intArray);
		// Int형을 Double형으로 바꿔서 Stream생성
		intStream.asDoubleStream()
			.forEach(a -> System.out.println(a));
		
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		// box는 primitive타입(ex) int, double, ...)을 Wrapper 혹은 Box타입(Integer, Double, ...)으로 변경
		intStream.boxed()
			.forEach(a -> System.out.println(a.intValue()));
		
	}
}
