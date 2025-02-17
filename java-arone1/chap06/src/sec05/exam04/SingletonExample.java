package sec05.exam04;

public class SingletonExample {
	public static void main(String[] args) {
		//Singleton obj1 = new Singleton();	// error
		//Singleton obj1 = nepw Singleton();	// error
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 Singleton 객체 입니다.");
		}
	}
}
