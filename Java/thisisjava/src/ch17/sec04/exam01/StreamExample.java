package ch17.sec04.exam01;

import java.util.*;
import java.util.stream.*;

public class StreamExample {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++) {
			list.add(
				new Product(
					i, 
					"상품" + i, 
					"멋진회사", 
					(int)(Math.random() * 10000)
				)
			);
		}
		
		// 컬렉션 객체인 List로부터 스트림 얻기
		Stream<Product> stream = list.stream();
		stream.forEach(p -> System.out.println(p));
	}
}
