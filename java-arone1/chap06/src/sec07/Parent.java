package sec07;

public class Parent {
	public String name;
	
	public String nation;
	
	public Parent() {
		this("대한민국");
		System.out.println();
	}
	
	public Parent(String nation) {
		this.nation = nation;
		System.out.println();
	}
		
	void method1() {
		System.out.println("Parent의 method1");	
	}

	void method2() {
		System.out.println("Parent의 method2");
	}
}
