package sec07;

public class ChildExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		
		child.method1();	// Parent의 method1
		child.method2();	// Child의 method2
		child.method3();	// Child의 method3
		
		Parent parent = new Parent();
		//parent.method3();	// Child의 method3
		parent.method2();	// Parent의 method2
	}

}
