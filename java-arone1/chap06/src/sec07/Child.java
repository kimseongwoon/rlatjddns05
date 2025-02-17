package sec07;

public class Child extends Parent {
	private int studentNo;
	private String name;
	
	public Child() {
		this("홍길동");
	}
	
	public Child(String name) {
		this.name = name;
	}
	
	public Child(String name, int studentNo) {
		//super(name);
		
		this.name = name;
		this.studentNo = studentNo;
	}
	
	void method3() {
		System.out.println("Child의 method3");
	}
	
	@Override
	void method2() {
		System.out.println("Child의 method2");
		super.method2(); // 부모클래스의 method2메소드 호출 
	}
}
