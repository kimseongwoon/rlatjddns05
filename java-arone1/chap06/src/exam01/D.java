package exam01;

import practice03.A;

public class D extends A {
    private String field;

	public D() {
		super(); // A의 기본생성자를 호출
		this.field = "value";	// A의 field 멤버변수
		this.method();	// A의 메소드
	}

	private void method() {
	}
}
