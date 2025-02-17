package ch13;

public class BoxExample1 {
	public static void main(String[] args) {
//		Box box = new Box();
//		box.content = "aa";		// String
//		box.content = 1;		// Integer
//		box.content = 1.3;		// Double
//		
//		Object obj1 = box.content;
//		String str1 = (String)box.content;
//		Integer int1 = (Integer)box.content;
//		Double dbl1 = (Double)box.content;
		
		// String타입으로 generic
		Box<String, String, String> boxStr = new Box<>();
		boxStr.content = "안녕하세요";
		String str1 = boxStr.content;
		System.out.println(str1);
		
		// Integer타입으로 generic
		Box<Integer, String, String> boxInt = new Box<>();
		boxInt.content = 1;
		Integer int1 = boxInt.content;
		System.out.println(int1);
		
		// Double타입으로 generic
		Box<Double, String, String> boxDbl = new Box<>();
		boxDbl.content = 1.5;
		Double dbl1 = boxDbl.content;
		System.out.println(dbl1);
	}
}
