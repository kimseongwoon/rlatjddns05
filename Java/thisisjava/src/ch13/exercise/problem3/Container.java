package ch13.exercise.problem3;

public class Container<K, v> {
	private K key;
	private v value;
	
	public K getKey() {
		return this.key;
	}
	public v getValue() {
		return this.value;
	}
	
	public void set(K key, v value) {
		this.key = key;
		this.value = value;
	}
}