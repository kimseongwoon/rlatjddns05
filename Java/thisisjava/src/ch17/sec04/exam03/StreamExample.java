package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
	static int sum = 0;
	
	public static void main(String[] args) {
		// 숫자 범위로부터 스트림 얻기(1에서 100까지 총합 구하기)
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
	}
}
