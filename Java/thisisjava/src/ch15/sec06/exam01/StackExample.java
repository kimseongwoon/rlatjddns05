package ch15.sec06.exam01;

import java.util.*;

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();

		// 동전 넣기(push)
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		// 동전 꺼내기(pop) - LIFO구조
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
		}
	}
}
