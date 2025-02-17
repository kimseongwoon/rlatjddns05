package ch13.sec03;

public class GenericExample {
	
	// 제너릭 메소드
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.set(t);
		
		return box;
	}
	
	public static void main(String[] args) {
		// 제너릭 메소드 호출
		Box<Integer> boxInt = boxing(100);    // T를 Integer로 대체
		int intValue = boxInt.get();
		System.out.println(intValue);
		
		// 제너릭 메소드 호출		
		Box<String> boxStr = boxing("홍길동");  // T를 String으로 대체
		String strValue = boxStr.get();
		System.out.println(strValue);
	}
}
