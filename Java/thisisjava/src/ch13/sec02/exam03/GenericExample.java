package ch13.sec02.exam03;

public class GenericExample {
	
	public static void main(String[] args) {
		Box box1 = new Box();
		box1.content = "100";

		Box box2 = new Box();
		box2.content = "100";
		
		Box box3 = new Box();
		box3.content = 100;

		boolean result1 = box1.compare(box2); // type이 같음(String, String)
		System.out.println("result1: " + result1);

		boolean result2 = box1.compare(box3); // type이 다름(String, Integer)
		System.out.println("result2: " + result2);
		
		boolean result3 = box2.compare(box3); // type이 다름(String, Integer)
		System.out.println("result3: " + result3);
		
		Box<String> boxStr1 = new Box<>();
		//boxStr1.content = 100; // error. T타입이 String
		boxStr1.content = "100";
		
		Box<Integer> boxInt1 = new Box<>();
		boxInt1.content = 100; 
		//boxInt1.content = "100"; // error. T타입이 Integer
	}
}
