package practice04;

public class PrinterExample {
	public static void main(String[] args) {
		//Printer p1 = new Printer();	// 객체 생성

		Printer.println(10);        // 객체 생성없이 메소드 호출       
		Printer.println(true);
        Printer.println(5.7);
		Printer.println("홍길동");
	}
}