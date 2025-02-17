package ch13.sec02.exam03;

public class Box<T> {
	public T content;
	
	public boolean compare(Box<T> other) {
		// content의 equals는 Object클래스의 equals메소드를 뜻함
		boolean result = content.equals(other.content); 
		return result;
	}
}
