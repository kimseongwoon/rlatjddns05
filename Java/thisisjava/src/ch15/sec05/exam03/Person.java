package ch15.sec05.exam03;

public class Person implements Comparable<Person> {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * 정렬시 age(나이)를 기준으로 오름차순 정렬됨
	 */
	@Override
	public int compareTo(Person o) {
		if(age < o.age) return -1;
		else if (age == o.age) return 0;
		else return 1;
	}
	
	//5. List<Board> 변수 = new ArrayList<>(); 
		//6. Map<String, Integer> 변수 = new HashMap<>();
}
