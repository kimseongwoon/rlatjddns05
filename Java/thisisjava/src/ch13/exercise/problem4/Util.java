package ch13.exercise.problem4;

public class Util {
	public <K, V> V getValue(Pair<K, V> p, K k) {
		if ( p.getKey() == k ) {
			return p.getValue();
		} else {
			return null;
		}
	}
}
