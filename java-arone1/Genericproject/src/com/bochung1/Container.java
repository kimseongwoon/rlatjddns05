package com.bochung1;

public class Container<K, V> {
	private K key;
	private V value;
	
	public void set(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K get() {
		return key;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}
