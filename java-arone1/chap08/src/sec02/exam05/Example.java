package sec02.exam05;

public class Example {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();		
		
		InterfaceA ia = impl;	// InterfaceA로 자동형변환
	    ia.methodA();	       // ImplementationC의 methodA를 실행
		System.out.println(); // 한 줄 띄우기
		
		InterfaceB ib = impl;	// InterfaceB로 자동형변환
		((ImplementationC) ib).methodB();      // ImplementationC의 methodB를 실행
		System.out.println(); // 한 줄 띄우기
		
		InterfaceC ic = impl; // InterfaceC로 자동형변환
		ic.methodA();        // ImplementationC의 methodB를 실행
		((ImplementationC) ic).methodB();       // ImplementationC의 methodA를 실행
		ic.methodC();      // ImplementationC의 methodC를 실행
	}  
}
